package com.example.valoranttracking.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.valoranttracking.model.Agents;
import com.example.valoranttracking.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgentRepository {

    private static AgentRepository repository;

    private AgentRepository(){}

    public static AgentRepository getInstance(){
        if(repository == null){
            repository = new AgentRepository();
        }
        return repository;
    }

    public MutableLiveData<Agents> getAgentData (String name){
        final MutableLiveData<Agents> result = new MutableLiveData<>();
        ApiService.endpoint().getAgent(name).enqueue(new Callback<Agents>() {
            @Override
            public void onResponse(Call<Agents> call, Response<Agents> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Agents> call, Throwable t) {

            }
        });

        return result;

    }
}
