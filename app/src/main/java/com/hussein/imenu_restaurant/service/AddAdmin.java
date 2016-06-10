package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Admin;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 6/8/2016.
 */

public class AddAdmin extends AsyncTask<Void,Void,String> {
    Context context;
    Admin admin;

    public AddAdmin(Context context, Admin admin) {
        this.context = context;
        this.admin=admin;
    }

    @Override
    protected String doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String response = restTemplate.postForObject(context.getString(R.string.url)+"admin/add",admin,String.class);
        return response;
    }
}
