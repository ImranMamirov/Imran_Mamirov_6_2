package com.example.imran_mamirov_6_2.ui.fragments.cartoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.databinding.FragmentCartoonBinding
import com.example.imran_mamirov_6_2.ui.interfaces.OnClick
import com.example.imran_mamirov_6_2.utils.Resource
import com.example.imran_mamirov_6_2.utils.gone
import com.example.imran_mamirov_6_2.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartoonFragment : Fragment(), OnClick {

    private val binding by lazy {
        FragmentCartoonBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: CartoonViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CartoonViewModel::class.java]
        adapter = CharacterAdapter(this)

        binding.rvCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvCharacters.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            when (characters) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), characters.message, Toast.LENGTH_SHORT).show()
                    setProgressVisibility(false)
                }

                is Resource.Loading -> {
                    setProgressVisibility(true)
                }

                is Resource.Success -> {
                    adapter.submitList(characters.data)
                    setProgressVisibility(false)
                }
            }
        }
    }

    private fun setProgressVisibility(isVisible: Boolean) {
        if (isVisible) {
            binding.progress.visible()
        } else {
            binding.progress.gone()
        }
    }

    override fun onClick(position: Character) {

        val action = CartoonFragmentDirections.actionCartoonFragmentToDetailFragment(position.id)
        findNavController().navigate(action)
    }
}