package com.hussein.imenu_restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Hussein Abu Maash on 3/25/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Admin implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String restaurantName;

    public  Admin(){}

    public Admin(String name, String email, String password, String restaurantName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.restaurantName = restaurantName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
