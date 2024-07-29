package com.example.imran_mamirov_6_2.module

import com.example.imran_mamirov_6_2.ui.fragments.cartoon.CartoonViewModel
import com.example.imran_mamirov_6_2.ui.fragments.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        CartoonViewModel(get())
    }

    viewModel {
        DetailViewModel(get())
    }
//    viewModel<CartoonViewModel> { CartoonViewModel(get())}
}