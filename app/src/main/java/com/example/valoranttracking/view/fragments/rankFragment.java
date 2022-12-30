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
import com.example.valoranttracking.adapter.mapAdapter;
import com.example.valoranttracking.adapter.rankAdapter;
import com.example.valoranttracking.model.Ranks;
import com.example.valoranttracking.retrofit.ApiEndPoint;
import com.example.valoranttracking.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link rankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class rankFragment extends Fragment {

    ApiEndPoint apiEndPoint;
    RecyclerView recRanks;
    rankAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public rankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static rankFragment newInstance(String param1, String param2) {
        rankFragment fragment = new rankFragment();
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
        getAllRanks();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        recRanks = view.findViewById(R.id.rv_ranks);

        recRanks.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void getAllRanks(){
        Call<List<Ranks>> getRanks = apiEndPoint.getRanks();
        getRanks.enqueue(new Callback<List<Ranks>>() {
            @Override
            public void onResponse(Call<List<Ranks>> call, Response<List<Ranks>> response) {
                ArrayList<Ranks> listRanks = (ArrayList<Ranks>) response.body();
                Log.d("list_ranks: ", response.raw().body().toString());
                Log.d("list_ranks: ", listRanks.toString());

                adapter = new rankAdapter(listRanks);
                recRanks.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Ranks>> call, Throwable t) {
                Log.d("error_news: ", t.getMessage());
            }
        });
    }
}