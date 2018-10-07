package com.example.matheus.esqi.Connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private val baseURL = "http://esqi.esy.es/"

    fun networkBase(): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}