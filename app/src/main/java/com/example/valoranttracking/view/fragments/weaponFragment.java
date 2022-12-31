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
import com.example.valoranttracking.adapter.rankAdapter;
import com.example.valoranttracking.adapter.weaponAdapter;
import com.example.valoranttracking.model.Ranks;
import com.example.valoranttracking.model.Weapons;
import com.example.valoranttracking.retrofit.ApiEndPoint;
import com.example.valoranttracking.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weaponFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weaponFragment extends Fragment {

    ApiEndPoint apiEndPoint;
    RecyclerView recWeapons;
    weaponAdapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public weaponFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeaponFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static weaponFragment newInstance(String param1, String param2) {
        weaponFragment fragment = new weaponFragment();
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
        getAllWeapons();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);
        recWeapons = view.findViewById(R.id.rv_weapons);

        recWeapons.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void getAllWeapons(){
        Call<List<Weapons>> getWeapons = apiEndPoint.getWeapons();
        getWeapons.enqueue(new Callback<List<Weapons>>() {
            @Override
            public void onResponse(Call<List<Weapons>> call, Response<List<Weapons>> response) {
                ArrayList<Weapons> listWeapons = (ArrayList<Weapons>) response.body();
                Log.d("list_weapons: ", response.raw().body().toString());
                Log.d("list_weapons: ", listWeapons.toString());

                adapter = new weaponAdapter(listWeapons);
                recWeapons.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Weapons>> call, Throwable t) {
                Log.d("error_news: ", t.getMessage());
            }
        });
    }
}