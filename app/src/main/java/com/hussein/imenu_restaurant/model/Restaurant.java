package com.hussein.imenu_restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hamed on 3/19/16.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class    Restaurant implements Serializable {
    private int id;
    private String name;
    private String category;
    private String description;
    private String picture;
    private Menu menu;
    private List<Contact> contacts;
    private ArrayList<RestaurantReview> reviews;
    private List<ServiceTable> serviceTables;
    private Chef chef;
    private Waiter waiter;
    private Manager manager;
    private Cashier cashier;
    private float rating;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public Menu getMenu() {
        return menu;
    }

    public List getContacts() {
        return contacts;
    }

    public ArrayList<RestaurantReview> getReviews() {
        return reviews;
    }

    public float getRating() {
        return rating;
    }

    public void addMenu (Menu menu){
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setReviews(ArrayList<RestaurantReview> reviews) {
        this.reviews = reviews;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ServiceTable> getServiceTables() {
        return serviceTables;
    }

    public void setServiceTables(List<ServiceTable> serviceTables) {
        this.serviceTables = serviceTables;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Restaurant() {
    }

    public Restaurant(String name, String category, String description, String picture, Menu menu, ArrayList<Contact> contacts) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.picture = picture;
        this.menu = menu;
        this.contacts = contacts;
    }

    public void addContact (Contact contact){
        contacts.add(contact);
        // call the service
    }

    public void addReview (RestaurantReview review){
        reviews.add(review);
        // call the service
    }

}
