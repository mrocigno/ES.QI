package com.example.matheus.esqi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.matheus.esqi.R

class PlacarAdapter(
        context: Context, objects: ArrayList<PlacarModel>)
                                    :
        ArrayAdapter<PlacarModel>(context, R.layout.adapter_placar_first, objects) {

    class ItensHolder{
        lateinit var txtNome : TextView
        lateinit var txtAcertos : TextView
        lateinit var txtErros : TextView
        lateinit var txtPassadas : TextView
        lateinit var imgCrown : ImageView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)
        val holder : ItensHolder?
        val v : View

        holder = ItensHolder()
        val inflater = LayoutInflater.from(context)

        if(position == 0){
            v = inflater.inflate(R.layout.adapter_placar_first, parent, false)
        }else{
            v = inflater.inflate(R.layout.adapter_placar, parent, false)
        }

        holder.txtNome = v.findViewById(R.id.adplacar_txtNome)
        holder.txtAcertos = v.findViewById(R.id.adplacar_txtAcertos)
        holder.txtErros = v.findViewById(R.id.adplacar_txtErros)
        holder.txtPassadas = v.findViewById(R.id.adplacar_txtPassadas)
        holder.imgCrown = v.findViewById(R.id.adplacar_imgCrown)

        holder.txtNome.text = item.player
        holder.txtAcertos.text = item.acertos.toString()
        holder.txtErros.text = item.erros.toString()
        holder.txtPassadas.text = item.passadas.toString()


        if(position == 1){
            holder.imgCrown.setImageDrawable(context.getDrawable(R.drawable.silver_medal))
            v.scaleX = 0.98f; v.scaleY = 0.98f
        }
        if(position == 2){
            holder.imgCrown.setImageDrawable(context.getDrawable(R.drawable.bronze_medal))
            v.scaleX = 0.95f; v.scaleY = 0.95f
        }
        if(position >= 3){
            v.scaleX = 0.92f; v.scaleY = 0.92f
        }
        return v
    }

}