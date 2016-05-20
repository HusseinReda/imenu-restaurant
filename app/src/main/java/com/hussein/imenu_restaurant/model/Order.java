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
    0 -> not ordered
    1 -> ordered
    2 -> paid
     */
    int state;
    User user;
    ServiceTable serviceTable;
    List<ItemCard> itemCardList;
}
