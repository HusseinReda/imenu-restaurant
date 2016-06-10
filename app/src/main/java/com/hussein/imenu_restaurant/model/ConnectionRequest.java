package com.hussein.imenu_restaurant.model;

/**
 * Created by Hussein Abu Maash on 6/10/2016.
 */

public class ConnectionRequest {
    private long id;
    private User user;
    private int secretNumber;

    public ConnectionRequest(int secretNumber, User user) {
        this.secretNumber = secretNumber;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }
}
