package lab;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements DrawAble, Collisionable{

	private final Game game;
	private Point2D position;
	private double sizeX;
	private double sizeY;
	private final String label;
	private Color color;
	
	
	public Rectangle(Game game, Point2D position, double sizeX, double sizeY, String label ) {
		this.game = game;
		this.position = position;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.label = label;
		this.color = Color.GRAY;
	}
	
	public Rectangle(Game game, Point2D position, double sizeX, double sizeY, String label, Color color) {
		this(game, position, sizeX, sizeY, label);
		this.color = color;
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(color);
		Point2D p = game.transform2Canvas(position, sizeY);
		gc.fillRect(p.getX(), p.getY(), sizeX, sizeY);
	}
	
	
	public Rectangle2D getBoundingBox() {
		System.out.println("rectos");
		return new Rectangle2D(position.getX(), position.getY(), sizeX, sizeY);
	}
	
	String getLabel() {
		return this.label;
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
