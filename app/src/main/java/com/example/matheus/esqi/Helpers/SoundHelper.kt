package com.example.matheus.esqi.Helpers

import android.app.Activity
import android.media.MediaPlayer
import com.example.matheus.esqi.R
import java.util.*


class SoundHelper(activity: Activity) {
    var act: Activity = activity


    fun playSound(sound: Int) {
        val mp = MediaPlayer.create(act, sound)
        mp.start()
    }

    fun playLoseSound(){
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
    }

}