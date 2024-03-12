package com.example.androidfinalpractice.data.cache

import android.content.Context
import com.google.gson.Gson
import com.example.androidfinalpractice.models.UserInfo

class UserCache(private val context: Context) {
    private val cache = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun isLogin(): Boolean {
        return cache.contains("userInfo")
    }

    fun getUserInfo(): UserInfo? {
        val jsonValue = cache.getString("userInfo", null)

        return jsonValue?.let {
            gson.fromJson(it, UserInfo::class.java)
        }
    }

    fun setUserInfo(userInfo: UserInfo) {
        cache.edit().apply {
            putString("userInfo", gson.toJson(userInfo))
            apply()
        }
    }
}