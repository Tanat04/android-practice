package com.example.androidfinalpractice.data.api

import com.example.androidfinalpractice.models.ActivityResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.gson.gson

class ActivityApi: BaseApi() {
    suspend fun getActivity(): ActivityResponse {
        return client
            .get("https://www.boredapi.com/api/activity")
            .body<ActivityResponse>()
    }
}