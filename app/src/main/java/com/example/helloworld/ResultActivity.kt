package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()

        updateText(getExtraTextKey())
    }

    private fun setUpView() {
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getExtraTextKey(): String {
        val defaultString = getString(R.string.no_text_key)

        return intent.extras?.getString(TEXT_KEY, defaultString).toString()
    }

    private fun updateText(text: String) {
        binding.title.text = text
    }

    companion object {
        const val TEXT_KEY = "@text_key"
    }
}