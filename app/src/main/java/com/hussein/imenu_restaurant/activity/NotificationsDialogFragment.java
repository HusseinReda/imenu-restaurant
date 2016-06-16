package com.hussein.imenu_restaurant.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.service.Auxiliary;
import com.hussein.imenu_restaurant.userInterface.NotificationsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hussein Abu Maash on 6/14/2016.
 */

public class NotificationsDialogFragment extends DialogFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public NotificationsRecyclerViewAdapter notificationsRecyclerViewAdapter;
    private FloatingActionButton fab;

    public void setFab(FloatingActionButton fab) {
        this.fab = fab;
    }

    public NotificationsDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static NotificationsDialogFragment newInstance(String title,FloatingActionButton fab) {
        NotificationsDialogFragment frag = new NotificationsDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        frag.setFab(fab);
        Auxiliary.setRunningNotificationsDialogFragment(frag);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_dialog_layout, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        recyclerView = (RecyclerView) view.findViewById(R.id.notification_dialog_recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        notificationsRecyclerViewAdapter = new NotificationsRecyclerViewAdapter(view.getContext(),fab);
        if(notificationsRecyclerViewAdapter.getItemCount()==0)
            Toast.makeText(view.getContext(),"No notifications",Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(notificationsRecyclerViewAdapter);
    }
}
