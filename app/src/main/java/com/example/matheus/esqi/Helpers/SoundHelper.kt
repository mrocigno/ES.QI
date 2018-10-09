package com.example.matheus.esqi.Helpers

import android.app.Activity
import android.media.MediaPlayer
import android.util.Log
import com.example.matheus.esqi.R
import java.util.*


class SoundHelper(activity: Activity) {
    var act: Activity = activity

    interface onMiddleSound {
        fun onMiddle()
    }

    fun playSound(sound: Int) {
        val mp = MediaPlayer.create(act, sound)
        mp.start()
    }

    fun playSound(sound: Int, onMiddle: onMiddleSound) {
        val mp = MediaPlayer.create(act, sound)
        mp.start()
        middleAction(onMiddle, mp)
    }

    fun playLoseSound(onMiddle: onMiddleSound){
        val rand = Random()
        var mp : MediaPlayer? = null
        when (rand.nextInt(4)){
            0 ->{
                mp = MediaPlayer.create(act, R.raw.plateia1)
            }
            1 ->{
                mp = MediaPlayer.create(act, R.raw.plateia2)
            }
            2 ->{
                mp = MediaPlayer.create(act, R.raw.plateia3)
            }
            3 ->{
                mp = MediaPlayer.create(act, R.raw.plateia4)
            }
            else -> {

            }
        }
        mp!!.start()
        middleAction(onMiddle, mp)
    }


    private fun middleAction(onMiddle: onMiddleSound, mp : MediaPlayer){
        Thread{
            kotlin.run {
                try{
                    var erro = false
                    mp.setOnErrorListener { _, _, _ ->
                        erro = true
                        true
                    }
                    while(mp.currentPosition <= (mp.duration/2)){if(erro){break}}
                    act.runOnUiThread {onMiddle.onMiddle()}
                }catch (e : Exception){

                }
            }
        }.start()
    }

}