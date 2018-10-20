package com.example.matheus.esqi.Main

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toast
import com.example.matheus.esqi.Connect.Connects
import com.example.matheus.esqi.Connect.Models.DefaultModel
import com.example.matheus.esqi.Connect.Models.PerguntasModel
import com.example.matheus.esqi.Connect.Network

import com.example.matheus.esqi.Utils.AlertTop
import kotlinx.android.synthetic.main.activity_perguntas.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import com.example.matheus.esqi.R

class PerguntasActivity : AppCompatActivity() {

    var hit = 0
    var missed = 0
    var passed = 0

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        val teste = Network()
        val testeRetro: Retrofit = teste.networkBase()
        val con: Connects = testeRetro.create(Connects::class.java)
        con.getPerguntas().enqueue(object: Callback<DefaultModel> {
            override fun onFailure(call: Call<DefaultModel>?, t: Throwable?) {
                perguntas_lnlMsg.visibility = View.VISIBLE
                perguntas_progressBar.visibility = View.GONE
                perguntas_btnVoltar.setOnClickListener { finish(); }
                perguntas_btnAgain.setOnClickListener { recreate(); }
            }
            override fun onResponse(call: Call<DefaultModel>?, response: Response<DefaultModel>?) {
                mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, response!!.body()!!.data)
                container.adapter = mSectionsPagerAdapter
                perguntas_progressBar.visibility = View.GONE
                perguntas_lnlVidas.visibility = View.VISIBLE

                container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                        if(p1 > 0.5){
                            val page : PerguntasFragment = mSectionsPagerAdapter!!.getItem(p0) as PerguntasFragment
                            if(!page.respondida){
                                AlertTop.CustomYesNoTopAlert(this@PerguntasActivity, "Você tem certeza?", "Se continuar a questão atual será marcada como \"Não respondida\"",
                                        R.drawable.ic_warning_black_24dp,
                                        object : AlertTop.Companion.YesNoCallBack{
                                            override fun onClickYes() {
                                                container.currentItem = p0 + 1
                                                page.state = "Não respondeu"
                                                page.setAnswered()
                                            }

                                            override fun onClickNo() {
                                                container.currentItem = p0
                                            }

                                        }
                                )
                            }
                        }
                    }

                    override fun onPageSelected(p0: Int) {

                    }
                })
            }
        })
    }

    fun setScored(type : Int){
        when (type){
            1 -> {
                hit++
            }
            2 -> {
                missed++
                when (missed){
                    1->{
                        fperguntas_imgHearth1.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_black_24dp))
                        fperguntas_imgHearth1.setColorFilter(Color.BLACK)
                        fperguntas_imgBorderHearth1.setImageDrawable(getDrawable(R.drawable.ic_close_red_24dp))
                    }
                    2->{
                        fperguntas_imgHearth2.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_black_24dp))
                        fperguntas_imgHearth2.setColorFilter(Color.BLACK)
                        fperguntas_imgBorderHearth2.setImageDrawable(getDrawable(R.drawable.ic_close_red_24dp))
                    }
                    3->{
                        fperguntas_imgHearth3.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_black_24dp))
                        fperguntas_imgHearth3.setColorFilter(Color.BLACK)
                        fperguntas_imgBorderHearth3.setImageDrawable(getDrawable(R.drawable.ic_close_red_24dp))
                    }
                }
            }
            3 -> {
                passed++
            }
        }
    }

    fun endQuiz(msg : String){
        finish()

        val intent = Intent(this@PerguntasActivity, EndQuizActivity::class.java)

        intent.putExtra("mensagem", msg)
        intent.putExtra("acertos", hit)
        intent.putExtra("erros", missed)
        intent.putExtra("passadas", passed)

        startActivity(intent)
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager, teste : ArrayList<PerguntasModel>) : FragmentPagerAdapter(fm) {

        var teste2 :ArrayList<PerguntasModel> = teste
        var fragments : ArrayList<PerguntasFragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            var new_frg : PerguntasFragment
            try{
                new_frg = fragments.get(position)
            }catch (e: Exception){
                new_frg = PerguntasFragment.newInstance(teste2[position])
                fragments.add(new_frg)
            }

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return new_frg//teste2[position])
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return teste2.size
        }
    }
}
