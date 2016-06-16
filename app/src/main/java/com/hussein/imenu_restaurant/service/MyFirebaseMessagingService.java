package com.hussein.imenu_restaurant.service;

/**
 * Created by sabaa on 6/13/16.
 */

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.activity.ChefActivity;
import com.hussein.imenu_restaurant.activity.MainActivity;
import com.hussein.imenu_restaurant.activity.NotificationsDialogFragment;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Displaying data in log
        //It is optional
        Log.d(TAG, "*****************You have a Message !!******************");
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getData());
        Log.d(TAG, "Notification Message Body: val : " + remoteMessage.getData().get("val"));
        Log.d(TAG, "Notification Message Body: massage : " + remoteMessage.getData().get("message"));

        //Calling method to generate notification
        //sendNotification(remoteMessage.getData().get("message"));
        sendNotification(remoteMessage.getData().get("val"));
    }

    //This method is only generating push notification
    //It is same as we did in earlier posts
    private void sendNotification(String messageBody) {
//        Log.i("el batee5a", messageBody.substring(0, 12));
        if(messageBody.length()>12 && messageBody.substring(0,12).equals("chef_notify:")) {
            GetOrderService getOrderService = new GetOrderService(Auxiliary.getRunningChefActivity(), messageBody.substring(12,13));
            getOrderService.execute();
        }
        else if (messageBody.equals("tc ")) {
            GetServiceTablesService getServiceTablesService = new GetServiceTablesService(Auxiliary.getRunningWaiterActivity(),
                    "KFC",Auxiliary.getRunningWaiterActivity().recyclerView,
                    Auxiliary.getRunningWaiterActivity().progressBar);
            getServiceTablesService.execute();
        }
        else{
            Auxiliary.notificationList.add(messageBody);
            Auxiliary.runningWaiterActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Auxiliary.runningWaiterActivity.fab.setBackgroundTintList(ColorStateList.valueOf(0xffff0000));
                }
            });


            Auxiliary.runningNotificationsDialogFragment.notificationsRecyclerViewAdapter.notifyDataSetChanged();

        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.login_logo)
                .setContentTitle("Lambada Notification :D")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }
}