package com.CompassDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Compass extends View
{
	private final int compassWidth = 287;
	private final int compassHeight = 287;

	private Bitmap compassBMP;
	private Bitmap needleBMP;
	private Float needleAngle;

	//default constructor
	public Compass(Context context){
		super(context);
		Init();
	}

	public Compass(Context context, AttributeSet attrs) {
		super(context, attrs);
		Init();
	}

	public Compass(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		Init();
	}

	private void Init()
	{			
		needleAngle = 0.0f;
		compassBMP = BitmapFactory.decodeResource(getResources(), R.drawable.compass);	
		needleBMP = BitmapFactory.decodeResource(getResources(), R.drawable.compass_needle);
	}

	@Override
	protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec)
	{
		setMeasuredDimension(compassWidth, compassHeight);
	}

	@Override
	protected void onDraw (Canvas canvas)
	{
		canvas.drawBitmap(compassBMP, 0, 0, null);
		canvas.save(Canvas.MATRIX_SAVE_FLAG);
		canvas.rotate(needleAngle,143.5f,143.5f);
		canvas.drawBitmap(needleBMP, 133.5f, 18.5f, null);
		canvas.restore();
	}
	
	public void SetAngle(float angle)
	{
		needleAngle = angle;
		invalidate();
	}
}