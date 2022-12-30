package com.example.valoranttracking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valoranttracking.R;
import com.example.valoranttracking.model.Maps;

import java.util.ArrayList;

public class mapAdapter extends RecyclerView.Adapter<mapAdapter.ViewHolder>{
    ArrayList<Maps> listMaps;

    public mapAdapter (ArrayList<Maps> listMaps) {
        this.listMaps = listMaps;
    }
    @NonNull
    @Override
    public mapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.card_listmaps, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull mapAdapter.ViewHolder holder, int position) {
        Maps maps = listMaps.get(position);
        holder.map_name.setText(maps.getMap_name());
        holder.map_icon.setText(maps.getMap_icon());
        holder.img_map.setImageResource(R.drawable.ascent);
    }

    @Override
    public int getItemCount() {
        return listMaps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView map_name, map_icon;
        public ImageView img_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            map_name = itemView.findViewById(R.id.lbl_mapname);
            map_icon = itemView.findViewById(R.id.lbl_mapicon);
            img_map = itemView.findViewById(R.id.img_map);

        }
    }
}
