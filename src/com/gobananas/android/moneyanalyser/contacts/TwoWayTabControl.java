package com.gobananas.android.moneyanalyser.contacts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TwoWayTabControl extends View implements OnTouchListener{
	private boolean leftTabSelected = true;
	Paint paint;
	private String leftText ="";
	private String rightText = "";
	
	public TwoWayTabControl(Context context) {
		super(context);
		paint = new Paint();
		paint.setTextSize(24);
		paint.setAntiAlias(true);
		setOnTouchListener(this);
		// TODO Auto-generated constructor stub
	}
	public TwoWayTabControl(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		paint.setTextSize(24);
		paint.setAntiAlias(true);
		setOnTouchListener(this);
		// TODO Auto-generated constructor stub
	}
	public TwoWayTabControl(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		paint = new Paint();
		paint.setTextSize(24);
		paint.setAntiAlias(true);
		setOnTouchListener(this);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(Color.WHITE);
		if(leftTabSelected){
			canvas.drawText(leftText, 0, 30, paint);
		}else{
			canvas.drawText(rightText, getWidth()-100, 30, paint);
		}
		paint.setColor(Color.GRAY);
		if(leftTabSelected){
			canvas.drawText(rightText, getWidth()-100, 30, paint);
		}else{
			canvas.drawText(leftText, 0, 30, paint);
		}
	}
	public boolean isLeftTabSelected() {
		return leftTabSelected;
	}
	public void setLeftTabSelected(boolean leftTabSelected) {
		this.leftTabSelected = leftTabSelected;
		invalidate();
	}
	public String getLeftText() {
		return leftText;
	}
	public void setLeftText(String leftText) {
		this.leftText = leftText;
	}
	public String getRightText() {
		return rightText;
	}
	public void setRightText(String rightText) {
		this.rightText = rightText;
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getX()<getWidth()/2){
			setLeftTabSelected(true);
		}else{
			setLeftTabSelected(false);
		}
		return true;
	}

}
