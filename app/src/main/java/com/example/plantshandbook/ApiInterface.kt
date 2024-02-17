package com.example.plantshandbook

import retrofit2.Response
import retrofit2.http.GET
interface ApiInterface {
@GET ("all.json")
    suspend fun findHeroesList(): Response<CharacterResponse>
}