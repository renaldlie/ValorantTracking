package com.example.valoranttracking.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valoranttracking.R;
import com.example.valoranttracking.model.Ranks;

import java.util.ArrayList;

public class rankAdapter extends RecyclerView.Adapter<rankAdapter.ViewHolder> {
    ArrayList<Ranks> listRanks;

    public rankAdapter (ArrayList<Ranks> listRanks) {
        this.listRanks = listRanks;
    }

    @NonNull
    @Override
    public rankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new rankAdapter.ViewHolder(inflater.inflate(R.layout.card_rank, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull rankAdapter.ViewHolder holder, int position) {
        Ranks ranks = listRanks.get(position);
        holder.rank.setText(ranks.getRank());
        holder.point.setText(ranks.getPoint());
        holder.img_rank.setImageResource(R.drawable.valorant_radiant);
        holder.img_player.setImageResource(R.drawable.valorant_player_card);

    }

    @Override
    public int getItemCount() {
        return listRanks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView rank, point;
        public ImageView img_player, img_rank;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            rank = itemView.findViewById(R.id.lbl_rank_name);
            point = itemView.findViewById(R.id.lbl_rank_point);
            img_player = itemView.findViewById(R.id.img_player);
            img_rank = itemView.findViewById(R.id.img_rank);
        }
    }
}
