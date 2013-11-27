package com.flan.study.broadcastreceiver;

import com.flan.study.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 用于发送广播
 * @author lynn
 */
public class BroadcastActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_broadcast);
		
		View normal = this.findViewById(R.id.broadcast_normal);
		normal.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent("com.flan.study.broadcastreceiver.NORMAL_RECEIVER");
				intent.putExtra("msg", "flan");
				BroadcastActivity.this.sendBroadcast(intent);
			}
		});
		
		View order = this.findViewById(R.id.broadcast_order);
		order.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent("com.flan.study.broadcastreceiver.ORDER_RECEIVER");
				intent.putExtra("msg", "flan");
				//BroadcastActivity.this.sendBroadcast(intent);
				BroadcastActivity.this.sendOrderedBroadcast(intent, null);
			}
		});
	}
	
}


















