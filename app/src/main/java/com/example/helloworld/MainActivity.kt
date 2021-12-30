package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        setUpDefaultText(savedInstanceState)
        setUpListeners()
    }

    private fun setUpView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpDefaultText(instance: Bundle?) {
        val savedText = instance?.getString(ResultActivity.TEXT_KEY)

        savedText?.let { text ->
            updateText(text)
        }
    }

    private fun setUpListeners() {
        setUpButtonClickListener()
    }

    private fun setUpButtonClickListener() {
        binding.button.setOnClickListener {
            val editText = editTextValue()

            updateText(editText)
            openResultPageWithExtra(editText)
        }
    }

    private fun editTextValue() : String = binding.editText.text.toString()

    private fun updateText(text: String) {
        binding.title.text = text
    }

    private fun openResultPageWithExtra(text: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.TEXT_KEY, text)

        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ResultActivity.TEXT_KEY, editTextValue())
    }
}