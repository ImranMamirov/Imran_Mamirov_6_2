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
import com.example.imran_mamirov_6_2.R
import com.example.imran_mamirov_6_2.data.base.BaseFragment
import com.example.imran_mamirov_6_2.databinding.FragmentDetailBinding
import com.example.imran_mamirov_6_2.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private val viewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun setupViews(view: View) {
        binding = FragmentDetailBinding.bind(view)
        val id = args.id
        Log.e("ololo", "onViewCreated: $id")
        initView(id)
    }

    override fun observeViewModel() {
        viewModel.getById(args.id).observe(viewLifecycleOwner) { resource ->
            handleResource(resource) { character ->
                character?.let {
                    binding.apply {
                        name.text = it.name
                        status.text = it.status
                        gender.text = it.gender
                        lastLocation.text = it.location.name
                        image.load(it.image)
                    }
                }
            }
        }
    }

    private fun initView(id: Int) {
        // Any additional view initialization can be done here if needed
    }
}