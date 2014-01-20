package com.example.task1;
// leses f¿rst <3

import android.graphics.Bitmap;
import android.graphics.Rect;

public class ElaineMarleyWalking {
	private static final String TAG = ElaineMarleyWalking.class.getSimpleName();
	private Bitmap bitmap; 		//selve animasjonssekvensen
	private Rect sourceRect; 	// rektangelet som blir tegnet (selection rectangle)
	private int frameNr; 		// antall "frames" i animasjonen
	private int currentFrame; 	// "frame" vi viser nŒ
	private long frameTicker; 	// ms mellom hver ramme (1000/fps)
	private int framePeriod;
	
	private int spriteWidth; 	// for Œ kutte bildet vŒrt riktig trenger vi Œ vite
								// hvor bredt hver "frame" er 
	private int spriteHeight; 	// samme som width bare med h¿yde
	private int xPositionCoordinate; 	// x posisjonen pŒ skjermen, 0 venstre
	private int yPositionCoordinate; 	// y posisjon pŒ skjermen, 0 top
	
	public ElaineMarleyWalking(Bitmap bitmap, int xPositionCoordinate, int yPositionCoordinate, int width, int height, int fps, int frameCount){
		// constructor tid :D jeg initialiserer basert pŒ verdiene tatt inn, og s¿rger for Œ tegne riktig
		// "rektangel" i spriten til enhver tid 
		this.bitmap=bitmap;
		this.xPositionCoordinate = xPositionCoordinate;
		this.yPositionCoordinate = yPositionCoordinate;
		currentFrame = 0;
		frameNr= frameCount;
		spriteWidth = bitmap.getWidth()/frameCount;
		spriteHeight = bitmap.getHeight();
		sourceRect = new Rect(0,0,spriteWidth, spriteHeight);
		framePeriod = 1000 / fps;
		frameTicker = 01;
	}
	
	public void update(long gameTime){
		// gameTime will let us know how often were supposed to update her, 
		// remember if you made a sprite it might have an optimal update time
		if (gameTime > frameTicker + framePeriod){
			frameTicker = gameTime;
			if (currentFrame >= frameNr){
				currentFrame = 0; 
		}
		this.sourceRect.left = currentFrame * spriteWidth;
		this.sourceRect.right = this.sourceRect.left + spriteWidth;	
		// okay, litt magi her, oppdaterer venstre og h¿yreposisjoenen til rektangelet som skal tegnes :P
		// f¿lg med videre til MainActivity
		}		
	}
}
