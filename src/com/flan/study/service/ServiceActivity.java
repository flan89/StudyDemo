package com.flan.study.service;

import com.flan.study.R;
import com.flan.study.service.BindService.MyBinder;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ServiceActivity extends Activity {
	
	private View startBt,endBt,bindBt,stateBt,uBindBt;
	
	//����󶨷��񷵻ص�Binder����
	private BindService.MyBinder binder;
	//����һ�����Ӷ���
	private ServiceConnection conn = new ServiceConnection() {
		
		//�����̨�������ӶϿ�ʱ�� �ص�
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("============== Disconnected ==============");
		}
		
		//�����̨����������ʱ�� �ص�
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("============== Connected ==============");
			//��ȡ���ص� ���� ���ݴ���� Binder����
			binder = (MyBinder) service;
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_service);
		
		startBt = this.findViewById(R.id.service_start);
		endBt = this.findViewById(R.id.service_end);
		bindBt = this.findViewById(R.id.service_bind);
		stateBt = this.findViewById(R.id.service_state);
		uBindBt = this.findViewById(R.id.service_ubind);
		
		this.setListener();
	}
	
	private void setListener(){
		
		final Intent intent = new Intent("com.flan.study.SIMPLE_SERVICE");
		final Intent intent2 = new Intent(ServiceActivity.this, BindService.class);
		
		startBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				ServiceActivity.this.startService(intent);
			}
		});
		endBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ServiceActivity.this.stopService(intent);
			}
		});
		bindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//�󶨷���
				ServiceActivity.this.bindService(intent2, conn, Service.BIND_AUTO_CREATE);
			}
		});
		stateBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//��ȡ��̨���������
				int count = binder.getCount();
				Toast.makeText(ServiceActivity.this, "���ص�ֵ��"+count, Toast.LENGTH_SHORT).show();
			}
		});
		uBindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//������ �� ���ȵ��÷����е�onUnbind��Ȼ�����Զ�����onDestroy
				ServiceActivity.this.unbindService(conn);
			}
		});
	}
}












