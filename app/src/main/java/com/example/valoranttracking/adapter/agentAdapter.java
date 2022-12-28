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

public class agentAdapter extends RecyclerView.Adapter<agentAdapter.CardViewViewHolder> {

    private Context context;
    public agentAdapter(Context context){ this.context = context; }



    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listdoctor, parent, false);
        return new agentAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull agentAdapter.CardViewViewHolder holder, int position) {

        final Agents agents = null;

        holder.lbl_agent.setText(agents.getName());
        holder.lbl_role.setText(agents.getProdi());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        ImageView img_agent;
        TextView lbl_agent, lbl_role;
        CardView cv;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            img_agent = itemView.findViewById(R.id.img_poster_agent);
            lbl_agent = itemView.findViewById(R.id.lbl_name);
            lbl_role = itemView.findViewById(R.id.lbl_role);


            cv = itemView.findViewById(R.id.cv_card_agent);



        }
    }
}
