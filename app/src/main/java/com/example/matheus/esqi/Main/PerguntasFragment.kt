package com.example.matheus.esqi.Main


import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.matheus.esqi.Connect.Models.PerguntasModel
import com.example.matheus.esqi.Helpers.SoundHelper

import com.example.matheus.esqi.R
import kotlinx.android.synthetic.main.fragment_perguntas.view.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
open class PerguntasFragment : Fragment() {


    var respondida: Boolean = false
    var state: String = ""
    var tt = ""

    lateinit var txtA: TextView
    lateinit var txtB: TextView
    lateinit var txtC: TextView
    lateinit var txtD: TextView
    lateinit var imgState: ImageView
    lateinit var txtState: TextView
    var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_perguntas, container, false)

            val sound = SoundHelper(this.activity!!)

            txtA = mView!!.fperguntas_txtA
            txtB = mView!!.fperguntas_txtB
            txtC = mView!!.fperguntas_txtC
            txtD = mView!!.fperguntas_txtD
            imgState = mView!!.fperguntas_imgState
            txtState = mView!!.fperguntas_txtState

            val pm: PerguntasModel = arguments?.getSerializable(ARG_SECTION_NUMBER) as PerguntasModel

            tt = pm.pergunta

            val random = Random()

            when (random.nextInt(4)) {
                0 -> {
                    txtA.text = pm.reposta_certa
                    txtA.tag = true

                    txtB.text = pm.reposta_errada1
                    txtB.tag = false

                    txtC.text = pm.reposta_errada2
                    txtC.tag = false

                    txtD.text = pm.reposta_errada3
                    txtD.tag = false
                }
                1 -> {
                    txtA.text = pm.reposta_errada1
                    txtA.tag = false

                    txtB.text = pm.reposta_certa
                    txtB.tag = true

                    txtC.text = pm.reposta_errada2
                    txtC.tag = false

                    txtD.text = pm.reposta_errada3
                    txtD.tag = false
                }
                2 -> {
                    txtA.text = pm.reposta_errada1
                    txtA.tag = false

                    txtB.text = pm.reposta_errada2
                    txtB.tag = false

                    txtC.text = pm.reposta_certa
                    txtC.tag = true

                    txtD.text = pm.reposta_errada3
                    txtD.tag = false
                }
                3 -> {
                    txtA.text = pm.reposta_errada1
                    txtA.tag = false

                    txtB.text = pm.reposta_errada2
                    txtB.tag = false

                    txtC.text = pm.reposta_errada3
                    txtC.tag = false

                    txtD.text = pm.reposta_certa
                    txtD.tag = true
                }
                else -> {

                }
            }

            val optClickAction = View.OnClickListener { p0 ->
                if (p0!!.tag as Boolean) {
                    sound.playSound(R.raw.plateia5, object : SoundHelper.onMiddleSound{
                        override fun onMiddle() {
                            nextPage()
                        }
                    })
                    state = "Acertou"
                } else {
                    sound.playLoseSound(object : SoundHelper.onMiddleSound{
                        override fun onMiddle() {
                            nextPage()
                        }
                    })
                    state = "Errou"
                }
                setAnswered()
            }

            mView!!.fperguntas_txtPergunta.text = pm.pergunta
            mView!!.fperguntas_lnlA.rotation = (random.nextInt(5) - 2).toFloat()
            txtA.setOnClickListener(optClickAction)

            mView!!.fperguntas_lnlB.rotation = (random.nextInt(5) - 2).toFloat()
            txtB.setOnClickListener(optClickAction)

            mView!!.fperguntas_lnlC.rotation = (random.nextInt(5) - 2).toFloat()
            txtC.setOnClickListener(optClickAction)

            mView!!.fperguntas_lnlD.rotation = (random.nextInt(5) - 2).toFloat()
            txtD.setOnClickListener(optClickAction)
        }

        return mView
    }

    fun nextPage(){
        if((activity as PerguntasActivity).missed > 2){
            (activity as PerguntasActivity).endQuiz("Ih, suas vidas acabaram :(")
        }else{
            val pager = activity!!.findViewById<ViewPager>(R.id.container)
            pager.currentItem = pager.currentItem + 1
        }
    }

    fun setAnswered() {
        if (state != "") {
            respondida = true

            if (txtA.tag as Boolean) {
                txtA.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            } else {
                txtA.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }
            if (txtB.tag as Boolean) {
                txtB.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            } else {
                txtB.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }
            if (txtC.tag as Boolean) {
                txtC.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            } else {
                txtC.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }
            if (txtD.tag as Boolean) {
                txtD.setTextColor(resources.getColor(android.R.color.holo_green_dark))
            } else {
                txtD.setTextColor(resources.getColor(android.R.color.holo_red_dark))
            }

            txtA.isEnabled = false
            txtB.isEnabled = false
            txtC.isEnabled = false
            txtD.isEnabled = false

            when (state) {
                "Acertou" -> {
                    imgState.setImageDrawable(activity!!.getDrawable(R.drawable.ic_check_green_24dp))
                    txtState.setTextColor(activity!!.getColor(android.R.color.holo_green_dark))
                    (activity as PerguntasActivity).setScored(1)
                }
                "Errou" -> {
                    imgState.setImageDrawable(activity!!.getDrawable(R.drawable.ic_close_red_24dp))
                    txtState.setTextColor(activity!!.getColor(android.R.color.holo_red_dark))
                    (activity as PerguntasActivity).setScored(2)
                }
                "Não respondeu" -> {
                    imgState.setImageDrawable(activity!!.getDrawable(R.drawable.ic_close_red_24dp))
                    imgState.setColorFilter(activity!!.getColor(android.R.color.holo_orange_light))
                    txtState.setTextColor(activity!!.getColor(android.R.color.holo_orange_light))
                    (activity as PerguntasActivity).setScored(3)
                }
            }
            txtState.text = state
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: PerguntasModel): PerguntasFragment {
            val fragment = PerguntasFragment()
            val args = Bundle()
            args.putSerializable(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

}
