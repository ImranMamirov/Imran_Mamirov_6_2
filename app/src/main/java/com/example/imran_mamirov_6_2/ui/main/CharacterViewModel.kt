package com.example.imran_mamirov_6_2.ui.main

import androidx.lifecycle.ViewModel
import com.example.imran_mamirov_6_2.data.repository.Repository

class CharacterViewModel (private val repository: Repository) : ViewModel() {
    fun getCharacters() = repository.getCharacters()
}