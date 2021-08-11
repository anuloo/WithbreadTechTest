package com.example.withbreadtechtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.withbreadtechtest.api.WBRepository
import com.example.withbreadtechtest.api.WBService
import com.example.withbreadtechtest.databinding.ActivityMainBinding
import com.example.withbreadtechtest.model.MainViewModel
import com.example.withbreadtechtest.model.WBViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val wBService = WBService.getInstance()
        val wBRepository = WBRepository(wBService)
        viewModel = ViewModelProvider(this, WBViewModelFactory(wBRepository)).get(MainViewModel::class.java)


        viewModel.venueList.observe(this, {
            Log.i("MainActivity","venueList observed: $it")
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        viewModel.getAllVenues()

    }
}