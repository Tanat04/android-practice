package com.example.androidfinalpractice

import android.app.Application
import com.example.androidfinalpractice.utils.NotificationHandler

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationHandler.initNotificationChannel(this)
    }
}