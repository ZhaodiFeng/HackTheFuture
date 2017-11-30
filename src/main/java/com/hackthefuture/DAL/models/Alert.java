package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;

/**
 * Created by kaisu on 30/11/2017.
 */
public class Alert {
    @Id
    private int id;
    private User user;
    private Location location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
                "\"location\":" + (location == null ? "null" : location) + ", " +
                "\"details\":" + (details == null ? "null" : "\"" + details + "\"") +
                "}";
    }
}
