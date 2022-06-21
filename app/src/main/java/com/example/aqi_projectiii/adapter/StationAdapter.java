package com.example.aqi_projectiii.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aqi_projectiii.R;
import com.example.aqi_projectiii.model.Station;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {
    private Context context;
    private List<Station> listStation;

    public StationAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Station> listStation) {
        this.listStation = listStation;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        return new StationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StationViewHolder holder, int position) {
        Station station = listStation.get(position);
        if (station == null) {
            return;
        }
//        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
//        String date = df.format(station.getTime());
        holder.txtLocation.setText(station.getLocation());
        holder.txtValueAQI.setText(station.getPpm() + " ppm");
        holder.txtValueHumi.setText(station.getHumi() + " %");
        holder.txtValueTemp.setText(station.getTemp() + " °C");

        //Date time = Calendar.getInstance().getTime();
//        String time = "";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
//        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Log.e("time", station.getDatetime().toString());
//            Date
//            time = newFormat.parse(station.getDatetime().toString()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        holder.txtTime.setText(station.getDatetime().toString());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail(station);
            }
        });
    }

    private void onClickGoToDetail(Station station) {
    }

    @Override
    public int getItemCount() {
        if (listStation != null) {
            return listStation.size();
        }
        return 0;
    }

    public class StationViewHolder extends RecyclerView.ViewHolder {
        private TextView txtAirState, txtValueAQI, txtLocation, txtValueTemp, txtValueHumi, txtTime;
        private ImageView image;
        private CardView layoutItem;

        public StationViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layoutItem);
            txtAirState = itemView.findViewById(R.id.txtAirState);
            txtValueAQI = itemView.findViewById(R.id.txtValueAQI);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtValueTemp = itemView.findViewById(R.id.txtValueTemp);
            txtValueHumi = itemView.findViewById(R.id.txtValueHumi);
            txtTime = itemView.findViewById(R.id.txtTime);
            image = itemView.findViewById(R.id.image);
        }
    }
}


