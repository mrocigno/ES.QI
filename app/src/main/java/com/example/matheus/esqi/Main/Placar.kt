package com.example.matheus.esqi.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.matheus.esqi.Adapters.PlacarAdapter
import com.example.matheus.esqi.Connect.Connects
import com.example.matheus.esqi.Connect.Models.PlacarLideresModel
import com.example.matheus.esqi.Connect.Network
import com.example.matheus.esqi.R
import com.example.matheus.esqi.Utils.AlertTop
import kotlinx.android.synthetic.main.activity_placar.*
import retrofit2.Call
import retrofit2.Response

class Placar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        val alert = AlertTop.CustomTopLoadingAlert(this@Placar)

        val net = Network()
        val retro = net.networkBase()
        val con = retro.create(Connects::class.java)
        con.getPlacar().enqueue(object : retrofit2.Callback<PlacarLideresModel>{
            override fun onFailure(call: Call<PlacarLideresModel>, t: Throwable) {
                Log.e("TESTEEE", "Erro" , t)
                alert.dismiss()
            }

            override fun onResponse(call: Call<PlacarLideresModel>, response: Response<PlacarLideresModel>) {
                alert.dismiss()
                placar_lstLideres.adapter = PlacarAdapter(applicationContext, response.body()!!.data)
            }

        })

        placar_imgBack.setOnClickListener { onBackPressed() }
    }
}
