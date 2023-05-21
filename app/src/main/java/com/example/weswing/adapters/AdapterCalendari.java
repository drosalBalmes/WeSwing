package com.example.weswing.adapters;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import com.example.weswing.objects.Moguda;
import com.example.weswing.R;

public class AdapterCalendari extends RecyclerView.Adapter<AdapterCalendari.MyviewHolder> {

    List<Moguda> mogudaList;

    public AdapterCalendari(List<Moguda> mos) {
        this.mogudaList = mos;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mogudes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.bindData(mogudaList.get(position));
    }

    @Override
    public int getItemCount() {
        return mogudaList.size();
    }


    public class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView dataGran, title, assistents,duracio,lloc,organitzador;

        public MyviewHolder(@NonNull View itemView){
            super(itemView);
            iv = itemView.findViewById(R.id.IVperfil);
            dataGran = itemView.findViewById(R.id.TVData);
            title = itemView.findViewById(R.id.TitleTV);
            organitzador = itemView.findViewById(R.id.OrganitzaTV);
            duracio = itemView.findViewById(R.id.duracio);
            lloc = itemView.findViewById(R.id.lloc);
            assistents = itemView.findViewById(R.id.assistentsTV);

        }

        void bindData(final Moguda moguda){
            iv.setImageResource(moguda.getImageID());
            dataGran.setText(moguda.getDataTop());
            title.setText(moguda.getTitle());
            organitzador.setText(moguda.getOrganitzat());
            duracio.setText(moguda.getDuracio());
            lloc.setText(moguda.getLloc());
            assistents.setText(moguda.getAssistents());

        }

    }

}