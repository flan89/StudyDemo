package com.flan.study.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 
 * �㲥�����࣬���ڽ��չ㲥����������Ӧ������
 * ִ��ʱ�䲻�ܳ���10�룬��Ȼ�����ANP��ʾ��
 * �����ڶ����Ľ����У����з��ϵĹ㲥����ʱ��ϵͳ�Զ��������ִ࣬�������������
 * @author lynn
 */
public class MyNormalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "onReceive �յ���"+intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
	}

}
