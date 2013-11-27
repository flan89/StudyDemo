package com.flan.study.drawable;

import com.flan.study.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DrawableActivity extends Activity {
	
	View simpleBt,drawBt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_drawable);
		
		simpleBt = this.findViewById(R.id.drawable_simple);
		drawBt = this.findViewById(R.id.drawable_draw);
		
		simpleBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DrawableActivity.this, SimpleBitMapActivity.class);
				DrawableActivity.this.startActivity(intent);
			}
		});
		
		drawBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DrawableActivity.this, MyViewActivity.class);
				DrawableActivity.this.startActivity(intent);
			}
		});
	}
	
}
