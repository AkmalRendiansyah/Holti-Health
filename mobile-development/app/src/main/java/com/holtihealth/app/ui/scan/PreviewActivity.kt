package com.holtihealth.app.ui.scan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.holtihealth.app.R
import com.holtihealth.app.databinding.ActivityPreviewBinding


class PreviewActivity : AppCompatActivity(), ImageClassifierHelper.ClassifierListener {

    private lateinit var binding: ActivityPreviewBinding
    private lateinit var imageClassifierHelper: ImageClassifierHelper
    private var isFromCamera: Boolean = false

    private val openGalleryLauncher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        uri?.let {
            openPreviewActivity(it, false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        imageClassifierHelper = ImageClassifierHelper(
            context = this,
            classifierListener = this
        )

        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(imageUriString)
        isFromCamera = intent.getBooleanExtra("isFromCamera", false)

        updateButtonText()

        imageUri?.let {
            binding.previewImageView.setImageURI(it)
        }

        binding.buttonRetake.setOnClickListener {
            handleRetake()
        }

        binding.buttonAnalyzeImage.setOnClickListener {
            if (imageUri != null) {
                analyzeImage(imageUri)
            } else {
                Toast.makeText(this, "Gambar tidak ditemukan.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun analyzeImage(uri: Uri) {
        try {
            imageClassifierHelper.classifyImage(uri)
        } catch (e: Exception) {
            Toast.makeText(this, "Gagal menganalisis gambar: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleRetake() {
        if (isFromCamera) {
            val cameraIntent = Intent(this, CameraActivity::class.java)
            startActivity(cameraIntent)
            finish()
        } else {
            openGalleryLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }

    private fun openPreviewActivity(uri: Uri, isFromCamera: Boolean) {
        val intent = Intent(this, PreviewActivity::class.java)
        intent.putExtra("isFromCamera", isFromCamera)
        intent.putExtra("imageUri", uri.toString())
        startActivity(intent)
        finish()
    }

    private fun updateButtonText() {
        if (isFromCamera) {
            binding.buttonRetake.text = getString(R.string.retake)
        } else {
            binding.buttonRetake.text = getString(R.string.choose_again)
        }
    }

    override fun onResults(predictedLabel: String, confidence: String) {
        val imageUri = intent.getStringExtra("imageUri")
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("resultText", predictedLabel)
        intent.putExtra("confidenceScore", confidence)
        intent.putExtra("imageUri", imageUri)
        startActivity(intent)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
