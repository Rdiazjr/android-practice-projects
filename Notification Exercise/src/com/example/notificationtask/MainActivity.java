package com.example.notificationtask;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	   Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	      b1 = (Button)findViewById(R.id.button1);
	      
	      b1.setOnClickListener(new View.OnClickListener() {
	          @Override
	          public void onClick(View v) {
	             addNotification();
	          }
	       });   
	}
	
  	public void addNotification() {
  		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
  		.setSmallIcon(R.drawable.ic_launcher)
  		.setContentTitle("Alert! New Youtube video for you!")
  		.setContentText("Click here to see the video we have for you");
  		//Intent notificationIntent = new Intent(this, NotificationView.class);
  		//Intent notificationIntent = new Intent(Intent.ACTION_MAIN);
  		//notificationIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
  		//Uri uri = Uri.parse("smsto:8080");
  		//Intent notificationIntent = new Intent(Intent.ACTION_SENDTO, uri); 
  		//notificationIntent.putExtra("sms_body", "GS50"); 
  		Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://dQw4w9WgXcQ"));
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);
  		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
  		mNotificationManager.notify(0, mBuilder.build());

	}
	
}
