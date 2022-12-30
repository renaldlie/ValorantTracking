package com.example.valoranttracking.retrofit;

import com.example.valoranttracking.model.Agents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("mahasiswa/")
    Call<List<Agents>> getAgents();

}
