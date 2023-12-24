package com.example.suitmedia_android_developer_test.model

data class ApiResult<T>(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<T>
)