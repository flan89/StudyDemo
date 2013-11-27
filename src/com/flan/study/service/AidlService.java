package com.flan.study.service;

import java.util.Timer;
import java.util.TimerTask;

import com.flan.study.service.ICat.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * 用于不同进程间的 远程绑定调用 ，客户端和service不在一个进程（是进程不是线程）中
 * @author lynn
 */
public class AidlService extends Service {
	
	private CatBinder binder;
	private Timer timer = new Timer();
	private String color;
	private double weight;
	private String[] colors = new String[]{"红色","黄色","黑色"};
	private double[] weights = new double[]{ 2.3 , 3.1 , 1.58};
	
	/**
	 * 在绑定本地service的情况下，该binder会直接传给客户端ServiceConnection对象的
	 * onServiceConnected 方法的第二个参数；
	 * 
	 * 在绑定远程service的情况下，传过去的是该binder对象的代理；
	 */
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("=========== onCreate创建后才调用 onBind ===========");
		return binder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("===========  最先调用 onCreate ===========");
		binder = new CatBinder();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				int rand = (int) (Math.random()*3);
				System.out.println("===========  rand: "+rand+" ===========");
				color = colors[rand];
				weight = weights[rand];
			}
		}, 0, 800);
		
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("=========== 解绑后先调用 onUnbind ===========");
		return true;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		timer.cancel();
		System.out.println("=========== 在调用  onDestroy ===========");
	}
	
	/**
	 * 继承Stub类，也就实现了ICat.aidl中的接口，
	 * 而在Stub中实现了IBinder接口
	 * @author lynn
	 */
	public class CatBinder extends Stub{

		@Override
		public String getColor() throws RemoteException {
			
			return color;
		}

		@Override
		public double getWeight() throws RemoteException {
			
			return weight;
		}
		
	}

}














