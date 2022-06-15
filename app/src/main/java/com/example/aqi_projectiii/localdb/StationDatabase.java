package com.example.aqi_projectiii.localdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Station.class, version = 1)
public abstract class StationDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "station.db";
    private static StationDatabase instance;

    public static synchronized StationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), StationDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract StationDAO stationDAO();
}
