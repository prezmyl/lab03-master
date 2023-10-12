package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Ball {
	private  Game game;
	private Point2D position;
	private Point2D velocity;
	private final double gap = 40;
	private final double batWidth = 20;		
	private double size;
	
	public Ball(Game game, Point2D position, Point2D velocity, double size) {
		this.game = game;
		this.position = position;
		this.velocity = velocity;
		this.size = size;
		
	}
	
	public void draw(GraphicsContext gc) {
		gc.save();
		gc.setFill(Color.GRAY);
		Point2D p = game.transform2Canvas(position, size, size);
		gc.fillRect(p.getX(), p.getY(), size, size);
		gc.restore();
	}
	
	public void simulate(double deltaT) {
		position = position.add(velocity);
	
		if (position.getX() < 0 || position.getX() > game.getWidth() ){
			velocity = velocity.multiply(-1);
		}
	}
	
	public Rectangle2D getConvexhall() {
		return new Rectangle2D(position.getX(), position.getY(), size, size);
	}
	
	public void collision() {
		velocity = velocity.multiply(-1);
	}
}
