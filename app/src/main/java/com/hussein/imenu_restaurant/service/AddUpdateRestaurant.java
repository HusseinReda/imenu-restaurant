package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.activity.LoginActivity;
import com.hussein.imenu_restaurant.model.Item;
import com.hussein.imenu_restaurant.model.Menu;
import com.hussein.imenu_restaurant.model.Restaurant;
import com.hussein.imenu_restaurant.model.Section;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hamed on 4/1/16.
 */
public class AddUpdateRestaurant extends AsyncTask<Void,Void,Boolean> {
    Context context;
    Restaurant restaurant;
    boolean type; // true: add , false: update

    public AddUpdateRestaurant(Context context, Restaurant restaurant, boolean type) {
        this.context = context;
        this.restaurant=restaurant;
        this.type = type;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        boolean response;
        if(type)
            response = restTemplate.postForObject(context.getString(R.string.url) + "restaurant/add", restaurant, boolean.class);
        else
            response = restTemplate.postForObject(context.getString(R.string.url)+"restaurant/update",restaurant,boolean.class);
        return response;
    }
}
