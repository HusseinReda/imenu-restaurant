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
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hamed on 4/1/16.
 */
public class AddRestaurant extends AsyncTask<Void,Void,String> {
    Context context;
    Restaurant restaurant;

    public AddRestaurant(Context context,Restaurant restaurant) {
        this.context = context;
        this.restaurant=restaurant;
    }

    @Override
    protected String doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        String response = restTemplate.postForObject(context.getString(R.string.url)+"restaurant/add",restaurant,String.class);

        return response;
    }
}
