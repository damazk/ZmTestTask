package com.bulat.zmtesttask.data.model


data class ApiResponse(
    val part1: String,
    val part2: String
)

data class ApiError(
    val exception: String,
    val message: String
)