package com.example.imran_mamirov_6_2.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.imran_mamirov_6_2.data.repository.Repository
import com.example.imran_mamirov_6_2.databinding.FragmentDetailBinding
import com.example.imran_mamirov_6_2.di.ApiServiceBuilder
import com.example.imran_mamirov_6_2.utils.Resource

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private val apiService = ApiServiceBuilder.apiService
    private val repository = Repository(apiService)
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id
        viewModel = ViewModelProvider(this, DetailViewModelFactory(repository))[DetailViewModel::class.java]

        initView(id)
    }

    private fun initView(id: Int) = with(binding) {
        viewModel.getById(id).observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Error -> {
                }

                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    val character = it.data
                    name.text = character.name
                    status.text = character.status
                    gender.text = character.gender
                    lastLocation.text = character.location.name
                    image.load(character.image)
                }
            }
        })
    }
}