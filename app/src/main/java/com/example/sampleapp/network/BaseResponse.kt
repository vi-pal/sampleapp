package com.example.sampleapp.network

class BaseResponse<T>(val data: T? = null, val message: String? = null, status: Int? = null)