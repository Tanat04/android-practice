package com.example.androidfinalpractice.models

data class ActivityResponse(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Double,
    val link: String,
    val key: String,
    val accessibility: Double
)