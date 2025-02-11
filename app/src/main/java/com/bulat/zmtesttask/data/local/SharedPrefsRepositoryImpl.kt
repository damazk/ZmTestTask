package com.bulat.zmtesttask.data.local

import android.content.Context
import android.content.SharedPreferences
import com.bulat.zmtesttask.domain.SharedPrefsRepository
import javax.inject.Inject

class SharedPrefsRepositoryImpl @Inject constructor(context: Context): SharedPrefsRepository {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUrl(url: String) {
        prefs.edit().putString(KEY_URL, url).apply()
    }

    override fun getUrl() = prefs.getString(KEY_URL, "") ?: ""

    companion object {
        private const val KEY_URL = "url"
        private const val PREFS_NAME = "zm_test_prefs"
    }
} 