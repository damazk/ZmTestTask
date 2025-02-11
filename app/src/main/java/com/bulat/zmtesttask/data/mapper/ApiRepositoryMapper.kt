package com.bulat.zmtesttask.data.mapper

import com.bulat.zmtesttask.data.model.ApiResponse
import retrofit2.Response


fun Response<ApiResponse>.mapToUrl(): Response<String> {

    val url = body()?.let {
        "${it.part1}${it.part2}"
    } ?: ""

    return if (isSuccessful)
        Response.success(url)
    else
        throw Exception(message())
}