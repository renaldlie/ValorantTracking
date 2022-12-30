package com.example.valoranttracking.retrofit;

import com.example.valoranttracking.model.Agents;
import com.example.valoranttracking.model.Maps;
import com.example.valoranttracking.model.Ranks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("mahasiswa/")
    Call<List<Agents>> getAgents();

    @GET("maps/")
    Call<List<Maps>> getMaps();

    @GET("ranks/")
    Call<List<Ranks>> getRanks();

}
