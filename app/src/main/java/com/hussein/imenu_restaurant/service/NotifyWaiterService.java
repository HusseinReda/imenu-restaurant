package com.hussein.imenu_restaurant.service;

import android.os.AsyncTask;
import android.util.Log;

import com.hussein.imenu_restaurant.R;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 6/15/2016.
 */

public class NotifyWaiterService extends AsyncTask<Void,Void,Boolean> {

    long orderId;
    public NotifyWaiterService(long orderId){
        this.orderId = orderId;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        final String url=Auxiliary.runningChefActivity.getString(R.string.url) + "waiter/orderDone?orderId="+orderId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        try {
            boolean response = restTemplate.getForObject(url, boolean.class);
        }catch (Exception e){
            Log.i("Notify waiter",e.getMessage().toString());
        }
        return null;
    }
}
