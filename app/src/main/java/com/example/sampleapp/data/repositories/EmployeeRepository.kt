package com.example.sampleapp.data.repositories

import com.example.sampleapp.data.Employee
import com.example.sampleapp.network.BaseError
import com.example.sampleapp.network.Either

interface EmployeeRepository {
    suspend fun requestEmployees() : Either<BaseError, List<Employee>?>
    suspend fun requestEmployee(id: Int) : Either<BaseError, Employee>
}