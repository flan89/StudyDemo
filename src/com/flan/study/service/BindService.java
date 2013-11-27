package com.flan.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * ���ڱ��ؽ����еİ󶨵��ã� service��ͻ�����ͬһ��������
 * @author lynn
 */
public class BindService extends Service {
	
	private int count;
	private boolean quit;
	private MyBinder binder = new MyBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("=========== onCreate������ŵ��� onBind ===========");
		return binder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("===========  ���ȵ��� onCreate ===========");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!quit){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
				}
			}
		}).start();
	}
	
	//service���Ͽ�����ʱ����
	@Override
	public boolean onUnbind(Intent intent) {
		
		System.out.println("=========== �����ȵ��� onUnbind ===========");
		
		return true;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		this.quit = true;
		
		System.out.println("=========== �ڵ���  onDestroy ===========");
	}
	
	
	/**
	 * ͨ���̳�Binder�� ��ʵ��IBinder�࣬�����ڽ��̼䴫������
	 * @author lynn
	 */
	public class MyBinder extends Binder{
		
		//�Լ�����ķ����������������󶨷���� activity�е���
		public int getCount(){
			return count;
		}
	}

}











