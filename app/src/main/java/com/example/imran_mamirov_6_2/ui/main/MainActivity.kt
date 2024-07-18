package com.example.imran_mamirov_6_2.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.imran_mamirov_6_2.R
import com.example.imran_mamirov_6_2.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter
    private val viewModel: CharacterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        adapter = CharacterAdapter()
        binding.rvCharacters.adapter = adapter
    }

    private fun setupObserve() {
        viewModel.getCharacters().observe(this){
            adapter.submitData(this.lifecycle,it)
        }
    }
}