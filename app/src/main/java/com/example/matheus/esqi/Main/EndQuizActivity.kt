package com.example.matheus.esqi.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.matheus.esqi.Connect.Connects
import com.example.matheus.esqi.Connect.Models.Placar
import com.example.matheus.esqi.Connect.Models.PlacarReceiveModel
import com.example.matheus.esqi.Connect.Network
import com.example.matheus.esqi.R
import com.example.matheus.esqi.Utils.AlertTop
import com.example.matheus.esqi.Utils.KeyboardUtils
import kotlinx.android.synthetic.main.activity_end_quiz.*
import retrofit2.Call
import retrofit2.Response

class EndQuizActivity : AppCompatActivity() {

    lateinit var placar : Placar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_quiz)

        placar = Placar("", intent.getIntExtra("acertos", 0), intent.getIntExtra("erros", 0), intent.getIntExtra("passadas", 0))

        end_txtMsg.text = intent.getStringExtra("mensagem")
        end_txtAcertos.text = intent.getIntExtra("acertos", 0).toString()
        end_txtErros.text = intent.getIntExtra("erros", 0).toString()
        end_txtPassadas.text = intent.getIntExtra("passadas", 0).toString()
        end_edtApelido.setOnEditorActionListener { textView, i, keyEvent ->
            uploadData(); true
        }
        end_btnSair.setOnClickListener { onBackPressed() }
        end_imgUpload.setOnClickListener(uploadAction)
        end_btnEnviar.setOnClickListener(uploadAction)
    }

    fun setEnableUploadButtons(isEnable : Boolean){
        end_imgUpload.isEnabled = isEnable
        end_btnEnviar.isEnabled = isEnable
    }

    val uploadAction = View.OnClickListener {v ->
        v.isEnabled = false
        uploadData()
    }

    fun uploadData(){
        setEnableUploadButtons(false)
        KeyboardUtils.hideKeyboard(if (currentFocus == null) View(this) else currentFocus, applicationContext)

        if(end_edtApelido.text.toString() == ""){
            AlertTop.CustomTopSimpleAlert(this@EndQuizActivity, "Você deve informar um apelido", R.drawable.ic_warning_black_24dp, 3000)
            return
        }

        val alert = AlertTop.CustomTopLoadingAlert(this@EndQuizActivity)

        placar.player = end_edtApelido.text.toString().trim()

        val net = Network()
        val retro = net.networkBase()
        val con = retro.create(Connects::class.java)
        con.setPlacar(placar.player, placar.acertos, placar.erros, placar.passadas).enqueue(object : retrofit2.Callback<PlacarReceiveModel>{
            override fun onFailure(call: Call<PlacarReceiveModel>, t: Throwable) {
                Toast.makeText(this@EndQuizActivity, "Ocorreu um erro. Aguarde alguns segundos e tente novamente", Toast.LENGTH_LONG).show()
                alert.dismiss()
                setEnableUploadButtons(true)
            }

            override fun onResponse(call: Call<PlacarReceiveModel>, response: Response<PlacarReceiveModel>) {
                alert.dismiss()
                finish()
                Toast.makeText(this@EndQuizActivity, response.body()!!.result, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onBackPressed() {
        AlertTop.CustomYesNoTopAlert(this@EndQuizActivity,
                "Você tem certeza?",
                "Se sair sem informar seu apelido você não fará parte do placar de líderes",
                R.drawable.ic_warning_black_24dp,
                object : AlertTop.Companion.YesNoCallBack{
                    override fun onClickYes() {
                        finish()
                    }
                    override fun onClickNo() {}
                })
    }
}
