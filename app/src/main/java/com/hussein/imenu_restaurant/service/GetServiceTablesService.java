package com.hussein.imenu_restaurant.service;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.activity.WaiterActivity;
import com.hussein.imenu_restaurant.model.ServiceTable;
import com.hussein.imenu_restaurant.model.Waiter;
import com.hussein.imenu_restaurant.userInterface.ServiceTablesRecyclerViewAdapter;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hussein Abu Maash on 6/16/2016.
 */

public class GetServiceTablesService extends AsyncTask<Void,Void,List<ServiceTable>> {

    WaiterActivity context;
    String restaurantName;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Exception error;

    public GetServiceTablesService(WaiterActivity context, String restaurantName, RecyclerView recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.restaurantName = restaurantName;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        context.setProgressBarIndeterminateVisibility(true);
    }

    @Override
    protected List<ServiceTable> doInBackground(Void... params) {

        Log.i("get All tables", "service started");
        final String url = context.getString(R.string.url)+"table/getByRestaurantName?restaurantName="+restaurantName;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        try {
            ServiceTable[] tables = restTemplate.getForObject(url, ServiceTable[].class);
            return Arrays.asList(tables);
        }
        catch (Exception e){
            this.error=e;
            Log.i("getAll service","error caught");
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<ServiceTable> tables) {

        progressBar.setVisibility(View.GONE);
        Log.i("get All table", String.valueOf(tables.size()));
        if(tables.size()!=0){
            Log.i("get All table", String.valueOf(tables.size())+" 2");
            ServiceTablesRecyclerViewAdapter adapter= new ServiceTablesRecyclerViewAdapter(tables,context);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            Log.i("get All tables", String.valueOf(tables.size()) + " 4");
        }
        else {
            Toast.makeText(context, "There is a problem in the server\nPlease try again later", Toast.LENGTH_LONG).show();
        }
    }
}
