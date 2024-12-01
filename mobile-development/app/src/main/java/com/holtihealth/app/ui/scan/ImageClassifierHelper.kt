package com.holtihealth.app.ui.scan

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import com.google.android.gms.tflite.client.TfLiteInitializationOptions
import com.google.android.gms.tflite.gpu.support.TfLiteGpu
import com.holtihealth.app.ml.ChiliDiseaseDetection
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import org.tensorflow.lite.task.gms.vision.TfLiteVision
import java.nio.ByteBuffer
import java.nio.ByteOrder

class ImageClassifierHelper(
    private val context: Context,
    private val classifierListener: ClassifierListener,
) {
    private lateinit var model: ChiliDiseaseDetection
    private var isGPUSupported: Boolean = false
    private var isModelReady: Boolean = false

    init {
        initializeTfLite()
    }

    private fun initializeTfLite() {
        TfLiteGpu.isGpuDelegateAvailable(context).onSuccessTask { gpuAvailable ->
            val optionsBuilder = TfLiteInitializationOptions.builder()
            if (gpuAvailable) {
                isGPUSupported = true
                optionsBuilder.setEnableGpuDelegateSupport(true)
            }
            TfLiteVision.initialize(context, optionsBuilder.build())
        }.addOnSuccessListener {
            Log.d(TAG, "TensorFlow Lite Vision berhasil diinisialisasi.")
            setupModel()
        }.addOnFailureListener {
            classifierListener.onError("Error: TensorFlow Lite Vision belum terinisialisasi.")
        }
    }

    private fun setupModel() {
        try {
            model = ChiliDiseaseDetection.newInstance(context)
            isModelReady = true
            Log.d(TAG, "Model berhasil diinisialisasi.")
        } catch (e: Exception) {
            classifierListener.onError("Error: Gagal menginisialisasi model. ${e.message}")
            Log.e(TAG, "setupModel: ${e.message}")
        }
    }

    fun classifyImage(imageUri: Uri) {
        if (!isModelReady) {
            classifierListener.onError("Error: Model belum siap digunakan.")
            return
        }

        val bitmap = uriToBitmap(imageUri) ?: run {
            Log.d(TAG, "Processing imageUri: $imageUri")
            classifierListener.onError("Error: Gambar tidak dapat dimuat.")
            return
        }

        // Resize Bitmap to 224x224 (input shape of the model)
        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)

        // Convert Bitmap to ByteBuffer
        val byteBuffer = convertBitmapToByteBuffer(resizedBitmap)

        // Prepare TensorBuffer
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Run inference and get results
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer
        val probabilities = outputFeature0.floatArray


        val classNames = listOf(
            "Bercak Daun", "Busuk Buah Antraknosa", "Kutu Daun",
            "Kutu Daun Persik", "Kutu Kebul", "Lalat Buah",
            "Layu", "Sehat", "Thrips & Tungau",
            "Ulat Grayak", "Virus Kuning"
        )

        val predictedIndex = probabilities.indices.maxByOrNull { probabilities[it] } ?: -1
        val predictedLabel = if (predictedIndex != -1) classNames[predictedIndex] else "Unknown"
        val confidence = probabilities[predictedIndex]

        Log.d("ImageClassifierHelper", "Classification outputFeature0: $outputFeature0 (Confidence: $confidence) probabilities $probabilities")


        classifierListener.onResults(predictedLabel, confidence)
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(4 * 224 * 224 * 3) // 4 bytes per float, 3 channels (RGB)
        byteBuffer.order(ByteOrder.nativeOrder())

        val intValues = IntArray(224 * 224)
        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        for (pixel in intValues) {
            val r = ((pixel shr 16) and 0xFF) / 255.0f
            val g = ((pixel shr 8) and 0xFF) / 255.0f
            val b = (pixel and 0xFF) / 255.0f

            byteBuffer.putFloat(r)
            byteBuffer.putFloat(g)
            byteBuffer.putFloat(b)
        }

        return byteBuffer
    }

    private fun uriToBitmap(imageUri: Uri): Bitmap? {
        return try {
            context.contentResolver.openInputStream(imageUri).use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }?.let { bitmap ->
                val maxSize = 1024
                val width = bitmap.width
                val height = bitmap.height
                val scaleFactor = Math.min(maxSize.toFloat() / width, maxSize.toFloat() / height)
                Bitmap.createScaledBitmap(bitmap, (width * scaleFactor).toInt(), (height * scaleFactor).toInt(), true)
            }
        } catch (e: Exception) {
            Log.e(TAG, "uriToBitmap: Gagal memuat gambar. ${e.message}")
            null
        }
    }


    fun close() {
        model.close()
    }

    interface ClassifierListener {
        fun onResults(predictedLabel: String, confidence: Float)
        fun onError(error: String)
    }

    companion object {
        private const val TAG = "ImageClassifierHelper"
    }
}
