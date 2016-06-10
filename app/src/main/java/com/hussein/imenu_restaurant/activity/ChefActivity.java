package com.hussein.imenu_restaurant.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Item;
import com.hussein.imenu_restaurant.model.OrderCard;
import com.hussein.imenu_restaurant.userInterface.ItemCardRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChefActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ItemCardRecyclerViewAdapter orderItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.chef_recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<OrderCard> orderCards = new ArrayList<OrderCard>();
        Item item = new Item("hamada","hamada rest","sandwich",34.6,"description",null,null);
        item.setId(3);
        OrderCard orderCard = new OrderCard(item,4,1);
        orderCards.add(orderCard);
        Item item2 = new Item("hamada","hamada rest","sandwich",34.6,"description",null,null);
        item.setId(4);
        OrderCard orderCard2 = new OrderCard(item2,4,1);
        orderCards.add(orderCard2);
        Item item3 = new Item("hamada","hamada rest","sandwich",34.6,"description",null,null);
        item.setId(5);
        OrderCard orderCard3 = new OrderCard(item3,4,1);
        orderCards.add(orderCard3);
        orderItemsAdapter= new ItemCardRecyclerViewAdapter(orderCards,this);
        recyclerView.setAdapter(orderItemsAdapter);
        orderItemsAdapter.notifyDataSetChanged();
    }

}
