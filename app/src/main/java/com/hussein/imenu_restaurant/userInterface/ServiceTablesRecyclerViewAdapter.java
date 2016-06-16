package com.hussein.imenu_restaurant.userInterface;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.ServiceTable;
import com.hussein.imenu_restaurant.service.AddServiceTable;
import com.hussein.imenu_restaurant.service.GetOrderService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hussein Abu Maash on 6/11/2016.
 */

public class ServiceTablesRecyclerViewAdapter extends RecyclerView.Adapter<ServiceTablesRecyclerViewAdapter.ItemViewHolder> {

    List<ServiceTable> serviceTables;
    Context context;

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        CardView cardView;
        TextView serviceTableNumber;
        TextView serviceTableState;

        public ServiceTable currentServiceTable;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.service_table_card_view);
            serviceTableNumber = (TextView) itemView.findViewById(R.id.service_table_number);
            serviceTableState = (TextView) itemView.findViewById(R.id.service_table_state);
            cardView.setClickable(false);
            cardView.setLongClickable(true);
            cardView.setOnLongClickListener(this);
            cardView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
        //    GetOrderService getOrderService = new GetOrderService(context,)
            Toast.makeText(context,"number: "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View v) {
            AlertDialog.Builder serviceTableStateBuilder = new AlertDialog.Builder(context);
            serviceTableStateBuilder.setMessage("Change the state of the table: ");
            serviceTableStateBuilder.setCancelable(true);
            serviceTableStateBuilder.setPositiveButton(R.string.unlock, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    serviceTables.get(getAdapterPosition()).setState(1);
                    AddServiceTable updateServiceTable = new AddServiceTable(context,serviceTables.get(getAdapterPosition()));
                    updateServiceTable.execute();
                    notifyItemChanged(getAdapterPosition());
                }
            });
            serviceTableStateBuilder.setNegativeButton(R.string.lock, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    serviceTables.get(getAdapterPosition()).setState(2);
                    AddServiceTable updateServiceTable = new AddServiceTable(context,serviceTables.get(getAdapterPosition()));
                    updateServiceTable.execute();
                    notifyItemChanged(getAdapterPosition());
                }
            });
            AlertDialog serviceTableStateDialog = serviceTableStateBuilder.create();
            serviceTableStateDialog.show();
            return true;
        }
    }



    public ServiceTablesRecyclerViewAdapter(List<ServiceTable> serviceTables, Context context) {
        this.serviceTables = serviceTables;
        this.context=context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.service_table_layout,parent,false);
        ItemViewHolder itemViewHolder= new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {

        //set color here
        // 2: locked FFF9A8AA
        // 3: connected d1f9cb
        // 1: unlocked FFFFFBC7
        // 4: unconnected FFD6D6D6
        HashMap<Integer,String> stateString = new HashMap<>();
        stateString.put(1,"Unlocked");
        stateString.put(2,"Locked");
        stateString.put(3,"Connected");
        stateString.put(4,"Not connected");
        ServiceTable currentItem= serviceTables.get(i);
        itemViewHolder.serviceTableNumber.setText(Integer.toString(i + 1));
        itemViewHolder.serviceTableState.setText(stateString.get(currentItem.getState()));
        switch (currentItem.getState()){
            case 1:
                itemViewHolder.cardView.setCardBackgroundColor(0xFFFFFBC7);
                itemViewHolder.cardView.setClickable(false);
                break;
            case 2:
                itemViewHolder.cardView.setCardBackgroundColor(0xFFF9A8AA);
                itemViewHolder.cardView.setClickable(false);
                break;
            case 3:
                itemViewHolder.cardView.setCardBackgroundColor(0xFF8BE987);
                itemViewHolder.cardView.setClickable(true);
                break;
            case 4:
                itemViewHolder.cardView.setCardBackgroundColor(0xFFD6D6D6);
                itemViewHolder.cardView.setClickable(false);
                break;
            default:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return serviceTables.size();
    }

}
