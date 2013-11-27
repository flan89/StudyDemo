package com.flan.study.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {
	
	
	public MyView(Context context) {
		super(context);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//将画布画为白色
		canvas.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		//去锯齿
		paint.setAntiAlias(true);
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		
		//绘制圆形
		canvas.drawCircle(40, 40, 30, paint);
		//绘制正方形
		canvas.drawRect(10, 80, 70,140, paint);
		//绘制矩形
		canvas.drawRect(10, 150, 70,190, paint);
		//绘制圆角矩形
		RectF re1 = new RectF(10, 200, 70, 230);
		canvas.drawRoundRect(re1, 15, 15, paint);
		//绘制椭圆
		RectF re11 = new RectF(10, 240, 70, 270);
		canvas.drawOval(re11, paint);
		
		//定义一个Path对象。封闭成一个三角形
		Path path1 = new Path();
		path1.moveTo(10, 340);
		path1.lineTo(70, 340);
		path1.lineTo(40, 290);
		path1.close();
		//根据Path进行绘制三角形
		canvas.drawPath(path1, paint);
		
		//定义一个Path对象。封闭成一个五角星
		Path path2 = new Path();
		path2.moveTo(26, 360);
		path2.lineTo(54, 360);
		path2.lineTo(70, 392);
		path2.lineTo(40, 420);
		path2.lineTo(10, 392);
		path2.close();
		//根据Path进行绘制五角星
		canvas.drawPath(path2, paint);
		
		//设置填充风格后 绘制
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.RED);
		
		//绘制圆形
		canvas.drawCircle(120, 40, 30, paint);
		//绘制矩形
		canvas.drawRect(90, 150, 150,190, paint);
		//绘制正方形
		canvas.drawRect(90, 80, 150,140, paint);
		//绘制圆角矩形
		RectF re2 = new RectF(90, 200, 150, 230);
		canvas.drawRoundRect(re2, 15, 15, paint);
		//绘制椭圆
		RectF re22 = new RectF(90, 240, 150, 270);
		canvas.drawOval(re22, paint);
		
		//定义一个Path对象。封闭成一个三角形
		Path path3 = new Path();
		path3.moveTo(90, 340);
		path3.lineTo(150, 340);
		path3.lineTo(120, 290);
		path3.close();
		//根据Path进行绘制三角形
		canvas.drawPath(path3, paint);
		
		//定义一个Path对象。封闭成一个五角星
		Path path4 = new Path();
		path4.moveTo(106, 360);
		path4.lineTo(134, 360);
		path4.lineTo(150, 392);
		path4.lineTo(120, 420);
		path4.lineTo(90, 392);
		path4.close();
		//根据Path进行绘制五角星
		canvas.drawPath(path4, paint);
		
		
		//设置字符大小后绘制
		paint.setTextSize(24);
		paint.setShader(null);
		//绘制7个字符串
		canvas.drawText("圆形", 240, 50, paint);
		canvas.drawText("正方形", 240, 120, paint);
		canvas.drawText("长方形", 240, 175, paint);
		canvas.drawText("圆角矩形", 240, 220, paint);
		canvas.drawText("椭圆形", 240, 260, paint);
		canvas.drawText("三角形", 240, 325, paint);
		canvas.drawText("五角形", 240, 390, paint);
		
	}
	
}

































