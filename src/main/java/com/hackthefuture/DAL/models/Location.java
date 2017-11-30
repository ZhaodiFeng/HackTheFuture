package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;

/**
 * Created by kaisu on 30/11/2017.
 */
public class Location {
    @Id
    private int id;

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Location\", " +
                "\"id\":\"" + id + "\"" + ", " +
                "\"latitude\":\"" + latitude + "\"" + ", " +
                "\"longitude\":\"" + longitude + "\"" +
                "}";
    }
}
