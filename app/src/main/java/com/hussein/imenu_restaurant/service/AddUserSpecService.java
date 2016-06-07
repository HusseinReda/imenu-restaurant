package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.UserSpec;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Hussein Abu Maash on 5/2/2016.
 */

public class AddUserSpecService extends AsyncTask<Void,Void,Void>{
    Context context;
    UserSpec userSpec;

    public AddUserSpecService(Context context, UserSpec userSpec) {
        this.context = context;
        this.userSpec = userSpec;
    }

    @Override
    protected Void doInBackground(Void... params) {
        RestTemplate restTemplate=  new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        String response = restTemplate.postForObject(context.getString(R.string.url)+"userSpec/add",userSpec,String.class);
        return null;
    }
}
