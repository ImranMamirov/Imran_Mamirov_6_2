package com.example.imran_mamirov_6_2.ui.fragments.detail

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.imran_mamirov_6_2.R
import com.example.imran_mamirov_6_2.data.base.BaseFragment
import com.example.imran_mamirov_6_2.databinding.FragmentDetailBinding
import com.example.imran_mamirov_6_2.utils.Resource
import com.example.imran_mamirov_6_2.utils.gone
import com.example.imran_mamirov_6_2.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment(R.layout.fragment_detail) {

    private val viewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun setupViews(view: View) {
        binding = FragmentDetailBinding.bind(view)
        val id = args.id
        viewModel.getCharacterById(id)
    }

    override fun observeViewModel() {
        viewModel.characters.handleResource(
            isLoading = {visibility ->
                binding.progress.isVisible = visibility
            },
            onSuccess = { character ->
                binding.progress.apply {
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
        )
    }
}