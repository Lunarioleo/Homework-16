package com.example.plantshandbook

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class Repository (private val myClient: ApiClient){
    suspend fun getHeroesList(): Response<CharacterResponse> {
        val apiInterface = myClient.client.create(ApiInterface::class.java)
        return apiInterface.findHeroesList()
    }
}