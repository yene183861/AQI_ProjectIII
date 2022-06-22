package com.example.aqi_projectiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aqi_projectiii.model.Station;

public class DetailActivity extends AppCompatActivity {
//private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //test = findViewById(R.id.test);

        Intent intent = getIntent();
        Station station = (Station) intent.getSerializableExtra("station");
        //test.setText(station.getDeviceId());
    }
}