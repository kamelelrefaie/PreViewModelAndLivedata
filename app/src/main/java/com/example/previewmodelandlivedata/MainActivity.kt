package com.example.previewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.previewmodelandlivedata.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //declare ViewModel
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init viewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // when we rotate the phone , the value will  be saved this time
        // BUT notice that value has increased as we expected

        //observe the counter value
        viewModel.counter.observe(this){
            binding.counter.text = "counter : $it"
        }

        binding.button.setOnClickListener {
            viewModel.increaseNumber()

            viewModel.counter.observe(this){
                binding.counter.text = "counter : $it"
            }
        }

    }
}