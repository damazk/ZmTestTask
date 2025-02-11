package com.bulat.zmtesttask.data

import android.util.Base64
import com.bulat.zmtesttask.data.mapper.mapToUrl
import com.bulat.zmtesttask.data.model.DeviceInfoDto
import com.bulat.zmtesttask.domain.ApiRepository
import com.bulat.zmtesttask.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiService: ApiService) : ApiRepository {

    override suspend fun sendDeviceInfo(deviceInfoDto: DeviceInfoDto): Response<String> {
        val data = buildString {
            append("uid=${deviceInfoDto.uid}")
            append("&osVersion=${deviceInfoDto.osVersion}")
            append("&devModel=${deviceInfoDto.devModel}")
            append("&battery_level=${deviceInfoDto.battery_level}")
            append("&battery_status=${deviceInfoDto.battery_status}")
            append("&tz=${deviceInfoDto.tz}")
        }

        val encodedData = Base64.encodeToString(data.toByteArray(), Base64.NO_WRAP)

        return apiService.checkUrl(encodedData).mapToUrl()
    }
}