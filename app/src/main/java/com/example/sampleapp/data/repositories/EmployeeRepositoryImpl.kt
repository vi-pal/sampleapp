package com.example.sampleapp.data.repositories

import com.example.sampleapp.network.api.MainApi
import com.example.sampleapp.data.Employee
import com.example.sampleapp.network.BaseError
import com.example.sampleapp.network.Either
import com.example.sampleapp.network.TypeError
import com.example.sampleapp.network.proceedResponse

class EmployeeRepositoryImpl(private val api: MainApi) : EmployeeRepository {
    override suspend fun requestEmployees(): Either<BaseError, List<Employee>?> {
        return proceedResponse {
            val response = api.requestEmployees()
            Either.Success(response.data)
        }
    }

    override suspend fun requestEmployee(id: Int): Either<BaseError, Employee> {
      //Not implemented yet
        return Either.Failure(BaseError.OtherError(TypeError.OTHER))
    }


}