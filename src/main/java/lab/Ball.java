package lab;



import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Ball implements DrawableSimulable, Collisionable  {
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
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.save();
		gc.setFill(Color.GRAY);
		Point2D p = game.transform2Canvas(position, size);
		gc.fillRect(p.getX(), p.getY(), size, size);
		gc.restore();
	}
	
	@Override
	public void simulate(double deltaT) {
		position = position.add(velocity.multiply(deltaT));
	
	/*	if (position.getX() < 0 || position.getX() > game.getWidth() ){
			velocity = velocity.multiply(-1);
		}*/
	}
	
	@Override
	public Rectangle2D getBoundingBox() {
		System.out.print("Ball");
		return new Rectangle2D(position.getX(), position.getY(), size, size);
	}
	
	
	
	public double getBallCeneterX() {
		return getBoundingBox().getMinX() + getBoundingBox().getWidth()/2;
	}
	
	public double getBallCeneterY() {
		return getBoundingBox().getMinY() + getBoundingBox().getHeight()/2;
	}
	
	public void collisionBat(double angle) {
		double speed = velocity.magnitude();
		velocity = new Point2D(speed * Math.cos(angle), -speed * Math.sin(angle));
	}
	
	public void collisionWallLeftRight() {
		velocity = new Point2D(-velocity.getX(), velocity.getY());
	}
	
	public void collisionWallUpperBottom() {
		velocity = new Point2D(velocity.getX(), -velocity.getY());
	}

	//@Override
	public void collision(Object entity) {
		if (entity instanceof Collisionable ce2 && this.getBoundingBox().intersects(((Collisionable) entity).getBoundingBox())) {
			
			if (entity instanceof Bat bat) {
				double speed = velocity.magnitude();
				Double angle;
				angle = Math.atan2(this.getBoundingBox().getMinY() - bat.getBoundingBox().getMaxY(), this.getBallCeneterX() - bat.GetBatCenterX());
				velocity = new Point2D(speed * Math.cos(angle), -speed * Math.sin(angle));
			}
			
			if (entity instanceof Rectangle re) {
				if (re.getLabel() == "leftLine" || re.getLabel() == "rightLine") {
					velocity = new Point2D(-velocity.getX(), velocity.getY());
				}	
				
				if (re.getLabel() == "upperLine" || re.getLabel() == "bottomLine") {
					velocity = new Point2D(velocity.getX(), -velocity.getY());
				}	
				
			}
		}
		
	}
	
	
}
