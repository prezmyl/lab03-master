package lab;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawingThread extends AnimationTimer {

	private static final int FPS = 100;

	private final Canvas canvas;
	
	private final GraphicsContext gc;
	double fixedDeltaT = 0.9;

	private final Game game;
	
	private long lasttime = -1;

	public DrawingThread(Canvas canvas) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.game = new Game(canvas.getWidth(), canvas.getHeight());
	}

	/**
	  * Draws objects into the canvas. Put you code here. 
	 */
	@Override
	public void handle(long now) {
		
		double deltaT = (now - lasttime) / 1e9;
		if (deltaT >= 1./FPS) {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			//world.draw(gc);
			game.draw(gc);
			if (lasttime > 0) {
				//time are in nanoseconds and method simulate expects seconds
				
				//world.simulate(deltaT);
				game.simulate(fixedDeltaT);
			}
			lasttime = now;
		}
		
	}

}
