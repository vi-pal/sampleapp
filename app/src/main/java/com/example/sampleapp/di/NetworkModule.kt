package com.example.sampleapp.di

import com.example.sampleapp.BuildConfig
import com.example.sampleapp.network.api.MainApi
import com.example.sampleapp.network.UrlProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private fun provideDefaultHttpClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    private fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(UrlProvider.provideBaseUrl())
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val module = module {
        val retrofit = provideRetrofit(provideDefaultHttpClient())
        single { retrofit.create(MainApi::class.java) }
    }
}