package com.flan.study.drawable;

import android.app.Activity;
import android.os.Bundle;

public class MyViewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		MyView view = new MyView(this);
		this.setContentView(view);
	}
	
}
