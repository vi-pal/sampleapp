package com.example.sampleapp.di

import com.example.sampleapp.data.repositories.EmployeeRepository
import com.example.sampleapp.data.repositories.EmployeeRepositoryImpl
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single<EmployeeRepository> { EmployeeRepositoryImpl(get()) }
    }
}