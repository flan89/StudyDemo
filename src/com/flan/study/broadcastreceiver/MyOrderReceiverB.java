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
public class MyOrderReceiverB extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("=============== MyOrderReceiverB ================");
		//��ȡ��һ��receiver�еĴ���������
		Bundle bundle = this.getResultExtras(true);
		
		Toast.makeText(context, "onReceiveB �յ���"+bundle.getString("orderA"), Toast.LENGTH_SHORT).show();
		
		//������������һ��receiver���ݵ�����
		bundle.putString("orderB", "OrderReceiverB�е���Ϣ");
		//�����ݷ������У����͵���һ��receiver
		this.setResultExtras(bundle);
		//ȡ�� Broadcast�㲥�ļ�������,��һ�����ȼ��͵�receiver�����ᴥ����Ҳ���ղ���orderB�е�����
		this.abortBroadcast();
		
	}

}
