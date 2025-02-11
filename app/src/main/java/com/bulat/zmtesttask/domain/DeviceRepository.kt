package com.bulat.zmtesttask.domain

import com.bulat.zmtesttask.data.model.DeviceInfoDto

interface DeviceRepository {

    fun getDeviceInfo(): DeviceInfoDto
}