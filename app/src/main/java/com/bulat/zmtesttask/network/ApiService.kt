package com.bulat.zmtesttask.network

import com.bulat.zmtesttask.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun checkUrl(@Query("data") encodedData: String): Response<ApiResponse>
}