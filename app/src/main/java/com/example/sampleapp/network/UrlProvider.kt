package com.example.sampleapp.network

import com.example.sampleapp.BuildConfig

object UrlProvider {
    fun provideBaseUrl(): String = BuildConfig.BASE_URL
}