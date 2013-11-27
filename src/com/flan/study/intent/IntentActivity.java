package com.flan.study.intent;

import com.flan.study.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class IntentActivity extends Activity {
	
	View comp,action;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_intent);
		
		comp = this.findViewById(R.id.intent_comp);
		action = this.findViewById(R.id.intent_action);
		
		this.setListener();
	}
	
	//���ü�����
	private void setListener(){
		comp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//ComponentName ������������������ʽ����ο�API�ĵ���
				//Intemt(Content c,Class<?> cls)���캯�����ǶԸ÷�ʽ��һ�ּ�
				ComponentName component = new ComponentName(IntentActivity.this, IntentResultActivity.class);
				
				Intent intent = new Intent();
				//�˴�����Component���ԣ�����Component���Ժ󣬻����ϲ���Ҫ������Filter������
				intent.setComponent(component);
				intent.putExtra("result", "������Component��ʽ������");
				IntentActivity.this.startActivity(intent);
			}
		});
		action.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent2 = new Intent();
				//�˴�����Action���ԣ�action������ʵ����һ����ͨ���ַ���������˵��һ���������ͼ��
				//������˭��ִ�������ͼ������Ҫ���Ǹ������intent-filter�����������action
				//�е�������Struts2�� �������ֻ����һ���ַ�����������ת���Ǹ�ҳ�棬��Ҫ�������ļ��е�����
				//ʹ�����з�ʽ����Ҫ��manifest��ע������������intent-filter
				//��������action ����Ҫ����category
				intent2.setAction("com.flan.study.intent.ACTION_START");
				intent2.putExtra("result", "������Action��ʽ���͹�����");
				IntentActivity.this.startActivity(intent2);
			}
		});
	}
}











