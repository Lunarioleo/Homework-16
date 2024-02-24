package com.example.plantshandbook

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class ApiClient @Inject constructor(){
         val client = Retrofit.Builder()
            .baseUrl("https://akabab.github.io/superhero-api/api/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
