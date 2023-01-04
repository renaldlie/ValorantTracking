package com.example.valoranttracking.model;

import com.google.gson.annotations.SerializedName;

public class Weapons {
    @SerializedName("weapon_name")
    private String weapon_name;
    @SerializedName("weapon_dmg")
    private String weapon_dmg;
    @SerializedName("weapon_headshotrate")
    private String weapon_headshotrate;
    @SerializedName("weapon_kill")
    private String weapon_kill;

    public Weapons(String weapon_name, String weapon_dmg, String weapon_headshotrate, String weapon_kill) {
        this.weapon_name = weapon_name;
        this.weapon_dmg = weapon_dmg;
        this.weapon_headshotrate = weapon_headshotrate;
        this.weapon_kill = weapon_kill;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public String getWeapon_dmg() {
        return weapon_dmg;
    }

    public void setWeapon_dmg(String weapon_dmg) {
        this.weapon_dmg = weapon_dmg;
    }

    public String getWeapon_headshotrate() {
        return weapon_headshotrate;
    }

    public void setWeapon_headshotrate(String weapon_headshotrate) {
        this.weapon_headshotrate = weapon_headshotrate;
    }

    public String getWeapon_kill() {
        return weapon_kill;
    }

    public void setWeapon_kill(String weapon_kill) {
        this.weapon_kill = weapon_kill;
    }
}
