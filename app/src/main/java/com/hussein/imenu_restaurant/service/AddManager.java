package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Manager;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 6/8/2016.
 */

public class AddManager extends AsyncTask<Void,Void,Boolean> {
    Context context;
    Manager manager;

    public AddManager(Context context, Manager manager) {
        this.context = context;
        this.manager = manager;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        boolean response=false;
        try {
            response = restTemplate.postForObject(context.getString(R.string.url)+"manager/signUp", manager,boolean.class);
        }
        catch (Exception e){
            Log.i("add chef", e.getMessage().toString());
        }
        return response;
    }
}
