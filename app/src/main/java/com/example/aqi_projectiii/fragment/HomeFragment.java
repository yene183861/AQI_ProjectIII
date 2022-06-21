package com.example.aqi_projectiii.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aqi_projectiii.R;
import com.example.aqi_projectiii.adapter.StationAdapter;
import com.example.aqi_projectiii.model.Station;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment{
    private RecyclerView rcvStation;
    private StationAdapter stationAdapter;
    private List<Station> listStation;
//    Calendar c = Calendar.getInstance();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String strDate = sdf.format(c.getTime());
//    Date d = new Date();
//    String str = d.toString();
//    //Calendar c = Calendar.getInstance();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String strDate = sdf.format(d.getTime());

    public HomeFragment() {
        // Required empty public constructor
    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvStation = view.findViewById(R.id.rcvStation);
        rcvStation.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,
                false);
        rcvStation.setLayoutManager(linearLayoutManager);
        stationAdapter = new StationAdapter(view.getContext());
        stationAdapter.setData(getListStation());

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        rcvStation.addItemDecoration(itemDecoration);
        rcvStation.setAdapter(stationAdapter);
       // Log.e("time1", str);
        //Log.e("time2", strDate);
        return view;
    }

    private List<Station> getListStation() {
       List<Station> list = new ArrayList<>();
       String _str = "2022-10-21 02:22:01";
        //Calendar c = Calendar.getInstance();
        String strDt = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date time = Calendar.getInstance().getTime();
        try {
            time = format.parse(_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(new Station("id1", 0.0, 23.4, 145, "Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id1", 0.0, 23.4, 145, "Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id2", 0.0, 0.0, 145, "Hoan Kiem, Ha Noi", "iduser1",time));
        list.add(new Station("id1", 0.0, 23.4, 145, "Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id2", 0.0, 0.0, 145, "Hoan Kiem, Ha Noi", "iduser1",time));
        list.add(new Station("id2", 0.0, 0.0, 145, "Hoan Kiem, Ha Noi", "iduser1",time));
        return list;
    }

}