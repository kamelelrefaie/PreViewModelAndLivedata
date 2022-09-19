package com.example.previewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
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
        // BUT notice that value didn't increase as we expected
        //to solve this , we must use any observable data holder class like : livedata,stateflow ...

        binding.counter.text = "counter : ${viewModel.counter}"

        binding.button.setOnClickListener {
            viewModel.increaseNumber()
            binding.counter.text = "counter : ${viewModel.counter}"

        }

    }
}