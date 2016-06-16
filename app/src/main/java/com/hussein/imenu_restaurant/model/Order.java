package com.hussein.imenu_restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    long serviceTableId;
    List<OrderCard> orderCardList;

    public Order() {
    }


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

    public long getServiceTableId() {
        return serviceTableId;
    }

    public void setServiceTableId(long serviceTableId) {
        this.serviceTableId = serviceTableId;
    }

    public List<OrderCard> getOrderCardList() {
        return orderCardList;
    }

    public void setOrderCardList(List<OrderCard> orderCardList) {
        this.orderCardList = orderCardList;
    }

    public void addOrderCard(OrderCard orderCard){
        orderCardList.add(orderCard);
    }

    public void removeOrderCard(OrderCard orderCard){
        orderCardList.remove(orderCard);
    }
}
