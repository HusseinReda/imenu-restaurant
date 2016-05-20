package com.hussein.imenu_restaurant.model;

import java.io.Serializable;

/**
 * Created by hamed on 3/19/16.
 */
public class Contact implements Serializable{
    public Contact(String address, String phoneNumber, int id) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public Contact() {
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    private String address;
    private String phoneNumber;
    private int id;

}
