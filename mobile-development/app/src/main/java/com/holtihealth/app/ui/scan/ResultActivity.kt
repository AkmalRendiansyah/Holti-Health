package com.holtihealth.app.ui.scan

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.holtihealth.app.MainActivity
import com.holtihealth.app.MyApplication
import com.holtihealth.app.R
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.database.History
import com.holtihealth.app.databinding.ActivityResultBinding
import com.holtihealth.app.formatToIndonesianTime
import com.holtihealth.app.saveImageToInternalStorage
import com.holtihealth.app.ui.history.HistoryFragment
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
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

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Hasil" // Set title for the screen
            setDisplayHomeAsUpEnabled(true) // Enable back button
        }

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

        resultViewModel.getDiseaseDetails(resultText).observe(this) { disease ->
            if (disease != null) {
                binding.indicationText.text = disease.symptoms
                binding.controlText.text = disease.control

                val formattedTime = formatToIndonesianTime(System.currentTimeMillis())
                val imageUri = Uri.parse(imageUriString)
                val fileName = "result_image_${System.currentTimeMillis()}.jpg"
                val imagePath = saveImageToInternalStorage(this, imageUri, fileName)

                val history = History(
                    scanTime = formattedTime,
                    photoUri = imagePath ?: "",
                    diseaseId = disease.id
                )
                lifecycleScope.launch {
                    historyRepository.insertHistory(history)
                }

            } else {
                binding.indicationText.text = "Data gejala tidak ditemukan."
                binding.controlText.text = "Data pengendalian tidak ditemukan."
            }
        }
    }

    // Handle back button in action bar
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Tutup `ResultActivity` agar tidak kembali saat tombol "back" ditekan lagi
        return true
    }

    override fun onBackPressed() {
        // Mengarahkan pengguna kembali ke MainActivity dan menutup ResultActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()  // Menutup ResultActivity agar tidak dapat kembali
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.result_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_camera -> {
                startCameraX()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }
}
