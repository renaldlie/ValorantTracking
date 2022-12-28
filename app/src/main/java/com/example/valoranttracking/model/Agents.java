package com.example.valoranttracking.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Agents implements Parcelable {
    private String Nim;
    private String Name;
    private String Prodi;




    protected Agents(Parcel in) {
        Nim = in.readString();
        Name = in.readString();
        Prodi = in.readString();
    }

    public static final Creator<Agents> CREATOR = new Creator<Agents>() {
        @Override
        public Agents createFromParcel(Parcel in) {
            return new Agents(in);
        }

        @Override
        public Agents[] newArray(int size) {
            return new Agents[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Nim);
        dest.writeString(Name);
        dest.writeString(Prodi);
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        this.Nim = nim;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getProdi() {
        return Prodi;
    }

    public void setProdi(String prodi) {
        this.Prodi = prodi;
    }
}
