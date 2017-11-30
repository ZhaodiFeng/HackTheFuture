package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;

/**
 * Created by kaisu on 30/11/2017.
 */
public class Alert {
    @Id
    public int id;
    private User user;
    public Location location;


}
