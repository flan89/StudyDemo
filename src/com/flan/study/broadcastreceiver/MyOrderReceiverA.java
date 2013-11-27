package com.flan.study.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 
 * ����㲥�����࣬���ڽ��չ㲥����������Ӧ������
 * ִ��ʱ�䲻�ܳ���10�룬��Ȼ�����ANP��ʾ��
 * �����ڶ����Ľ����У����з��ϵĹ㲥����ʱ��ϵͳ�Զ��������ִ࣬�������������
 * @author lynn
 */
public class MyOrderReceiverA extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("=============== MyOrderReceiverA ================");
		Toast.makeText(context, "onReceiveA �յ���"+intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
		
		//������������һ��receiver���ݵ�����
		Bundle bundle = new Bundle();
		bundle.putString("orderA", "OrderReceiverA�е���Ϣ");
		//�����ݷ������У����͵���һ��receiver
		this.setResultExtras(bundle);
		//ȡ�� Broadcast�㲥�ļ����������˴�����ֵ������һ��receiver����ֹ,
		//�˴���ֹ�˵Ļ�receiverB�����ᴥ����Ҳ�����յ���Ϣ
		//this.abortBroadcast();
		
	}

}
