package com.hussein.imenu_restaurant.model;

/**
 * Created by Hussein Abu Maash on 5/20/2016.
 */

public class ServiceTable {
    private long id;
    private Restaurant restaurant;
    private int secretNumber;
    private int state;
    /*
    1 -> unlocked
    2 -> locked
    3 -> connected
    4 -> unconnected

     */

    public ServiceTable(Restaurant restaurant, int state) {
        this.restaurant = restaurant;
        this.state = state;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }
}
