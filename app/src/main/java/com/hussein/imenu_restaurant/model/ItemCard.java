package com.hussein.imenu_restaurant.model;

/**
 * Created by Hussein Abu Maash on 5/20/2016.
 */

public class ItemCard {
    private Long id;
    Item item;
    int count;
    /*
    There are 5 states
    ------------------
    0 -> not ordered
    1 -> ordered
    2 -> in_due
    3 -> done
    4 -> paid
     */
    int state;
}
