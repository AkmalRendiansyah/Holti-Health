package com.holtihealth.app.ui.scan

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.holtihealth.app.MyApplication
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val resultViewModel: ResultViewModel by viewModels{
        ViewModelFactory(diseaseRepository = (application as MyApplication).diseaseRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val resultText = intent.getStringExtra("resultText") ?: "No result"
        val imageUriString = intent.getStringExtra("imageUri")

        binding.resultTextView.text = resultText

        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            Glide.with(this)
                .load(imageUri)
                .into(binding.resultImageView)
        } else {
            Log.e("ResultActivity", "No imageUri received!")
        }

        resultViewModel.getDiseaseDetails(resultText).observe(this, Observer { disease ->
            if (disease != null) {
                binding.indicationText.text = disease.symptoms
                binding.controlText.text = disease.control
            } else {
                binding.indicationText.text = "Data gejala tidak ditemukan."
                binding.controlText.text = "Data pengendalian tidak ditemukan."
            }
        })

    }
}
