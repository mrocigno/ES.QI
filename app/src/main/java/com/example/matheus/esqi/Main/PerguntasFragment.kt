package com.example.matheus.esqi.Main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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


    var respondida : Boolean = false
    var tt = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val mView = inflater.inflate(R.layout.fragment_perguntas, container, false)

        val sound = SoundHelper(this.activity!!)

        val pm : PerguntasModel = arguments?.getSerializable(ARG_SECTION_NUMBER) as PerguntasModel

        mView.fperguntas_txtTitulo.text = pm.titulo

        tt = pm.pergunta

        val random = Random()

        when (random.nextInt(4)){
            0-> {
                mView.fperguntas_txtA.text = pm.reposta_certa
                mView.fperguntas_txtA.tag = true

                mView.fperguntas_txtB.text = pm.reposta_errada1
                mView.fperguntas_txtB.tag = false

                mView.fperguntas_txtC.text = pm.reposta_errada2
                mView.fperguntas_txtC.tag = false

                mView.fperguntas_txtD.text = pm.reposta_errada3
                mView.fperguntas_txtD.tag = false
            }
            1-> {
                mView.fperguntas_txtA.text = pm.reposta_errada1
                mView.fperguntas_txtA.tag =  false

                mView.fperguntas_txtB.text = pm.reposta_certa
                mView.fperguntas_txtB.tag =  true

                mView.fperguntas_txtC.text = pm.reposta_errada2
                mView.fperguntas_txtC.tag =  false

                mView.fperguntas_txtD.text = pm.reposta_errada3
                mView.fperguntas_txtD.tag =  false
            }
            2-> {
                mView.fperguntas_txtA.text = pm.reposta_errada1
                mView.fperguntas_txtA.tag =  false

                mView.fperguntas_txtB.text = pm.reposta_errada2
                mView.fperguntas_txtB.tag =  false

                mView.fperguntas_txtC.text = pm.reposta_certa
                mView.fperguntas_txtC.tag =  true

                mView.fperguntas_txtD.text = pm.reposta_errada3
                mView.fperguntas_txtD.tag =  false
            }
            3-> {
                mView.fperguntas_txtA.text = pm.reposta_errada1
                mView.fperguntas_txtA.tag =  false

                mView.fperguntas_txtB.text = pm.reposta_errada2
                mView.fperguntas_txtB.tag =  false

                mView.fperguntas_txtC.text = pm.reposta_errada3
                mView.fperguntas_txtC.tag =  false

                mView.fperguntas_txtD.text = pm.reposta_certa
                mView.fperguntas_txtD.tag =  true
            }
            else -> {

            }
        }

        val optClickAction = View.OnClickListener { p0 ->
            if(p0!!.tag as Boolean){
                sound.playSound(R.raw.plateia5)
            }else{
                sound.playLoseSound()
            }
            respondida = true
            Log.d("TESTEEE", respondida.toString())
        }

        mView.fperguntas_txtPergunta.text = pm.pergunta
        mView.fperguntas_lnlA.rotation = (random.nextInt(5) - 2).toFloat()
        mView.fperguntas_txtA.setOnClickListener(optClickAction)

        mView.fperguntas_lnlB.rotation = (random.nextInt(5) - 2).toFloat()
        mView.fperguntas_txtB.setOnClickListener(optClickAction)

        mView.fperguntas_lnlC.rotation = (random.nextInt(5) - 2).toFloat()
        mView.fperguntas_txtC.setOnClickListener(optClickAction)

        mView.fperguntas_lnlD.rotation = (random.nextInt(5) - 2).toFloat()
        mView.fperguntas_txtD.setOnClickListener(optClickAction)

        return mView
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
