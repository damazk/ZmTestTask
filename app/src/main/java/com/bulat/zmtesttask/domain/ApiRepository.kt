package com.bulat.zmtesttask.domain

import com.bulat.zmtesttask.data.model.DeviceInfoDto
import retrofit2.Response

interface ApiRepository {

    suspend fun sendDeviceInfo(deviceInfoDto: DeviceInfoDto): Response<String>
}