package com.holtihealth.app.ui.scan


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.holtihealth.app.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity(), ImageClassifierHelper.ClassifierListener {

    private lateinit var binding: ActivityPreviewBinding
    private lateinit var imageClassifierHelper: ImageClassifierHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageClassifierHelper = ImageClassifierHelper(
            context = this,
            classifierListener = this
        )

        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(imageUriString)

        imageUri?.let {
            binding.previewImageView.setImageURI(it)
        }

        binding.buttonAnalyzeImage.setOnClickListener {
            imageUri?.let { uri -> analyzeImage(uri) }
        }
    }

    private fun analyzeImage(uri: Uri) {
        try {
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            if (bitmap != null) {
                classifyImage(bitmap)
            } else {
                Toast.makeText(this, "Failed to load image: Bitmap is null", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Failed to load image: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun classifyImage(bitmap: Bitmap) {
        // Jalankan klasifikasi menggunakan ImageClassifierHelper
        imageClassifierHelper.classifyImage(bitmap)
    }

    override fun onResults(result: String) {
        // Pindah ke ResultActivity dan kirimkan hasil
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("resultText", result)
            putExtra("inferenceTime", System.currentTimeMillis())
        }
        startActivity(intent)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
