package com.hussein.imenu_restaurant.userInterface;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Order;
import com.hussein.imenu_restaurant.model.OrderCard;
import com.hussein.imenu_restaurant.service.Auxiliary;
import com.hussein.imenu_restaurant.service.NotifyWaiterService;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hussein Abu Maash on 4/10/2016.
 */

public class ItemCardRecyclerViewAdapter extends RecyclerView.Adapter<ItemCardRecyclerViewAdapter.ItemViewHolder> {

    List<OrderCard> orderCards;
    static Context context;

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        ImageView itemImage;
        TextView itemName;
        TextView itemCount;
        TextView itemId;
        Button cookingButton;
        Button doneButton;
        TextView itemState;
        public OrderCard currentItem;

        public ItemViewHolder(final View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            itemImage = (ImageView) itemView.findViewById(R.id.cardview_item_image);
            itemName = (TextView) itemView.findViewById(R.id.cardview_item_name);
            itemCount = (TextView) itemView.findViewById(R.id.card_view_item_count);
            itemState = (TextView) itemView.findViewById(R.id.card_view_item_state);
            itemId = (TextView) itemView.findViewById(R.id.cardview_item_id);
            cookingButton = (Button) itemView.findViewById(R.id.card_view_cooking_button);
            Log.i("xx2", Boolean.toString(cookingButton.isEnabled()));
            doneButton = (Button) itemView.findViewById(R.id.card_view_done_button);
            cookingButton.setOnClickListener(this);
            doneButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.card_view_cooking_button) {
                v.setEnabled(false);
                Log.i("xx",Boolean.toString(v.isEnabled()));
                updateItemCard(getAdapterPosition(), 3);
                ((View)v.getParent()).findViewById(R.id.card_view_done_button).setEnabled(true);

            }
            else if (v.getId() == R.id.card_view_done_button)
                deleteItemCard(getAdapterPosition(),3);
        }
    }

    public void deleteItemCard (int position, int state){

        //Log.i("adapter",Integer.toString(position));
        //Log.i("adapter",Integer.toString(orderCards.size()));
        //Log.i("adapter",Long.toString(orderCards.get(position)));
        int orderIndex = Auxiliary.getIncludingOrderIndex(orderCards.get(position).getId());
        Auxiliary.orderList.get(orderIndex).getOrderCardList().remove(orderCards.get(position));
        orderCards.remove(position);
        if(Auxiliary.orderList.get(orderIndex).getOrderCardList().isEmpty()){
            NotifyWaiterService notifyWaiterService = new NotifyWaiterService(Auxiliary.orderList.get(orderIndex).getId());
            notifyWaiterService.execute();
            Toast.makeText(context,"order "+Auxiliary.orderList.get(orderIndex).getId()+" has finished",Toast.LENGTH_SHORT).show();
            Auxiliary.orderList.remove(orderIndex);

        }


            // send notification to the waiter with the service table number
        notifyItemRemoved(position);
    }

    public void updateItemCard (int position,int state){
        orderCards.get(position).setState(state);
        int orderIndex = Auxiliary.getIncludingOrderIndex(orderCards.get(position).getId());
        int orderCardsIndex = Auxiliary.getIncludingOrderCardIndex(orderIndex,orderCards.get(position).getId());
        Auxiliary.orderList.get(orderIndex).getOrderCardList().get(orderCardsIndex).setState(state);
        //notifyItemChanged(position);
        notifyDataSetChanged();
    }


    public ItemCardRecyclerViewAdapter(Context context) {
        this.orderCards = Auxiliary.orderCardList;
        this.context=context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout,parent,false);
        ItemViewHolder itemViewHolder= new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {

        final OrderCard currentItem= orderCards.get(i);
        itemViewHolder.currentItem=currentItem;
        itemViewHolder.itemId.setText(Long.toString(currentItem.getItem().getId()));
        itemViewHolder.itemName.setText(currentItem.getItem().getName());
        itemViewHolder.itemCount.setText("Quantity: "+ currentItem.getCount());
        if(currentItem.getState()==2)
            itemViewHolder.itemState.setText("Not Cooked");
        else if(currentItem.getState()==3)
            itemViewHolder.itemState.setText("Cooking");
        else if(currentItem.getState()==4)
            itemViewHolder.itemState.setText("Done");
        Picasso.with(context).load(currentItem.getItem().getPicture())
                .error(R.drawable.no_image)
                .placeholder(R.drawable.loading_image)
                .into(itemViewHolder.itemImage);
    }


    @Override
    public int getItemCount() {
        return orderCards.size();
    }

}
