package com.example.imran_mamirov_6_2.module

import com.example.imran_mamirov_6_2.data.repository.Repository
import org.koin.dsl.module

val RepositoryModule = module {
    factory {
        Repository(get())
    }
}