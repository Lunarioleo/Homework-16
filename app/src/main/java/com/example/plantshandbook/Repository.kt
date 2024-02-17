package com.example.plantshandbook

import retrofit2.Response
import retrofit2.Retrofit

class Repository(private val client: Retrofit) {
    suspend fun getHeroesList(): Response<CharacterResponse> {
        val apiInterface = client.create(ApiInterface::class.java)
        return apiInterface.findHeroesList()
    }
}