package com.example.task1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanelView extends SurfaceView implements SurfaceHolder.Callback {
	
	private MainThread thread;
	// adding MainThread as a private thread to the view
	private static final String TAG = MainGamePanelView.class.getSimpleName();
	
	public MainGamePanelView(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		thread = new MainThread(getHolder(), this);	// adding MainThread as a private thread to the view
		
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while(retry){
			try {
				thread.join();
				retry=false;
			} catch (InterruptedException e){
				//TODO: try again
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN){
			if (event.getY() > getHeight() - 50){ // test, exits app if lower 50 pixel part of the screen
				thread.setRunning(false);
				((Activity)getContext()).finish();
			}
			else{
				Log.d(TAG, "Coords: x=" + event.getX()+ ",y= " + event.getY());
			}
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDraw(Canvas canvas) {
	}
}
