package com.example.matheus.esqi.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matheus.esqi.R;

import java.util.List;

public class PlacarAdapterJava extends ArrayAdapter<PlacarModel> {
    public PlacarAdapterJava(@NonNull Context context, @NonNull List<PlacarModel> objects) {
        super(context, R.layout.adapter_placar, objects);
    }

    class ItensHolder{
        TextView    txtNome,
                    txtAcertos,
                    txtErros,
                    txtPassadas;

        ImageView   imgCrown;
    }

    View teste = null;

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        PlacarModel item = getItem(position);
        ItensHolder holder;

        if(teste == null){
            holder = new ItensHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            if (item.getOrdem() == 1){
                teste = inflater.inflate(R.layout.adapter_placar_first, parent, false);
            }else{
                teste = inflater.inflate(R.layout.adapter_placar, parent, false);
            }

            teste.setTag(holder);
        }else{
            holder = (ItensHolder) teste.getTag();
        }

        return teste;
    }
}
