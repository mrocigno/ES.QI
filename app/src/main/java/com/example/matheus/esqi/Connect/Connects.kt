package com.example.matheus.esqi.Connect

import com.example.matheus.esqi.Connect.Models.DefaultModel
import com.example.matheus.esqi.Connect.Models.Placar
import com.example.matheus.esqi.Connect.Models.PlacarReceiveModel
import retrofit2.Call
import retrofit2.http.*

interface Connects {
    @GET("ws/wsGetPerguntas.php")
    fun getPerguntas(): Call<DefaultModel>

    @FormUrlEncoded
    @POST("ws/wsAddPlacar.php")
    fun setPlacar(@Field("player") s1: String,
                  @Field("acertos") i1: Int,
                  @Field("erros") i2: Int,
                  @Field("passadas") i3: Int): Call<PlacarReceiveModel>
}