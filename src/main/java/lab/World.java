package lab;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class World {
	private double width;
	private double height;
	private BulletAnimated bulletAnimatted;
	private Cannon cannon;
	
	public World(double width, double height) {
		this.width = width;
		this.height = height;
		cannon = new Cannon(this, new Point2D(50, 50), new Point2D(100, 20));
		bulletAnimatted = new BulletAnimated(this, cannon, new Point2D(30, 60), new Point2D(0, 0), 40);
	}

	public Point2D getCanvasPoint(Point2D worldPoint, double heightOfEntity) {
		return new Point2D(worldPoint.getX(), height - worldPoint.getY() - heightOfEntity);
	}

	public void draw(GraphicsContext gc) {
		gc.clearRect(0, 0, width, height);
		cannon.draw(gc);
		bulletAnimatted.draw(gc);
	}

	public void simulate(double timeDelta) {
		bulletAnimatted.simulate(timeDelta);
		cannon.simulate(timeDelta);
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
