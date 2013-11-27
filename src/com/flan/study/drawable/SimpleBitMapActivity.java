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
			//��ȡassets�������ļ�
			images = assets.list("");
		} catch (IOException e) {
			Log.e(TAG, e.toString());
		}
		
		next = (Button) this.findViewById(R.id.simple_next_bt);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//����Խ��
				if(currentImg>images.length){
					currentImg = 0;
				}
				//�ҵ���һ��ͼƬ
				while(!images[currentImg].endsWith(".png") &&
						!images[currentImg].endsWith(".jpg") &&
						!images[currentImg].endsWith(".gif"));{
					
					currentImg++;
					if(currentImg>images.length){
						currentImg = 0;
					}
					InputStream assetsFile = null;
					try {
						//��ָ����Դ��Ӧ��������
						assetsFile = assets.open(images[currentImg]);
					} catch (IOException e) {
						Log.e(TAG, e.toString());
					}
					BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
					
					//���ͼƬ��δ���գ���ǿ�ƻ��ո�ͼƬ
					if(bitmapDrawable != null && bitmapDrawable.getBitmap().isRecycled()){
						bitmapDrawable.getBitmap().recycle();
					}
					//�ı�ImageView����ʾͼƬ
					imageView.setImageBitmap(BitmapFactory.decodeStream(assetsFile));
				}
				
			}
		});
	}
	
}


















