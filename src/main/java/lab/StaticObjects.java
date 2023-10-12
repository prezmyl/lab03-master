package lab;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticObjects {
		
	private Game game;
	
	private final double lineWidth = 20;
	private final int netNum = 15;

	
	public StaticObjects(Game game) {
		this.game = game;
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
		
		
	}
}
