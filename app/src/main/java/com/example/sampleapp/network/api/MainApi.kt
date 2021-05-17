package com.example.sampleapp.network.api

import com.example.sampleapp.base.BaseResponse
import com.example.sampleapp.data.Employee
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {
    @GET("employees")
    suspend fun requestEmployees(): BaseResponse<List<Employee>>

    @GET("employee/{id}")
    suspend fun requestEmployee(
        @Path("id")
        id: Int
    ): BaseResponse<Employee>
}