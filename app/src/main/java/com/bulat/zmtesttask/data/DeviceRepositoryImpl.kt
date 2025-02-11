package com.bulat.zmtesttask.data

import android.content.Context
import android.os.BatteryManager
import android.os.Build
import com.bulat.zmtesttask.data.model.DeviceInfoDto
import com.bulat.zmtesttask.domain.DeviceRepository
import java.util.TimeZone
import java.util.UUID
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    private val context: Context
) : DeviceRepository {
    
    override fun getDeviceInfo(): DeviceInfoDto {
        val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        
        return DeviceInfoDto(
            uid = UUID.randomUUID().toString(),
            osVersion = Build.VERSION.RELEASE,
            devModel = Build.MODEL,
            battery_level = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY),
            battery_status = batteryManager.isCharging,
            tz = TimeZone.getDefault().id
        )
    }
} 