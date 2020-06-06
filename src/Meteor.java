

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Meteor implements Runnable {
	private int x, y;
	protected int xDirection;

//protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private Rectangle meteor;
	private Random random;

	public Meteor(int direction) {
		y = (int) ((Math.random() * 400) + 75);
		if (direction == 0) {
			xDirection = -3;

			x = (int) ((Math.random() * 850) + 700);
		} else {
			xDirection = 3;

			x = (int) ((Math.random() * 1000) - 900);

		}

		meteor = new Rectangle(x, y, 7, 7);
// random = new Random();
// int randomXdirect = random.nextInt(2);
// if (randomXdirect == 0) {
// randomXdirect = -3;
// } else {
// randomXdirect = 3;
// }
// setXDirection(randomXdirect);
	}

// public void setXDirection(int xdirect) {
// xDirection = xdirect;
// }

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);

		g2.fillOval(x, y, 7, 7);
	}

	public Rectangle getRectangle() {
		return meteor;
	}

	public void move() {
		x += xDirection;
		meteor.x = x;
//System.out.println(xDirection);
//System.out.println(meteor.x);
	}

	public boolean canRemove() {

		if (xDirection > 0 && x > 850 || xDirection < 0 && x < -50) {
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(3);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}