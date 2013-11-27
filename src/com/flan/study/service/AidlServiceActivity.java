package com.flan.study.service;

import com.flan.study.R;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * ����Զ�� ����� ���õ�Activity
 * ���Activity��������Ӧ����,���������service����Զ�̵���
 * ���߽��������ļ��н�service������һ��������,
 * ��ʱֻ��Ϊ�˷��㣬����ͬһ��Ӧ���У�
 * ��Activity��������Ӧ����ʱ��Ҫ����ICat.aidl�ӿ�һ���ƹ�ȥ
 * @author lynn
 */
public class AidlServiceActivity extends Activity {
	
	private ICat catService;	//ע������ʹ�õĽӿ�
	private View bindBt,stateBt,uBindBt;
	private TextView text;
	
	//����һ�����Ӷ���
	private ServiceConnection conn = new ServiceConnection() {
		
		//�����̨�������ӶϿ�ʱ�� �ص�
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("============== Disconnected ==============");
			catService = null;
		}
		
		//�����̨����������ʱ�� �ص�
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("============== Connected ==============");
			//��ȡ���ص� ���� ���ݴ���� Binder����Ĵ���
			catService = (ICat) service;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_service_aidl);
		
		bindBt = this.findViewById(R.id.service_bind);
		stateBt = this.findViewById(R.id.service_state);
		uBindBt = this.findViewById(R.id.service_ubind);
		
		text = (TextView) this.findViewById(R.id.service_text);
		text.setText("���");
		setListener();
	}
	
	private void setListener(){
		
		final Intent intent2 = new Intent(AidlServiceActivity.this, AidlService.class);
		
		bindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//�󶨷���
				AidlServiceActivity.this.bindService(intent2, conn, Service.BIND_AUTO_CREATE);
			}
		});
		stateBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//��ȡ��̨���������
				try {
					text.setText(" ɫ��:"+catService.getColor() +" �ߴ� :"+catService.getWeight());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		uBindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//������ �� ���ȵ��÷����е�onUnbind��Ȼ�����Զ�����onDestroy
				AidlServiceActivity.this.unbindService(conn);
			}
		});
	}
}










