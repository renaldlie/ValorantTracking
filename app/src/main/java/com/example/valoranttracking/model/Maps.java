package com.example.valoranttracking.model;

import com.google.gson.annotations.SerializedName;

public class Maps {

    @SerializedName("map_name")
    private String map_name;
    @SerializedName("map_icon")
    private String map_icon;

    public Maps(String map_name, String map_icon) {
        this.map_name = map_name;
        this.map_icon = map_icon;
    }

    public String getMap_name() {
        return map_name;
    }

    public void setMap_name(String map_name) {
        this.map_name = map_name;
    }

    public String getMap_icon() {
        return map_icon;
    }

    public void setMap_icon(String map_icon) {
        this.map_icon = map_icon;
    }

}
