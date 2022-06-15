package com.example.aqi_projectiii.localdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface StationDAO {
    @Query("SELECT * FROM station")
    List<Station> getListStation();

    @Query("SELECT * FROM station WHERE id IN (:userId)")
    List<Station> getStationById(int[] userId);
@Insert
void insertStation(Station station);

}
