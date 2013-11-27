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
	
	//设置监听器
	private void setListener(){
		comp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//ComponentName 还有另外三种启动方式，请参看API文档，
				//Intemt(Content c,Class<?> cls)构造函数就是对该方式的一种简化
				ComponentName component = new ComponentName(IntentActivity.this, IntentResultActivity.class);
				
				Intent intent = new Intent();
				//此处设置Component属性，有了Component属性后，基本上不需要在配置Filter属性了
				intent.setComponent(component);
				intent.putExtra("result", "我是用Component方式启动的");
				IntentActivity.this.startActivity(intent);
			}
		});
		action.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent2 = new Intent();
				//此处设置Action属性，action属性其实就是一个普通的字符串，用来说明一个抽象的意图，
				//具体由谁来执行这个意图，则需要看那个组件的intent-filter中配置了这个action
				//有点类似于Struts2中 结果级中只返回一个字符串，到底跳转到那个页面，需要看配置文件中的配置
				//使用这中方式，需要在manifest中注册的组件中配置intent-filter
				//除了配置action 还需要配置category
				intent2.setAction("com.flan.study.intent.ACTION_START");
				intent2.putExtra("result", "我是用Action方式发送过来的");
				IntentActivity.this.startActivity(intent2);
			}
		});
	}
}











