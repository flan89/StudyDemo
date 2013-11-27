package com.flan.study.service;

import java.util.Timer;
import java.util.TimerTask;

import com.flan.study.service.ICat.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * ���ڲ�ͬ���̼�� Զ�̰󶨵��� ���ͻ��˺�service����һ�����̣��ǽ��̲����̣߳���
 * @author lynn
 */
public class AidlService extends Service {
	
	private CatBinder binder;
	private Timer timer = new Timer();
	private String color;
	private double weight;
	private String[] colors = new String[]{"��ɫ","��ɫ","��ɫ"};
	private double[] weights = new double[]{ 2.3 , 3.1 , 1.58};
	
	/**
	 * �ڰ󶨱���service������£���binder��ֱ�Ӵ����ͻ���ServiceConnection�����
	 * onServiceConnected �����ĵڶ���������
	 * 
	 * �ڰ�Զ��service������£�����ȥ���Ǹ�binder����Ĵ���
	 */
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("=========== onCreate������ŵ��� onBind ===========");
		return binder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("===========  ���ȵ��� onCreate ===========");
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
		System.out.println("=========== �����ȵ��� onUnbind ===========");
		return true;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		timer.cancel();
		System.out.println("=========== �ڵ���  onDestroy ===========");
	}
	
	/**
	 * �̳�Stub�࣬Ҳ��ʵ����ICat.aidl�еĽӿڣ�
	 * ����Stub��ʵ����IBinder�ӿ�
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














