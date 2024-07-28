package com.example.imran_mamirov_6_2.di

import com.example.imran_mamirov_6_2.ui.fragments.cartoon.CartoonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        CartoonViewModel(get())
    }
//    viewModel<CartoonViewModel> { CartoonViewModel(get())}
}