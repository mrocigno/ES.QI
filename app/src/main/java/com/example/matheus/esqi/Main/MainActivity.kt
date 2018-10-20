package com.example.matheus.esqi.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matheus.esqi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_txtA.setOnClickListener{
            startActivity(Intent(this@MainActivity, PerguntasActivity::class.java))
        }

        main_txtB.setOnClickListener {
            startActivity(Intent(this@MainActivity, Placar::class.java))
        }

        main_txtD.setOnClickListener{
            finish()
        }
    }
}
