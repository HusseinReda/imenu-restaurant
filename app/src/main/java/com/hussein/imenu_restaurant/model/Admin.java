package com.hussein.imenu_restaurant.model;

import java.util.Date;

/**
 * Created by Hussein Abu Maash on 3/25/2016.
 */

public class Admin extends Employee{
    public Admin(String name, String email, String password, Restaurant restaurant) {
        super(name, email, password, restaurant);
    }
}
