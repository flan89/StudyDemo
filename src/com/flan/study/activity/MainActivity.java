package com.flan.study.activity;

import java.util.ArrayList;
import java.util.List;

import com.flan.study.R;
import com.flan.study.broadcastreceiver.BroadcastActivity;
import com.flan.study.intent.IntentActivity;
import com.flan.study.drawable.DrawableActivity;
import com.flan.study.service.AidlServiceActivity;
import com.flan.study.service.ServiceActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ������
 * @author Lynn
 */
public class MainActivity extends Activity {
	
	ListView listView;
	List<String> itemData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		
		itemData = this.getData();
		listView = (ListView) this.findViewById(R.id.main_listview);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_main, itemData);
		listView.setAdapter(adapter);
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View item, int position,long arg3) {
				
				TextView tv = (TextView) item;
				Intent intent = null;
				
				switch (position+1) {
				case 1:
					Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
					break;
				case 4:
					intent = new Intent(MainActivity.this, PinYinActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 5:
					intent = new Intent(MainActivity.this, ServiceActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 6:
					intent = new Intent(MainActivity.this, AidlServiceActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 7:
					intent = new Intent(MainActivity.this, BroadcastActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 8:
					intent = new Intent(MainActivity.this, IntentActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 9:
					intent = new Intent(MainActivity.this, BroadcastActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 10:
					intent = new Intent(MainActivity.this, BroadcastActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 11:
					intent = new Intent(MainActivity.this, DrawableActivity.class);
					MainActivity.this.startActivity(intent);
					break;
				case 12:
					intent = new Intent(MainActivity.this, BroadcastActivity.class);
					MainActivity.this.startActivity(intent);
					break;

				default:
					break;
				}
			}
		});
		
	}
	
	//������ʾ����
	private List<String> getData(){
		
		List<String> list = new ArrayList<String>();
		list.add("1.Handlerʹ��");
		list.add("2.Pull����ʾ��");
		list.add("3.Activity��������");
		list.add("4.ȡ���ֵ�����ĸ");
		list.add("5.����Service");
		list.add("6.Զ��AidlService");
		list.add("7.BroadcastReceiver");
		list.add("8.Intent��ͬ��ʽ�������");
		list.add("9.=======");
		list.add("10.=======");
		list.add("11.ͼ����ͼ����");
		list.add("12.=======");
		
		return list;
	}
	 
	
	
	
	
}












