package com.hackthefuture.DAL.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by kaisu on 30/11/2017.
 */
@Document(collection = "users")
public class User {
    @Id
    public String id;
    @NotNull
    public String password;
    public String username;
    public List<String> authorities;
    public String lastBezoek;
    public Boolean active;

    public User() {
    }

    public void copy(User user) {
        this.setUsername(user.getUsername());
        this.setAuthorities(user.getAuthorities());
        this.setLastBezoek(user.getLastBezoek());
        this.setActive(user.getActive());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public String getLastBezoek() {
        return lastBezoek;
    }

    public void setLastBezoek(String lastBezoek) {
        this.lastBezoek = lastBezoek;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
