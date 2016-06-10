package com.hussein.imenu_restaurant.model;

import java.util.List;

/**
 * Created by Hussein Abu Maash on 5/20/2016.
 */

public class Order {
    private Long id;
    double payCheck;
    /*
    There are 3 states
    ------------------
    1 -> not ordered
    2 -> ordered
    3 -> delivered
    4 -> paid
     */
    int state;
    User user;
    ServiceTable serviceTable;
    List<OrderCard> orderCardList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(double payCheck) {
        this.payCheck = payCheck;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceTable getServiceTable() {
        return serviceTable;
    }

    public void setServiceTable(ServiceTable serviceTable) {
        this.serviceTable = serviceTable;
    }

    public List<OrderCard> getOrderCardList() {
        return orderCardList;
    }

    public void setOrderCardList(List<OrderCard> orderCardList) {
        this.orderCardList = orderCardList;
    }
}
