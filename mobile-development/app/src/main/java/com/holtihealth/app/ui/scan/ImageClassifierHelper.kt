import android.content.Context
import android.graphics.Bitmap
import com.holtihealth.app.ml.ChiliDiseaseDetection
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage

import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.common.ops.CastOp
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.task.vision.classifier.ImageClassifier
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class ImageClassifierHelper(
    val context: Context,

    val classifierListener: ClassifierListener
) {

    private var model: ChiliDiseaseDetection? = null

    init {
        setupModel()
    }

    private fun setupModel() {
        try {
            model = ChiliDiseaseDetection.newInstance(context)
        } catch (e: Exception) {
            e.printStackTrace() // Handle exceptions such as failed loading model
            classifierListener.onError("Failed to load model: ${e.message}")
        }
    }

    fun classifyImage(bitmap: Bitmap) {

        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(224, 224, ResizeOp.ResizeMethod.BILINEAR))
            .add(NormalizeOp(0f, 255f))
            .add(CastOp(DataType.FLOAT32)) // Cast to FLOAT32
            .build()


        val tensorImage = imageProcessor.process(TensorImage.fromBitmap(bitmap))

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(tensorImage.buffer) // Load the tensor image buffer into input buffer


        val outputs = model?.process(inputFeature0)
        val outputFeature0 = outputs?.outputFeature0AsTensorBuffer

        val result = outputFeature0?.floatArray?.joinToString(", ") { it.toString() }


        model?.close()

        classifierListener.onResults(result ?: "No result")
    }

    interface ClassifierListener {
        fun onResults(result: String)
        fun onError(error: String)
    }
}
