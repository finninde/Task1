package com.example.task1;

import android.view.SurfaceHolder;

public class MainThread extends Thread{
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
		while(isRunning){
			//TODO: update game state, and render state to screen
		}
	}
	
	
	
}
