package com.hussein.imenu_restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Hussein Abu Maash on 6/10/2016.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Waiter implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Restaurant restaurant;
    public  Waiter(){}
    public Waiter(String name, String email, String password, Restaurant restaurant) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.restaurant = restaurant;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
