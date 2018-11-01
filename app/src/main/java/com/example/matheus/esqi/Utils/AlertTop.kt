package com.example.matheus.esqi.Utils

import android.animation.ObjectAnimator
import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.matheus.esqi.R
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class AlertTop {
    companion object {
        fun CustomTopLoadingAlert(activity: Activity) : DialogPlus{

            var lng : LoadingSettings? = null

            val holder = ViewHolder(R.layout.alert_loading)
            val alert = DialogPlus.newDialog(activity)
                    .setContentHolder(holder)
                    .setGravity(Gravity.TOP)
                    .setOnDismissListener { lng!!.threadClose() }
                    .setOnCancelListener { lng!!.threadClose() }
                    .create()

            lng = LoadingSettings((holder.getInflatedView().findViewById(R.id.loading_txtAlert) as TextView), TextView::class.java)
            lng.txtLoading(activity, 200, 3, "Carregando")

            lng.threadStart()
            alert.show()
            return alert
        }

        fun CustomTopSimpleAlert(activity: Activity, msg: String, img: Int, duration: Int) {

            val holder = ViewHolder(R.layout.alert_base)
            val alert = DialogPlus.newDialog(activity)
                    .setContentHolder(holder)
                    .setGravity(Gravity.TOP)
                    .create()

            (holder.getInflatedView().findViewById(R.id.alert_msg) as TextView).text = msg
            (holder.getInflatedView().findViewById(R.id.alert_img) as ImageView).setImageDrawable(activity.getDrawable(img))

            val progressAnimator = ObjectAnimator.ofInt(holder.getInflatedView().findViewById(R.id.alert_pbh), "progress", 100, 0)
            progressAnimator.duration = duration.toLong()
            progressAnimator.interpolator = LinearInterpolator()
            progressAnimator.start()

            alert.show()

            object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(duration.toLong())
                        activity.runOnUiThread { alert.dismiss() }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }
            }.start()
        }

        interface YesNoCallBack {
            fun onClickYes()
            fun onClickNo()
        }

        fun CustomYesNoTopAlert(activity: Activity, title: String, msg: String, img: Int, yesNoCallBack: YesNoCallBack) {
            val holder = ViewHolder(R.layout.alert_yes_no_option)
            val alert = DialogPlus.newDialog(activity)
                    .setContentHolder(holder)
                    .setGravity(Gravity.TOP)
                    .setOnCancelListener { yesNoCallBack.onClickNo() }
                    .create()

            (holder.getInflatedView().findViewById(R.id.alertYesNo_txtTle) as TextView).text = title
            (holder.getInflatedView().findViewById(R.id.alertYesNo_txtCdo) as TextView).text = msg
            (holder.getInflatedView().findViewById(R.id.alertYesNo_imgIew) as ImageView).setImageDrawable(activity.getDrawable(img))
            (holder.getInflatedView().findViewById(R.id.alertYesNo_btnYes) as Button).setOnClickListener{
                alert.dismiss()
                yesNoCallBack.onClickYes()
            }
            (holder.getInflatedView().findViewById(R.id.alertYesNo_btnNo) as Button).setOnClickListener {
                alert.dismiss()
                yesNoCallBack.onClickNo()
            }

            alert.show()
        }
    }
}