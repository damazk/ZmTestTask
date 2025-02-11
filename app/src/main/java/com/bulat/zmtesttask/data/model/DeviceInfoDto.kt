package com.bulat.zmtesttask.data.model

data class DeviceInfoDto(
    val uid: String,
    val osVersion: String,
    val devModel: String,
    val battery_level: Int,
    val battery_status: Boolean,
    val tz: String
) 