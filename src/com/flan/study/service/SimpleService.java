package com.flan.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class SimpleService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		System.out.println("================= onCreate ================");
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int i = 0;
		while (i<7) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("=============== onStartCommand : "+(i++)+"================");
		}
		
		return START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("================= onDestroy ================");
	}

}
