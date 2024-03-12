package com.example.androidfinalpractice.data.cache

import android.content.Context
import com.example.androidfinalpractice.models.Phone
import com.google.gson.Gson

class PhoneCache(private val context: Context) {
    private val cache = context.getSharedPreferences("phone", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun hasPhones(): Boolean {
        return cache.contains("phoneList")
    }

    fun getPhones(): List<Phone> {
        val jsonValue = cache.getString("phoneList", null)

        return jsonValue?.let {
            gson.fromJson(it, Array<Phone>::class.java).toList()
        } ?: listOf()
    }

    fun setPhones(phones: List<Phone>) {
        cache.edit().apply {
            putString("phoneList", gson.toJson(phones))
            apply()
        }
    }
}