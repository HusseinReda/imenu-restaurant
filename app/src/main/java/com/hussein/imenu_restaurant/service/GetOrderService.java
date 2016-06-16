package com.hussein.imenu_restaurant.service;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.activity.ChefActivity;
import com.hussein.imenu_restaurant.model.Order;
import com.hussein.imenu_restaurant.userInterface.ItemCardRecyclerViewAdapter;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 6/15/2016.
 */

public class GetOrderService extends AsyncTask<Void,Void,Order> {

    ChefActivity callingActivity;
    String orderId;

    public GetOrderService(ChefActivity callingActivity, String orderId) {
        this.callingActivity = callingActivity;
        this.orderId = orderId;
    }

    @Override
    protected Order doInBackground(Void... params) {
        Log.i("order service "," "+orderId);
        final String url = callingActivity.getString(R.string.url)+"order/getById?id=1";
        RestTemplate restTemplate = new RestTemplate();
        Log.i("order service", "order id: " + orderId);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        Order order=null;
        try{
            order = restTemplate.getForObject(url,Order.class);
            Log.i("Order service","b3d el GET");
        }catch (Exception e){
            Log.i("order service","exception : "+e.getMessage().toString());
        }

        return order;
    }

    @Override
    protected void onPostExecute(Order order) {
        if(order.equals(null)){
            Log.i("order service","a7a");
        }
        Auxiliary.orderList.add(order);
        Auxiliary.orderCardList.addAll(order.getOrderCardList());
        callingActivity.orderItemsAdapter.notifyDataSetChanged();
    }
}
