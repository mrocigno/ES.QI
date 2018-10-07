package com.example.matheus.esqi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.matheus.esqi.Connect.Connects
import com.example.matheus.esqi.Connect.Models.DefaultModel
import com.example.matheus.esqi.Connect.Network
import com.example.matheus.esqi.Main.Main2Activity
import com.example.matheus.esqi.Main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        waitSplash(3000, object: SplashCallBack{
            override fun onEnd() {
                startActivity(Intent(this@Splash, Main2Activity::class.java))
                finish()
            }
        })

//        Thread{
//            run{
//                Thread.sleep(4000)
//                Toast.makeText(this@Splash, "asda", Toast.LENGTH_LONG).show()
//            }
//        }.start()

//        val teste = Network()

//        val testeRetro: Retrofit = teste.networkBase()
//
//        val con: Connects = testeRetro.create(Connects::class.java)
//        con.getPerguntas().enqueue(object: Callback<DefaultModel>{
//            override fun onFailure(call: Call<DefaultModel>?, t: Throwable?) {
//                Log.e("erro","asdasda", t)
//            }
//
//            override fun onResponse(call: Call<DefaultModel>?, response: Response<DefaultModel>?) {
//                Log.d("erro", response!!.body()!!.data[0].id_pergunta.toString())
//            }
//
//        })

    }

    protected interface SplashCallBack {
        fun onEnd()
    }

    protected fun waitSplash(mileSecs: Int, callBack: SplashCallBack) {
        object : Thread() {
            override fun run() {
//                try {
                    sleep(mileSecs.toLong())
                    callBack.onEnd()
//                } catch (e1: InterruptedException) {
//                    e1.printStackTrace()
//                }

            }

        }.start()
    }
}
