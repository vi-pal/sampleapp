package com.example.sampleapp

import android.app.Application
import android.content.Context
import com.example.sampleapp.di.NetworkModule
import com.example.sampleapp.di.RepositoryModule
import com.example.sampleapp.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(NetworkModule.module, ViewModelModule.module, RepositoryModule.module)
        }
    }
}