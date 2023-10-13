package lab;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Point2D;

public class Score {
	
	private final Game game;
	private int score;
	private Point2D position;

	
	
	public Score(Game game, Point2D position, int score) {
		this.score = score;
		this.position = position;
		this.game = game;
	}
	
	public void renderScore(GraphicsContext gc) {
		gc.setFont(Font.font("Arial", FontWeight.BOLD, 80));
	    gc.setFill(Color.GREY);
	    
	    Point2D p = game.transform2Canvas(position, 0);
	    String scoreTxt = "" + score;
	    gc.fillText(scoreTxt, p.getX(), p.getY());
	}
	
	public void addScore() {
		score++;
	}
	
	public void subtrScore() {
		score--;
	}

}
