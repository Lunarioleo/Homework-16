package com.example.plantshandbook

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyAppication : Application() {
    lateinit var  repo: Repository
    override fun onCreate() {
        super.onCreate()
        instance = this
        repo = Repository(getApiClient())
    }
    private fun getApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://akabab.github.io/superhero-api/api/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    companion object {
        private lateinit var instance: MyAppication
        fun getInstance() = instance
    }
}