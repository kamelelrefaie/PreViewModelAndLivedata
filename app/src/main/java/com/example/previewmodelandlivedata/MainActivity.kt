package com.example.previewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.previewmodelandlivedata.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // when we rotate the phone , the value will not be saved
        var counter = 0
        binding.counter.text = "counter : $counter"

        binding.button.setOnClickListener {
            counter += 1
            binding.counter.text = "counter : $counter"

        }

    }
}