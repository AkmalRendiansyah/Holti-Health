package com.holtihealth.app.ui.scan

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.holtihealth.app.MyApplication
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.database.History
import com.holtihealth.app.databinding.ActivityResultBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private val myApplication by lazy {
        application as? MyApplication ?: throw IllegalStateException("Application is not an instance of MyApplication")
    }

    private val historyRepository by lazy { myApplication.historyRepository }
    private val resultViewModel: ResultViewModel by viewModels {
        ViewModelFactory(diseaseRepository = myApplication.diseaseRepository)
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

                val formattedTime = formatToIndonesianTime((System.currentTimeMillis()))

                val history = History(
                    scanTime = formattedTime,
                    photoUri = imageUriString ?: "",
                    diseaseId = disease.id
                )
                lifecycleScope.launch {
                    historyRepository.insertHistory(history)
                }

            } else {
                binding.indicationText.text = "Data gejala tidak ditemukan."
                binding.controlText.text = "Data pengendalian tidak ditemukan."
            }
        })
    }

    private fun formatToIndonesianTime(timestamp: Long): String{
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))
        return dateFormat.format(timestamp)
    }
}
