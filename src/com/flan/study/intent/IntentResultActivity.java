package com.flan.study.intent;

import com.flan.study.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentResultActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_intent_result);
		TextView tv = (TextView) this.findViewById(R.id.intent_result);
		
		Intent intent = this.getIntent();
		String result = intent.getStringExtra("result");
		
		tv.setText(result);
	}
	
}
