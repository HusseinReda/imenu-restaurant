package com.hussein.imenu_restaurant.model;

/**
 * Created by Hussein Abu Maash on 5/21/2016.
 */

public class Employee {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Restaurant restaurant;
    public  Employee(){}
    public Employee(String name, String email, String password, Restaurant restaurant) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.restaurant = restaurant;
    }
}
