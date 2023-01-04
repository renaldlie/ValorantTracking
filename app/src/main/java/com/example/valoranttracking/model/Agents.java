package com.example.valoranttracking.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Agents {

    @SerializedName("agents_name")
    private String agents_name;
    @SerializedName("agents_role")
    private String agents_role;



    protected Agents(Parcel in) {
        this.agents_name = agents_name;
        this.agents_role = agents_role;
    }

    public String getAgents_name() {
        return agents_name;
    }

    public void setAgents_name(String agents_name) {
        agents_name = agents_name;
    }

    public String getAgents_role() {
        return agents_role;
    }

    public void setAgents_role(String agents_role) {
        agents_role = agents_role;
    }



}

