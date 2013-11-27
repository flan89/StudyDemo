package com.flan.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * 用于本地进程中的绑定调用， service与客户端在同一个进程中
 * @author lynn
 */
public class BindService extends Service {
	
	private int count;
	private boolean quit;
	private MyBinder binder = new MyBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("=========== onCreate创建后才调用 onBind ===========");
		return binder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("===========  最先调用 onCreate ===========");
		
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
	
	//service被断开连接时调用
	@Override
	public boolean onUnbind(Intent intent) {
		
		System.out.println("=========== 解绑后先调用 onUnbind ===========");
		
		return true;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		this.quit = true;
		
		System.out.println("=========== 在调用  onDestroy ===========");
	}
	
	
	/**
	 * 通过继承Binder类 来实现IBinder类，用于在进程间传递数据
	 * @author lynn
	 */
	public class MyBinder extends Binder{
		
		//自己定义的方法，用来在启动绑定服务的 activity中调用
		public int getCount(){
			return count;
		}
	}

}











