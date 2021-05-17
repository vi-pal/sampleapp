package com.example.sampleapp.base

class BaseResponse<T> (
    val status: String? = null,
    val data: T? = null,
    val message: String? = null
)