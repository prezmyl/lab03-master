package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bat implements DrawableSimulable, Collisionable{
		
	private final Game game;
	private final double sizeY;
	private final double sizeX;
	private final double lineWidth = 20;
	
	private Point2D position;
	private Point2D velocity;
	//private Point2D acceleration;

	
	public Bat(Game game, Point2D position, Point2D velocity, double sizeX, double sizeY) {
		this.position = position;
		this.velocity = velocity;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.game = game;
	
	}
	
	public void draw(GraphicsContext gc) {
		gc.save();
		gc.setFill(Color.GRAY);
		Point2D canvasPosition = game.transform2Canvas(position, sizeY);
		gc.fillRect(canvasPosition.getX(), canvasPosition.getY(), sizeX, sizeY);
		gc.restore();
	}
	
	public double GetBatCenterY() {
		return getBoundingBox().getMinY() + getBoundingBox().getHeight()/2;
	}
	
	public double GetBatCenterX() {
		return getBoundingBox().getMinX() + getBoundingBox().getWidth()/2;
	}
	
	
	public void simulate(double timeStep) {
		position = position.add(velocity.multiply(timeStep));	
	    
	    if (position.getY() - lineWidth < 0 || position.getY() + sizeY > (game.getHeight() - lineWidth)) {
			this.velocity = velocity.multiply(-1);
		}
	}
	
	public Rectangle2D getBoundingBox() {
		return new Rectangle2D(position.getX(), position.getY(), sizeX, sizeY);
	}



	
	
}
