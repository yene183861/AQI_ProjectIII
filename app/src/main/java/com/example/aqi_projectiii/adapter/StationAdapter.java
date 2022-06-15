package com.example.aqi_projectiii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aqi_projectiii.R;
import com.example.aqi_projectiii.localdb.Station;

import java.util.List;

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
        holder.txtLocation.setText(station.getLocation());
        holder.txtValueAQI.setText(station.getPpm() + " ppm");
        holder.txtValueHumi.setText(station.getHumi() + " %");
        holder.txtValueTemp.setText(station.getTemp() + " °C");
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

        public StationViewHolder(@NonNull View itemView) {
            super(itemView);

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


