package com.example.sampleapp.data

import com.google.gson.annotations.SerializedName

data class Employee (
    val id : String,
    @SerializedName("employee_name")
    val name : String,
    @SerializedName("employee_salary")
    val salary : Int,
    @SerializedName("employee_age")
    val age : Int,
    val imageUrl : String
)