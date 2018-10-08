package com.example.matheus.esqi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matheus.esqi.Main.MainActivity
import com.example.matheus.esqi.Main.PerguntasActivity

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        waitSplash(3000, object: SplashCallBack{
            override fun onEnd() {
                startActivity(Intent(this@Splash, MainActivity::class.java))
                finish()
            }
        })

//        Thread{
//            run{
//                Thread.sleep(4000)
//                Toast.makeText(this@Splash, "asda", Toast.LENGTH_LONG).show()
//            }
//        }.start()

//

//
//
//
//
//
//
//
//
//
//
//
//
//

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
