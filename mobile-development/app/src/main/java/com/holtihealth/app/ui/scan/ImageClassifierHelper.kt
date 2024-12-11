package com.holtihealth.app.ui.scan

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import com.holtihealth.app.reduceFileImage
import com.holtihealth.app.retrofit.ApiConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageClassifierHelper(
    private val context: Context,
    private val classifierListener: ClassifierListener,
) {

    fun classifyImage(imageUri: Uri) {
        val bitmap = uriToBitmap(imageUri)
        if (bitmap == null) {
            classifierListener.onError("Error: Unable to load image.")
            return
        }

        val imageFile = bitmapToFile(bitmap, "temp_image.jpg")
        if (imageFile == null) {
            classifierListener.onError("Error: Unable to process image.")
            return
        }

        val reducedImageFile = imageFile.reduceFileImage()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val requestBody = reducedImageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val multipartBody = MultipartBody.Part.createFormData("file", reducedImageFile.name, requestBody)

                val apiService = ApiConfig.getApiService()
                val response = apiService.uploadImage(multipartBody)

                withContext(Dispatchers.Main) {
                    if (response.status == "success") {
                        classifierListener.onResults(response.prediction ?: "Unknown", response.confidence ?: "")
                        Log.e("Image Classifier", "confidience : ${response.prediction}")
                    } else {
                        classifierListener.onError("Error: ${response.message}")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e("ImageClassifierHelper", "Parsing error: ${e.message}")
                    classifierListener.onError("Error: ${e.message}")
                }
            }
        }
    }

    private fun bitmapToFile(bitmap: Bitmap, fileName: String): File? {
        return try {
            val file = File(context.cacheDir, fileName)
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            file
        } catch (e: Exception) {
            Log.e("ImageClassifierHelper", "bitmapToFile: ${e.message}")
            null
        }
    }

    private fun uriToBitmap(imageUri: Uri): Bitmap? {
        return try {
            context.contentResolver.openInputStream(imageUri).use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        } catch (e: Exception) {
            Log.e("ImageClassifierHelper", "uriToBitmap: Failed to load image. ${e.message}")
            null
        }
    }

    interface ClassifierListener {
        fun onResults(predictedLabel: String, confidence: String)
        fun onError(error: String)
    }
}