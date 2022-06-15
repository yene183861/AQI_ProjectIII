package com.example.aqi_projectiii.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aqi_projectiii.R;
import com.example.aqi_projectiii.adapter.StationAdapter;

public class HomeFragment extends Fragment {
    private RecyclerView rcvStation;
    private StationAdapter stationAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rcvStation = findViewById(R.id.rcvStation);
        stationAdapter = new StationAdapter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}