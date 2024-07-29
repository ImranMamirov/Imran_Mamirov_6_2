package com.example.imran_mamirov_6_2.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.imran_mamirov_6_2.databinding.FragmentDetailBinding
import com.example.imran_mamirov_6_2.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModel<DetailViewModel>()
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
        Log.e("ololo", "onViewCreated: $id", )
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