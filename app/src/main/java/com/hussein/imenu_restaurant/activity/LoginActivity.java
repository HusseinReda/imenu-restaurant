package com.hussein.imenu_restaurant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.service.Auxiliary;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Auxiliary.initOrderList();
        Auxiliary.initOrderCardList();
        Auxiliary.initNotificationList();

        Button adminLogin = (Button) findViewById(R.id.admin_login);
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminIntent = new Intent(LoginActivity.this, AdminActivity.class);
                adminIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(adminIntent);
            }
        });

        Button chefLogin = (Button) findViewById(R.id.chef_login);
        chefLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chefIntent = new Intent(LoginActivity.this, ChefActivity.class);
                chefIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(chefIntent);
            }
        });

        Button waiterLogin = (Button) findViewById(R.id.waiter_login);
        waiterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent waiterIntent = new Intent(LoginActivity.this, WaiterActivity.class);
                waiterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(waiterIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
