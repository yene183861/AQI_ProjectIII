package com.example.aqi_projectiii.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;

//@Entity
public class Station implements Serializable {
    //@PrimaryKey(autoGenerate = true)
    private int id;
    private String deviceId;
    private double temp;
    private double humi;
    private double co;
    private double co2;
    private String location;
    private String userId;
    @TypeConverters({DateTypeConvertor.class})
    private Date datetime;

    public Station(String deviceId, double temp, double humi, double co, double co2, String location, String userId, Date datetime) {
        this.deviceId = deviceId;
        this.temp = temp;
        this.humi = humi;
        this.co = co;
        this.co2 = co2;
        this.location = location;
        this.userId = userId;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
