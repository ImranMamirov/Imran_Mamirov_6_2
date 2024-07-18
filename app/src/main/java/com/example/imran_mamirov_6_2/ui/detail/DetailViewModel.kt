package com.example.imran_mamirov_6_2.ui.detail

import androidx.lifecycle.ViewModel
import com.example.imran_mamirov_6_2.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository): ViewModel(){
}