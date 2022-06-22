package com.example.aqi_projectiii.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

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
    String clientId = MqttClient.generateClientId();
    MqttAndroidClient client =
            new MqttAndroidClient(this.getActivity().getApplicationContext(), "tcp://broker.hivemq.com:1883",
                    clientId);
    //private List<Station> listStation;
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
        list.add(new Station("id1", 0.0, 23.4, 145, 34,"Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id2", 0.0, 23.4, 145, 34, "Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id3", 0.0, 0.0, 145, 34, "Hoan Kiem, Ha Noi", "iduser1",time));
        list.add(new Station("id4", 0.0, 23.4, 145, 34, "Hoan Kiem, Ha Noi", "iduser1", time));
        list.add(new Station("id5", 0.0, 0.0, 145, 34, "Hoan Kiem, Ha Noi", "iduser1",time));
        list.add(new Station("id6", 0.0, 0.0, 145,34, "Hoan Kiem, Ha Noi", "iduser1",time));
        return list;
    }

    private void connectMQTT(){
        String username = "project3";
        String password = "pass_project3";

        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d("MQTT", "onSuccess");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d("MQTT", "onFailure");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void subscribe(String topic){
        int qos = 1;
        try {
            IMqttToken subToken = client.subscribe(topic, qos);
            subToken.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // The message was published
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken,
                                      Throwable exception) {
                    // The subscription could not be performed, maybe the user was not
                    // authorized to subscribe on the specified topic e.g. using wildcards

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


}