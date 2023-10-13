package lab;

import java.security.PublicKey;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticObjects {
		
	private Game game;
	private Rectangle leftLine, rightLine;
	private Point2D position;
	
	private final double lineWidth = 20;
	private final double sideLineWidth = 2;
	private final int netNum = 15;
	

	
	public StaticObjects(Game game) {
		this.game = game;
		this.leftLine = new Rectangle(game, new Point2D(0,0), sideLineWidth, game.getHeight());
		this.rightLine = new Rectangle(game, new Point2D(game.getWidth() - sideLineWidth,0), sideLineWidth, game.getHeight());
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0 , game.getWidth(), game.getHeight()); //background
		
		gc.setFill(Color.GRAY);
		gc.fillRect(0, 0, game.getWidth(), lineWidth); //upper line
		gc.fillRect(0, game.getHeight() - lineWidth, game.getWidth(), lineWidth); //bottom line
		
		for (int i = 0; i < netNum ; i++) {
			gc.fillRect(game.getWidth()/2 - lineWidth/2, lineWidth + (i * 2 * lineWidth), lineWidth, lineWidth); //center line
		}
		this.leftLine.draw(gc);
		this.rightLine.draw(gc);
		
		
	}
	
	public Rectangle getLeftLine() {
		return this.leftLine;
	}
	
	public Rectangle getRightLine() {
		return this.rightLine;
	}
}
