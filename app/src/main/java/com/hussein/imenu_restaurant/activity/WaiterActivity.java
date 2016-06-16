package com.hussein.imenu_restaurant.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.ServiceTable;
import com.hussein.imenu_restaurant.service.Auxiliary;
import com.hussein.imenu_restaurant.service.GetServiceTablesService;
import com.hussein.imenu_restaurant.userInterface.ServiceTablesRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class WaiterActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public GridLayoutManager gridLayoutManager;
    public ServiceTablesRecyclerViewAdapter tablesGridAdapter;
    public FloatingActionButton fab;
    public ProgressBar progressBar;
    public NotificationsDialogFragment notificationsDialogFragment;
    public FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Auxiliary.setRunningWaiterActivity(this);

        fab = (FloatingActionButton) findViewById(R.id.notification_button);

        fm = getSupportFragmentManager();
        notificationsDialogFragment = NotificationsDialogFragment.newInstance("Notifications", fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setBackgroundTintList(ColorStateList.valueOf(0xff94ff92));
                notificationsDialogFragment.show(fm, "notification_dialog_layout");
            }
        });

//        List<ServiceTable> serviceTables = new ArrayList<>();
//        ServiceTable serviceTable1 = new ServiceTable("KFC",111,1);
//        ServiceTable serviceTable2 = new ServiceTable("KFC",222,2);
//        ServiceTable serviceTable3 = new ServiceTable("KFC",333,3);
//        ServiceTable serviceTable4 = new ServiceTable("KFC",444,4);
//        ServiceTable serviceTable5 = new ServiceTable("KFC",555,1);
//        ServiceTable serviceTable6 = new ServiceTable("KFC",666,1);
//        ServiceTable serviceTable7 = new ServiceTable("KFC",777,1);
//        ServiceTable serviceTable8 = new ServiceTable("KFC",888,1);
//        serviceTables.add(serviceTable1);
//        serviceTables.add(serviceTable2);
//        serviceTables.add(serviceTable3);
//        serviceTables.add(serviceTable4);
//        serviceTables.add(serviceTable5);
//        serviceTables.add(serviceTable6);
//        serviceTables.add(serviceTable7);
//        serviceTables.add(serviceTable8);

        progressBar = (ProgressBar) findViewById(R.id.home_progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView) findViewById(R.id.waiter_recycler_view);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        GetServiceTablesService getServiceTablesService = new GetServiceTablesService(this,"KFC",recyclerView,progressBar);
        getServiceTablesService.execute();
        //tablesGridAdapter.notifyDataSetChanged();
    }

}
