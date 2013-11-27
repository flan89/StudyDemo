package com.flan.study.drawable;

import java.io.IOException;
import java.io.InputStream;

import com.flan.study.R;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class SimpleBitMapActivity extends Activity {
	
	private static final String TAG = "SimpleBitMapActivity";
	private String[] images = null;
	private AssetManager assets = null;
	private int currentImg = 0;
	private ImageView imageView;
	private Button next = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_drawable_simple);
		
		imageView = (ImageView) this.findViewById(R.id.simple_image);
		
		try {
			assets = this.getAssets();
			//获取assets下所有文件
			images = assets.list("");
		} catch (IOException e) {
			Log.e(TAG, e.toString());
		}
		
		next = (Button) this.findViewById(R.id.simple_next_bt);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//数组越界
				if(currentImg>images.length){
					currentImg = 0;
				}
				//找到下一张图片
				while(!images[currentImg].endsWith(".png") &&
						!images[currentImg].endsWith(".jpg") &&
						!images[currentImg].endsWith(".gif"));{
					
					currentImg++;
					if(currentImg>images.length){
						currentImg = 0;
					}
					InputStream assetsFile = null;
					try {
						//打开指定资源对应的输入流
						assetsFile = assets.open(images[currentImg]);
					} catch (IOException e) {
						Log.e(TAG, e.toString());
					}
					BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
					
					//如果图片还未回收，先强制回收该图片
					if(bitmapDrawable != null && bitmapDrawable.getBitmap().isRecycled()){
						bitmapDrawable.getBitmap().recycle();
					}
					//改变ImageView的显示图片
					imageView.setImageBitmap(BitmapFactory.decodeStream(assetsFile));
				}
				
			}
		});
	}
	
}


















