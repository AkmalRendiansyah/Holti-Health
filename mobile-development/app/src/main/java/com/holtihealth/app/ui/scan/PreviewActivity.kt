package com.holtihealth.app.ui.scan

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.holtihealth.app.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(imageUriString)

        imageUri?.let {
            binding.previewImageView.setImageURI(it)
        }

        binding.buttonAnalyzeImage.setOnClickListener {
            analyzeImage(imageUri)
        }
    }

    private fun analyzeImage(uri: Uri) {
        // Implement image analysis logic
        // convert the URI to Bitmap or use any image analysis library
    }
}
