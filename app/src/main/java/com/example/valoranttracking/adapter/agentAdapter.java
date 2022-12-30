package com.example.valoranttracking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valoranttracking.R;
import com.example.valoranttracking.model.Agents;

import java.util.ArrayList;

public class agentAdapter extends RecyclerView.Adapter<agentAdapter.ViewHolder> {

    ArrayList<Agents> listAgents;

    public agentAdapter(ArrayList<Agents> listAgents) {
        this.listAgents = listAgents;
    }

    @NonNull
    @Override
    public agentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.card_listdoctor, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull agentAdapter.ViewHolder holder, int position) {
        Agents agents = listAgents.get(position);
        holder.name.setText(agents.getName());
        holder.role.setText(agents.getNim());

    }

    @Override
    public int getItemCount() {
        return listAgents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name,role,prodi ;
        public ImageView img_doctor;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lbl_name);
            role = itemView.findViewById(R.id.lbl_role);
        }
    }
}
