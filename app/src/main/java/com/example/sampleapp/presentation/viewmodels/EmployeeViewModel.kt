package com.example.sampleapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampleapp.base.BaseViewModel
import com.example.sampleapp.data.Employee
import com.example.sampleapp.data.repositories.EmployeeRepository

class EmployeeViewModel(private val repository: EmployeeRepository) : BaseViewModel() {

    private val _employees: MutableLiveData<List<Employee>> = MutableLiveData()
    private val _isSuccess: MutableLiveData<Boolean> = MutableLiveData()

    fun requestEmployees() {
        doOnBackground {
            repository.requestEmployees().either({
                _isSuccess.postValue(false)
            }){
                _isSuccess.postValue(true)
                _employees.postValue(it)
            }
        }
    }

    val employees: LiveData<List<Employee>> get() = _employees
    val isSuccess: LiveData<Boolean> get() = _isSuccess
}