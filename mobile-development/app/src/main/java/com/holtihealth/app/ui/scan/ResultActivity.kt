package com.holtihealth.app.ui.scan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.holtihealth.app.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val resultText = intent.getStringExtra("resultText") ?: "No result"



        binding.resultTextView.text = resultText



        binding.buttonBack.setOnClickListener {
            finish()
        }
    }
}
