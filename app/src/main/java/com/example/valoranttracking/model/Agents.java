package com.example.valoranttracking.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Agents {
    private String nim;
    private String name;
    private String prodi;




    protected Agents(Parcel in) {
        this.nim = nim;
        this.name = name;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        prodi = prodi;
    }
}

