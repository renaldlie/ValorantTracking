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
import com.example.valoranttracking.model.Weapons;

import java.util.ArrayList;

public class weaponAdapter extends RecyclerView.Adapter<weaponAdapter.ViewHolder> {
    ArrayList<Weapons> listWeapons;

    public weaponAdapter (ArrayList<Weapons> listWeapons){
        this.listWeapons = listWeapons;
    }

    @NonNull
    @Override
    public weaponAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        weaponAdapter.ViewHolder holder = new weaponAdapter.ViewHolder(inflater.inflate(R.layout.card_weapon, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull weaponAdapter.ViewHolder holder, int position) {
        Weapons weapons = listWeapons.get(position);
        holder.weapon_name.setText(weapons.getWeapon_name());
        holder.weapon_kill.setText(weapons.getWeapon_kill());
        holder.weapon_dmg.setText(weapons.getWeapon_dmg());
        holder.weapon_headshot.setText(weapons.getWeapon_headshotrate());
        holder.img_weapon.setImageResource(R.drawable.vandal);

    }

    @Override
    public int getItemCount() {
        return listWeapons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView weapon_name, weapon_kill, weapon_dmg, weapon_headshot;
        public ImageView img_weapon;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            weapon_name = itemView.findViewById(R.id.lbl_weapon_name);
            weapon_kill = itemView.findViewById(R.id.lbl_weapon_kill);
            weapon_headshot = itemView.findViewById(R.id.lbl_weapon_headshot);
            weapon_dmg = itemView.findViewById(R.id.lbl_weapon_damage);
            img_weapon = itemView.findViewById(R.id.img_weapon);
        }
    }
}
