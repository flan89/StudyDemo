package com.flan.study.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 
 * 广播接收类，用于接收广播，并进行响应操作；
 * 执行时间不能超过10秒，不然会出现ANP提示；
 * 该类在独立的进程中，当有符合的广播发出时，系统自动创建该类，执行完后立即销毁
 * @author lynn
 */
public class MyNormalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "onReceive 收到："+intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
	}

}
