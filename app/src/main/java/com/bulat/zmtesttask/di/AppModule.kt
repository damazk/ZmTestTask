package com.bulat.zmtesttask.di

import android.content.Context
import com.bulat.zmtesttask.data.ApiRepositoryImpl
import com.bulat.zmtesttask.data.DeviceRepositoryImpl
import com.bulat.zmtesttask.data.local.SharedPrefsRepositoryImpl
import com.bulat.zmtesttask.domain.ApiRepository
import com.bulat.zmtesttask.domain.DeviceRepository
import com.bulat.zmtesttask.domain.SharedPrefsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context) = context.applicationContext
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDeviceRepository(
        deviceRepositoryImpl: DeviceRepositoryImpl
    ): DeviceRepository

    @Binds
    abstract fun bindApiRepository(
        apiRepositoryImpl: ApiRepositoryImpl
    ): ApiRepository

    @Binds
    abstract fun bindSharedPrefsRepository(
        sharedPrefsRepositoryImpl: SharedPrefsRepositoryImpl
    ): SharedPrefsRepository
}