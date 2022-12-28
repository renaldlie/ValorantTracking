package com.example.valoranttracking.retrofit;

import com.example.valoranttracking.model.Agents;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("")
    Call<Agents> getAgent(

            String name);

}
