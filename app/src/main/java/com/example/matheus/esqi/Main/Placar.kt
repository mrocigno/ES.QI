package com.example.matheus.esqi.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matheus.esqi.Adapters.PlacarAdapter
import com.example.matheus.esqi.Adapters.PlacarAdapterJava
import com.example.matheus.esqi.Adapters.PlacarModel
import com.example.matheus.esqi.R
import kotlinx.android.synthetic.main.activity_placar.*

class Placar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placar)

        val arrayList : ArrayList<PlacarModel> = ArrayList()
        arrayList.add(PlacarModel(1, "Matheus", 22, 33,44))
        arrayList.add(PlacarModel(2, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(3, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(4, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(5, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(6, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(7, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(8, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(9, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(10, "TOP", 22, 33,44))
        arrayList.add(PlacarModel(11, "TOP", 22, 33,44))

        placar_lstLideres.adapter = PlacarAdapter(applicationContext, arrayList)

        placar_imgBack.setOnClickListener { onBackPressed() }
    }
}
