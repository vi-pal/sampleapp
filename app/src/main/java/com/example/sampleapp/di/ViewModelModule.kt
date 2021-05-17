package com.example.sampleapp.di

import com.example.sampleapp.presentation.viewmodels.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


object ViewModelModule {
    val module = module {
        viewModel { EmployeeViewModel(get()) }
    }
}