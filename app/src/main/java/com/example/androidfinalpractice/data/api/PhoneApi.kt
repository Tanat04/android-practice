package com.example.androidfinalpractice.data.api

import com.example.androidfinalpractice.models.Phone
import io.ktor.client.call.body
import io.ktor.client.request.get

class PhoneApi : BaseApi() {
    // need model here (list of <Model> Object)
    suspend fun getPhones(): List<Phone> =
        client
            .get("https://tbh-chat-essentials.vercel.app/api/models")
            .body<List<Phone>>() // explicitly define type of response (List of Objects)
}