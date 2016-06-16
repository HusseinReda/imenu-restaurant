package com.hussein.imenu_restaurant.service;

import com.hussein.imenu_restaurant.activity.ChefActivity;
import com.hussein.imenu_restaurant.activity.NotificationsDialogFragment;
import com.hussein.imenu_restaurant.activity.WaiterActivity;
import com.hussein.imenu_restaurant.model.Order;
import com.hussein.imenu_restaurant.model.OrderCard;
import com.hussein.imenu_restaurant.model.Waiter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hussein Abu Maash on 6/15/2016.
 */

public class Auxiliary {
    public static ChefActivity runningChefActivity;

    public static WaiterActivity runningWaiterActivity;

    public static NotificationsDialogFragment runningNotificationsDialogFragment;

    public static List<String> notificationList;

    public static List<Order> orderList;

    public static List<OrderCard> orderCardList;

    public static ChefActivity getRunningChefActivity() {
        return runningChefActivity;
    }

    public static void setRunningNotificationsDialogFragment(NotificationsDialogFragment runningNotificationsDialogFragment) {
        Auxiliary.runningNotificationsDialogFragment = runningNotificationsDialogFragment;
    }

    public static void setRunningChefActivity(ChefActivity runningChefActivity) {
        Auxiliary.runningChefActivity = runningChefActivity;
    }

    public static void setRunningWaiterActivity(WaiterActivity runningWaiterActivity) {
        Auxiliary.runningWaiterActivity = runningWaiterActivity;
    }

    public static void initNotificationList(){
        notificationList = new ArrayList<>();
    }

    public static void initOrderList(){
        orderList = new ArrayList<>();
    }

    public static void initOrderCardList(){
        orderCardList = new ArrayList<>();
    }

    public static int getIncludingOrderIndex (long orderCardId){

        for(int i=0;i<orderList.size();i++){
            for(int c=0;c<orderList.get(i).getOrderCardList().size();c++){
                if(orderList.get(i).getOrderCardList().get(c).getId()==orderCardId)
                    return i;
            }
        }
        return -1;
    }

    public static int getIncludingOrderCardIndex(int orderIndex,long orderCardId){
        for(int i=0;i<orderList.get(orderIndex).getOrderCardList().size();i++){
            if(orderList.get(orderIndex).getOrderCardList().get(i).getId()==orderCardId)
                return i;
        }
        return -1;
    }

    public static WaiterActivity getRunningWaiterActivity() {
        return runningWaiterActivity;
    }

    public static NotificationsDialogFragment getRunningNotificationsDialogFragment() {
        return runningNotificationsDialogFragment;
    }

    public static List<String> getNotificationList() {
        return notificationList;
    }

    public static void setNotificationList(List<String> notificationList) {
        Auxiliary.notificationList = notificationList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<Order> orderList) {
        Auxiliary.orderList = orderList;
    }

    public static List<OrderCard> getOrderCardList() {
        return orderCardList;
    }

    public static void setOrderCardList(List<OrderCard> orderCardList) {
        Auxiliary.orderCardList = orderCardList;
    }
}
