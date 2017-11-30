package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kaisu on 30/11/2017.
 */
@Document(collection = "alerts")

public class Alert {
    @Id
    private int id;
    private User user;
    private double latitude;
    private double longitude;
    private String details;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Alert\", " +
                "\"id\":\"" + id + "\"" + ", " +
                "\"user\":" + (user == null ? "null" : user) + ", " +
                "\"latitude\":\"" + latitude + "\"" + ", " +
                "\"longitude\":\"" + longitude + "\"" + ", " +
                "\"details\":" + (details == null ? "null" : "\"" + details + "\"") +
                "}";
    }
}
