package com.example.imran_mamirov_6_2

import android.app.Application
import com.example.imran_mamirov_6_2.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}