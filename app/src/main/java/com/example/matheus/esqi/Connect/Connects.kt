package com.example.matheus.esqi.Connect

import com.example.matheus.esqi.Connect.Models.DefaultModel
import retrofit2.Call
import retrofit2.http.GET

interface Connects {
    @GET("ws/wsGetPerguntas.php")
    fun getPerguntas(): Call<DefaultModel>
}