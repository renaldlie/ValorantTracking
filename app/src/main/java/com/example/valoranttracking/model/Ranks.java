package com.example.valoranttracking.model;

import com.google.gson.annotations.SerializedName;

public class Ranks {
    @SerializedName("rank")
    private String rank;
    @SerializedName("point")
    private String point;

    public Ranks(String rank, String point) {
        this.rank = rank;
        this.point = point;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

}
