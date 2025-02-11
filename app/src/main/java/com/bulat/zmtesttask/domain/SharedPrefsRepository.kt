package com.bulat.zmtesttask.domain

interface SharedPrefsRepository {

    fun saveUrl(url: String)

    fun getUrl(): String
}