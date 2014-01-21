package com.example.task1;

public class MainThread extends Thread{

	private boolean isRunning;
	
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
