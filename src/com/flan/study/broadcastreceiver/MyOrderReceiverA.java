package com.flan.study.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 
 * 有序广播接收类，用于接收广播，并进行响应操作；
 * 执行时间不能超过10秒，不然会出现ANP提示；
 * 该类在独立的进程中，当有符合的广播发出时，系统自动创建该类，执行完后立即销毁
 * @author lynn
 */
public class MyOrderReceiverA extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("=============== MyOrderReceiverA ================");
		Toast.makeText(context, "onReceiveA 收到："+intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
		
		//创建用于向下一个receiver传递的数据
		Bundle bundle = new Bundle();
		bundle.putString("orderA", "OrderReceiverA中的信息");
		//将数据放入结果中，发送到下一个receiver
		this.setResultExtras(bundle);
		//取消 Broadcast广播的继续传播，此处不阻值，在下一个receiver中阻止,
		//此处阻止了的话receiverB将不会触发，也不会收到消息
		//this.abortBroadcast();
		
	}

}
