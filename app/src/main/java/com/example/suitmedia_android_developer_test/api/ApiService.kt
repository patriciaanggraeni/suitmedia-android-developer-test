package com.example.suitmedia_android_developer_test.api

import com.example.suitmedia_android_developer_test.model.ApiResult
import com.example.suitmedia_android_developer_test.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<ApiResult<User>>
}
