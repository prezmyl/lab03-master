package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle {

	private final Game game;
	private Point2D position;
	private double sizeX;
	private double sizeY;
	private Color color;
	
	public Rectangle(Game game, Point2D position, double sizeX, double sizeY) {
		this.game = game;
		this.position = position;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = Color.GRAY;
	}
	
	public Rectangle(Game game, Point2D position, double sizeX, double sizeY, Color color) {
		this(game, position, sizeX, sizeY);
		this.color = color;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(color);
		Point2D p = game.transform2Canvas(position, sizeY);
		gc.fillRect(p.getX(), p.getY(), sizeX, sizeY);
	}
	
	
	public Rectangle2D getConvexHall() {
		return new Rectangle2D(position.getX(), position.getY(), sizeX, sizeY);
	}

	protected Point2D getPosition() {
		return position;
	}

	protected double getSizeX() {
		return sizeX;
	}
	
	protected double getSizeY() {
		return sizeY;
	}
}
