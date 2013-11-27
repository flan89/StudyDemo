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
		
		//��������Ϊ��ɫ
		canvas.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		//ȥ���
		paint.setAntiAlias(true);
		paint.setColor(Color.BLUE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		
		//����Բ��
		canvas.drawCircle(40, 40, 30, paint);
		//����������
		canvas.drawRect(10, 80, 70,140, paint);
		//���ƾ���
		canvas.drawRect(10, 150, 70,190, paint);
		//����Բ�Ǿ���
		RectF re1 = new RectF(10, 200, 70, 230);
		canvas.drawRoundRect(re1, 15, 15, paint);
		//������Բ
		RectF re11 = new RectF(10, 240, 70, 270);
		canvas.drawOval(re11, paint);
		
		//����һ��Path���󡣷�ճ�һ��������
		Path path1 = new Path();
		path1.moveTo(10, 340);
		path1.lineTo(70, 340);
		path1.lineTo(40, 290);
		path1.close();
		//����Path���л���������
		canvas.drawPath(path1, paint);
		
		//����һ��Path���󡣷�ճ�һ�������
		Path path2 = new Path();
		path2.moveTo(26, 360);
		path2.lineTo(54, 360);
		path2.lineTo(70, 392);
		path2.lineTo(40, 420);
		path2.lineTo(10, 392);
		path2.close();
		//����Path���л��������
		canvas.drawPath(path2, paint);
		
		//���������� ����
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.RED);
		
		//����Բ��
		canvas.drawCircle(120, 40, 30, paint);
		//���ƾ���
		canvas.drawRect(90, 150, 150,190, paint);
		//����������
		canvas.drawRect(90, 80, 150,140, paint);
		//����Բ�Ǿ���
		RectF re2 = new RectF(90, 200, 150, 230);
		canvas.drawRoundRect(re2, 15, 15, paint);
		//������Բ
		RectF re22 = new RectF(90, 240, 150, 270);
		canvas.drawOval(re22, paint);
		
		//����һ��Path���󡣷�ճ�һ��������
		Path path3 = new Path();
		path3.moveTo(90, 340);
		path3.lineTo(150, 340);
		path3.lineTo(120, 290);
		path3.close();
		//����Path���л���������
		canvas.drawPath(path3, paint);
		
		//����һ��Path���󡣷�ճ�һ�������
		Path path4 = new Path();
		path4.moveTo(106, 360);
		path4.lineTo(134, 360);
		path4.lineTo(150, 392);
		path4.lineTo(120, 420);
		path4.lineTo(90, 392);
		path4.close();
		//����Path���л��������
		canvas.drawPath(path4, paint);
		
		
		//�����ַ���С�����
		paint.setTextSize(24);
		paint.setShader(null);
		//����7���ַ���
		canvas.drawText("Բ��", 240, 50, paint);
		canvas.drawText("������", 240, 120, paint);
		canvas.drawText("������", 240, 175, paint);
		canvas.drawText("Բ�Ǿ���", 240, 220, paint);
		canvas.drawText("��Բ��", 240, 260, paint);
		canvas.drawText("������", 240, 325, paint);
		canvas.drawText("�����", 240, 390, paint);
		
	}
	
}

































