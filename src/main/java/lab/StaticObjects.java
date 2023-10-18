package lab;

import java.io.ObjectInputStream.GetField;
import java.security.PublicKey;
import java.util.Iterator;

//import javax.swing.text.html.parser.Entity;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticObjects implements Collisionable{
		
	private Game game;
	protected Rectangle[] wallsRectangles;
	//private Rectangle upperLine, bottomtLine;
	private Point2D position;
	
	private final double lineWidth = 20;
	private final double sideLineWidth = 2;
	private final int netNum = 15;
	

	
	public StaticObjects(Game game) {
		this.game = game;
		this.wallsRectangles = new Rectangle[] {
		/*	new Rectangle(game, new Point2D(0,0), sideLineWidth, game.getHeight()), //leftLine 
			new Rectangle(game, new Point2D(game.getWidth() - sideLineWidth,0), sideLineWidth, game.getHeight()),		//rightLine 
			new Rectangle(game, new Point2D(0, game.getHeight() - lineWidth), game.getWidth(), lineWidth),//upperLine
			new Rectangle(game, new Point2D(0, 0), game.getWidth(), lineWidth)  //bottomtLine */
		};
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0 , game.getWidth(), game.getHeight()); //background
		
		gc.setFill(Color.GRAY);
		for (int i = 0; i < netNum ; i++) {
			gc.fillRect(game.getWidth()/2 - lineWidth/2, lineWidth + (i * 2 * lineWidth), lineWidth, lineWidth); //center line
		}
	/*	for(Rectangle rectangle : wallsRectangles) {
			rectangle.draw(gc);
		}*/
		
		
		
		
	}
	
	public Rectangle getLeftLine() {
		return this.wallsRectangles[0];
	}
	
	public Rectangle getRightLine() {
		return this.wallsRectangles[1];
	}
	
	public Rectangle getUpperLine() {
		return this.wallsRectangles[2];
	}
	
	public Rectangle getBottomLine() {
		return this.wallsRectangles[3];
	}

	@Override
	public Rectangle2D getBoundingBox() {
		
		if (this.equals(getLeftLine())) {
			System.out.print("bumLeva\n");
			return new Rectangle2D(getLeftLine().getPosition().getX(), getLeftLine().getPosition().getY(), getLeftLine().getSizeX(), getLeftLine().getSizeY());
		}
		
		if (this.equals(getRightLine())) {
			System.out.print("bumRight\n");
			return new Rectangle2D(getRightLine().getPosition().getX(), getRightLine().getPosition().getY(), getRightLine().getSizeX(), getRightLine().getSizeY());
		}
		
		if (this.equals(getUpperLine())) {
			System.out.print("bumUpp\n");
			return new Rectangle2D(getUpperLine().getPosition().getX(), getUpperLine().getPosition().getY(), getUpperLine().getSizeX(), getUpperLine().getSizeY());
		}
		
		if (this.equals(getBottomLine())) {
			System.out.print("bumBottom\n");
			return new Rectangle2D(getBottomLine().getPosition().getX(), getBottomLine().getPosition().getY(), getBottomLine().getSizeX(), getBottomLine().getSizeY());
		}
		
		return null;
	}


	public Rectangle[] GetWallsArr() {
		return wallsRectangles;
	}


	
}
