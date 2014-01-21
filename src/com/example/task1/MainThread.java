package com.example.task1;

import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
	private static final String TAG = MainThread.class.getSimpleName(); // for logging purposes
	
	private SurfaceHolder surfaceHolder; 	// bare surfaceholder kan låse panelet mens vi tegner
	private MainGamePanelView gamePanelView;
	private boolean isRunning;

	
	public MainThread(SurfaceHolder surfaceHolder, MainGamePanelView gamePanelView){
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanelView = gamePanelView;
		
	}
	
	public void setRunning(boolean running){
		this.isRunning = isRunning; 
	}
	
	@Override
	public void run(){
		long tickCount = 0L;
		Log.d(TAG,"Start main game loop :3");
		while(isRunning){
			tickCount++;
			//TODO: update gamestate and render
		}
		Log.d(TAG,"GameLoop executed:  "+ tickCount + "times");
	}
	
	
	
}
