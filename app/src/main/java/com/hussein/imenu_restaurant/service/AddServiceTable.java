package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Admin;
import com.hussein.imenu_restaurant.model.ServiceTable;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 6/10/2016.
 */

public class AddServiceTable extends AsyncTask<Void,Void,Boolean> {
    Context context;
    ServiceTable serviceTable;

    public AddServiceTable(Context context, ServiceTable serviceTable) {
        this.context = context;
        this.serviceTable = serviceTable;
    }


    @Override
    protected Boolean doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        boolean response = restTemplate.postForObject(context.getString(R.string.url)+"table/update",serviceTable,boolean.class);
        return response;
    }
}
