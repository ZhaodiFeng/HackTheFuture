package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kaisu on 30/11/2017.
 */
@Document(collection = "alerts")

public class Alert {
    @Id
    private String id;
    private User user;
    private String latitude;
    private String longitude;
    private String details;

    public Alert() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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
                "\"id\":" + (id == null ? "null" : "\"" + id + "\"") + ", " +
                "\"user\":" + (user == null ? "null" : user) + ", " +
                "\"latitude\":" + (latitude == null ? "null" : "\"" + latitude + "\"") + ", " +
                "\"longitude\":" + (longitude == null ? "null" : "\"" + longitude + "\"") + ", " +
                "\"details\":" + (details == null ? "null" : "\"" + details + "\"") +
                "}";
    }
}
