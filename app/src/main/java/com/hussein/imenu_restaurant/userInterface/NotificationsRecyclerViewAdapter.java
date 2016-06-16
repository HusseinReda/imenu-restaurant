package com.hussein.imenu_restaurant.userInterface;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.service.Auxiliary;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hussein Abu Maash on 6/14/2016.
 */

public class NotificationsRecyclerViewAdapter extends RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ItemViewHolder>{
    List<String> notifications;
    Context context;
    FloatingActionButton fab;

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

        CardView cardView;
        TextView notificationText;
        ImageView notificationImage;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.notification_card_view);
            notificationText = (TextView) itemView.findViewById(R.id.notification_card_view_text);
            notificationImage = (ImageView) itemView.findViewById(R.id.notification_card_view_image);
            cardView.setLongClickable(true);
            cardView.setOnLongClickListener(this);
        }



        @Override
        public boolean onLongClick(View v) {
            notifications.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
            return true;
        }
    }



    public NotificationsRecyclerViewAdapter(Context context, FloatingActionButton fab) {
        this.notifications = Auxiliary.notificationList;
        this.context = context;
        this.fab = fab;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card_layout,parent,false);
        ItemViewHolder itemViewHolder= new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {

        String currentNotification = notifications.get(i);
        String textToBePrinted;
        if(currentNotification.substring(0,4).equals("chef")) {
            textToBePrinted="Table "+currentNotification.substring(5)+"'s order is ready";
            itemViewHolder.notificationText.setText(textToBePrinted);
            Picasso.with(context).load(R.drawable.food_icon).into(itemViewHolder.notificationImage);
        }
        else {
            textToBePrinted="Table "+currentNotification.substring(5)+" is calling";
            itemViewHolder.notificationText.setText(textToBePrinted);
            Picasso.with(context).load(R.drawable.call_waiter_icon).into(itemViewHolder.notificationImage);
        }

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

}
