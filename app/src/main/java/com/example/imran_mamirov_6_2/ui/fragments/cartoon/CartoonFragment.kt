package com.example.imran_mamirov_6_2.ui.fragments.cartoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imran_mamirov_6_2.R
import com.example.imran_mamirov_6_2.data.base.BaseFragment
import com.example.imran_mamirov_6_2.data.network.model.Character
import com.example.imran_mamirov_6_2.databinding.FragmentCartoonBinding
import com.example.imran_mamirov_6_2.ui.interfaces.OnClick
import com.example.imran_mamirov_6_2.utils.Resource
import com.example.imran_mamirov_6_2.utils.gone
import com.example.imran_mamirov_6_2.utils.showToast
import com.example.imran_mamirov_6_2.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartoonFragment : BaseFragment<FragmentCartoonBinding>(
    FragmentCartoonBinding::inflate
), OnClick {

    private val viewModel by viewModel<CartoonViewModel>()
    private val adapter by lazy {
        CharacterAdapter(this)
    }

    override fun setupViews(view: View) {
        binding.rvCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvCharacters.adapter = adapter
    }

    override fun observeViewModel() {
        viewModel.characters.handleResource(
            isLoading = { visibility ->
                binding.progress.isVisible = visibility
            },
            onSuccess =  { data ->
                adapter.submitList(data)
            }
        )
    }

    override fun onClick(position: Character) {
        val action = CartoonFragmentDirections.actionCartoonFragmentToDetailFragment(position.id)
        findNavController().navigate(action)
    }
}