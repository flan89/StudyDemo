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
 * 进行远程 服务绑定 调用的Activity
 * 这个Activity放在其他应用中,再来绑定这个service才算远程调用
 * 或者将在配置文件中将service放入另一个进程中,
 * 此时只是为了方便，放在同一个应用中；
 * 把Activity放在其他应用中时需要连体ICat.aidl接口一起复制过去
 * @author lynn
 */
public class AidlServiceActivity extends Activity {
	
	private ICat catService;	//注意这里使用的接口
	private View bindBt,stateBt,uBindBt;
	private TextView text;
	
	//创建一个连接对象
	private ServiceConnection conn = new ServiceConnection() {
		
		//当与后台服务连接断开时会 回调
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("============== Disconnected ==============");
			catService = null;
		}
		
		//当与后台服务连接上时会 回调
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("============== Connected ==============");
			//获取返回的 用于 数据传输的 Binder对象的代理
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
		text.setText("结果");
		setListener();
	}
	
	private void setListener(){
		
		final Intent intent2 = new Intent(AidlServiceActivity.this, AidlService.class);
		
		bindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//绑定服务
				AidlServiceActivity.this.bindService(intent2, conn, Service.BIND_AUTO_CREATE);
			}
		});
		stateBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//获取后台计算的数据
				try {
					text.setText(" 色彩:"+catService.getColor() +" 尺寸 :"+catService.getWeight());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		uBindBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//解绑服务 后 会先调用服务中的onUnbind，然后在自动调用onDestroy
				AidlServiceActivity.this.unbindService(conn);
			}
		});
	}
}










