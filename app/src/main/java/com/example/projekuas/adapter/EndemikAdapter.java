package com.example.projekuas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekuas.R;
import com.example.projekuas.database.EndemikEntity;

import java.util.List;

public class EndemikAdapter extends RecyclerView.Adapter<EndemikAdapter.ViewHolder>{

    public interface OnItemClickListener{
        void onClick(EndemikEntity item);
    }

    private OnItemClickListener listener;

    private List<EndemikEntity> list;

    public EndemikAdapter(List<EndemikEntity> list,
                          OnItemClickListener listener){

        this.list = list;

        this.listener = listener;

    }

    public void updateData(List<EndemikEntity> newList) {

        this.list = newList;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_endemik,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EndemikEntity item = list.get(position);

        holder.txtNama.setText(item.nama);

        Glide.with(holder.itemView.getContext())
                .load(item.foto)
                .into(holder.imgFoto);

        holder.itemView.setOnClickListener(v->{

            listener.onClick(item);

        });

    }

    @Override
    public int getItemCount() {

        return list.size();

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFoto;

        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto);

            txtNama = itemView.findViewById(R.id.txtNama);

        }

    }


}