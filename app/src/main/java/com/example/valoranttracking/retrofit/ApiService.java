package com.example.valoranttracking.retrofit;

import com.example.valoranttracking.helper.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;

    public static ApiEndPoint endpoint(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(ApiEndPoint.class);
    }
}
