package com.bulat.zmtesttask.domain

data class DeviceInfo(
    val uid: String,
    val osVersion: String,
    val devModel: String,
    val batteryLevel: Int,
    val batteryStatus: Boolean,
    val tz: String
)