package com.example.matheus.esqi.Main

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
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

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        val teste = Network()
        val testeRetro: Retrofit = teste.networkBase()
        val con: Connects = testeRetro.create(Connects::class.java)
        con.getPerguntas().enqueue(object: Callback<DefaultModel> {
            override fun onFailure(call: Call<DefaultModel>?, t: Throwable?) {
                Log.e("erro","asdasda", t)
            }
            override fun onResponse(call: Call<DefaultModel>?, response: Response<DefaultModel>?) {
                mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, response!!.body()!!.data)
                container.adapter = mSectionsPagerAdapter
                perguntas_progressBar.visibility = View.GONE

                container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                        if(p1 > 0.5){
                            val page : PerguntasFragment = mSectionsPagerAdapter!!.getItem(p0) as PerguntasFragment
//                            Log.d("TESTEEE", nextPage.tt)
                            if(!page.respondida){
                                AlertTop.CustomYesNoTopAlert(this@PerguntasActivity, "Você tem certeza?", "Se continuar a questão atual será marcada como \"Não respondida\"",
                                        R.drawable.ic_warning_black_24dp,
                                        object : AlertTop.Companion.YesNoCallBack{
                                            override fun onClickYes() {
                                                container.currentItem = p0 + 1
                                                page.respondida = true
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

//
//
//        // Set up the ViewPager with the sections adapter.
//
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

//    class PlaceholderFragment : Fragment() {
//
//        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                                  savedInstanceState: Bundle?): View? {
//            val rootView = inflater.inflate(R.layout.fragment_deletar, container, false)
//            rootView.section_label.text = getString(R.string.section_format, arguments?.getInt(ARG_SECTION_NUMBER))
//            return rootView
//        }
//
//        companion object {
//            /**
//             * The fragment argument representing the section number for this
//             * fragment.
//             */
//            private val ARG_SECTION_NUMBER = "section_number"
//
//            /**
//             * Returns a new instance of this fragment for the given section
//             * number.
//             */
//            fun newInstance(sectionNumber: Int): deletar.PlaceholderFragment {
//                val fragment = deletar.PlaceholderFragment()
//                val args = Bundle()
//                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
//                fragment.arguments = args
//                return fragment
//            }
//        }
//    }

}
