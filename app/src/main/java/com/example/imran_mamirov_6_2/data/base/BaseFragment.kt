package com.example.imran_mamirov_6_2.data.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.imran_mamirov_6_2.utils.Resource
import com.example.imran_mamirov_6_2.utils.showToast

abstract class BaseFragment(@LayoutRes private val layoutResId: Int) : Fragment() {

    private lateinit var binding: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflater.inflate(layoutResId, container, false)
        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        observeViewModel()
    }

    protected open fun setupViews(view: View) {
    }

    protected open fun observeViewModel() {
    }

    protected fun <T> handleResource(
        resource: Resource<T>,
        onSuccess: (T?) -> Unit
    ) {
        when (resource) {
            is Resource.Loading -> {
            }
            is Resource.Success -> {
                onSuccess(resource.data)
            }
            is Resource.Error -> {
                showToast(resource.message)
            }
        }
    }

    protected fun <T> observeResource(
        liveData: LiveData<Resource<T>>,
        onSuccess: (T?) -> Unit
    ) {
        liveData.observe(viewLifecycleOwner, Observer { resource ->
            handleResource(resource, onSuccess)
        })
    }
}