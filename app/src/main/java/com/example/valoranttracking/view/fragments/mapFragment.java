package com.example.valoranttracking.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.valoranttracking.R;
import com.example.valoranttracking.adapter.agentAdapter;
import com.example.valoranttracking.adapter.mapAdapter;
import com.example.valoranttracking.model.Maps;
import com.example.valoranttracking.retrofit.ApiEndPoint;
import com.example.valoranttracking.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mapFragment extends Fragment {

    ApiEndPoint apiEndPoint;
    RecyclerView recMaps;
    mapAdapter adapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static mapFragment newInstance(String param1, String param2) {
        mapFragment fragment = new mapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        apiEndPoint = ApiService.getClient().create(ApiEndPoint.class);
        getAllMaps();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        recMaps = view.findViewById(R.id.rv_maps);

        recMaps.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;


    }

    public void getAllMaps(){
        Call<List<Maps>> getNews = apiEndPoint.getMaps();
        getNews.enqueue(new Callback<List<Maps>>() {
            @Override
            public void onResponse(Call<List<Maps>> call, Response<List<Maps>> response) {
                ArrayList<Maps> listMaps = (ArrayList<Maps>) response.body();
                Log.d("list_maps: ", response.raw().body().toString());
                Log.d("list_maps: ", listMaps.toString());

                adapter = new mapAdapter(listMaps);
                recMaps.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Maps>> call, Throwable t) {
                Log.d("error_news: ", t.getMessage());
            }
        });
    }
}