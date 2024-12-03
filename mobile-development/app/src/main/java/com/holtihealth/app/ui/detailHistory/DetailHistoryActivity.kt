package com.holtihealth.app.ui.detailHistory

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

import com.holtihealth.app.MyApplication
import com.holtihealth.app.R
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.database.HistoryWithDisease
import com.holtihealth.app.databinding.ActivityDetailHistoryBinding
import com.holtihealth.app.ui.detailArticle.DetailArticleViewModel

class DetailHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoryBinding

    private val myApplication by lazy {
        application as? MyApplication ?: throw IllegalStateException("Application is not an instance of MyApplication")
    }

    private val detailHistoryViewModel: DetailHistoryViewModel by lazy {
        val historyId = intent.getIntExtra("HISTORY_ID", 0)
        ViewModelProvider(
            this,
            ViewModelFactory(historyRepository = myApplication.historyRepository, historyId = historyId)
        )[DetailHistoryViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Observe data detail
        detailHistoryViewModel.getDetail.observe(this) { historyWithDisease ->
            Log.d("DetailHistoryActivity", "Received data: $historyWithDisease")
            historyWithDisease?.let { showHistoryDetail(it) }
        }
    }

    private fun showHistoryDetail(historyWithDisease: HistoryWithDisease) {
        val history = historyWithDisease.history
        val disease = historyWithDisease.disease

        binding.resultTextView.text = disease.name
        binding.indicationText.text = disease.symptoms
        binding.controlText.text = disease.control

        Glide.with(this)
            .load(history.photoUri)
            .into(binding.resultImageView)

        Log.d("DetailHistoryActivity", "photoUri: ${history.photoUri}")
    }
}
