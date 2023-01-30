package com.mergelight.bindingview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.mergelight.bindingview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewByActivityMainBinding()
    }

    private fun setupViewByFindView(){
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        tvText.text = "Hello Sviat"
    }

    private fun setupViewByActivityMainBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.text = "Hello Sviat"
    }
}