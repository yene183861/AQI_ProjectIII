package com.example.aqi_projectiii.localdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
@Entity(tableName = "station")
public class Station {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String idDevice;
    private double temp;
    private double humi;
    private double ppm;
    private String location;
    private LocalDateTime time;

    public Station(String idDevice, double temp, double humi, double ppm, String location, LocalDateTime time) {
        this.idDevice = idDevice;
        this.temp = temp;
        this.humi = humi;
        this.ppm = ppm;
        this.location = location;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String id) {
        this.idDevice = id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumi() {
        return humi;
    }

    public void setHumi(double humi) {
        this.humi = humi;
    }

    public double getPpm() {
        return ppm;
    }

    public void setPpm(double ppm) {
        this.ppm = ppm;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
