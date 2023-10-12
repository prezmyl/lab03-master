package lab;

import java.util.Iterator;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;


public class Game {

	private final double width;
	private final double height;
	private final StaticObjects staticObject;
	private final double lineWidth = 20;
	private final double gap = 40;
	
	private final Bat[] bats; // jen dekl
	private final double sizeBatX = 20;
	private final double sizeBatY = 100;
	private final Ball ball;
	private double sizeBall = 20;
	private double actualTime;
	private double lastHit; //decl s default inic.
	private int batHitCount;
	
	private final Score score1;
	private final Score score2;
	
	
	
	public Game(double width, double height) {
		
		this.width = width;
		this.height = height;
		this.staticObject = new StaticObjects(this);
		this.bats = new Bat[] {
			new Bat(this, new Point2D(gap, lineWidth), new Point2D(0,9), sizeBatX, sizeBatY)
			,new Bat(this, new Point2D(width - (gap + sizeBatX), height - (sizeBatY + lineWidth)), new Point2D(0,-4.5), sizeBatX, sizeBatY)
		};
		this.ball = new Ball(this, new Point2D(width/2 - sizeBall/2 ,height/2), new Point2D(6.41,0), sizeBall);
		this.score1 = new Score(this, new Point2D(width/2 - 2.5 * gap, height - 2.5 * gap), 0);
		this.score2 = new Score(this, new Point2D(width/2 +  1.5 * gap, height - 2.5 * gap), 0);
	}

	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, width, height);
		this.staticObject.draw(gc);
		for (Bat bat : bats) {
			bat.draw(gc);
		}
		this.ball.draw(gc);
		this.score1.renderScore(gc);
		this.score2.renderScore(gc);
	}
	
	public void simulate(double timeDelta) {
		for(Bat bat: bats) {
			bat.simulate(timeDelta);
		}
		this.ball.simulate(timeDelta);
		

		Rectangle2D chOfball = ball.getConvexhall();
		for (Bat bat : bats) {
			if (bat.getConvexHall().intersects(chOfball)) {
				ball.collision();
				batHitCount++;
						
				if (bat == bats[0]) {
					score1.addScore();
				}
				else {
					score2.addScore();
				}
			}
			/*if (position.getX() < 0 || position.getX() > game.getWidth() ){
				velocity = velocity.multiply(-1);
			}*/
			
			if (chOfball.getMinX() < 0) {
				ball.collision();
				score1.subtrScore();
				
			}
			if (chOfball.getMaxX() > this.getWidth()) {
				ball.collision();
				score1.subtrScore();
			}
		}
		
	}
	
	public Point2D transform2Canvas(Point2D worldPoint, double entityWidth, double entityHieght ) {
		return new Point2D(worldPoint.getX() - entityWidth/2, height - worldPoint.getY() - entityHieght);
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
