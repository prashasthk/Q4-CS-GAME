import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player implements Runnable {

	private int x, y;
	private int yMove, ID;
	protected Rectangle rocket;

	public Player(int x, int y, int ID) {
		this.x = x;
		this.y = y;
		this.ID = ID;
		rocket = new Rectangle(x, y, 10, 30); // adjust height/width accordingly
	}
	

	public void keyPressed(KeyEvent e) {
		switch (ID) {
		default:
			break;
		case 1:
			if (e.getKeyCode() == e.VK_W) {
				setYDirection(-3);
			}
			if (e.getKeyCode() == e.VK_S) {
				setYDirection(+3);
			}
			break;
		case 2:
			if (e.getKeyCode() == e.VK_UP) {
				setYDirection(-3);
			}
			if (e.getKeyCode() == e.VK_DOWN) {
				setYDirection(+3);
			}
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (ID) {
		default:
			break;
		case 1:
			if (e.getKeyCode() == e.VK_W) {
				setYDirection(0);
			}
			if (e.getKeyCode() == e.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:

			if (e.getKeyCode() == e.VK_UP) {
				setYDirection(0);
			}
			if (e.getKeyCode() == e.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}

	public void setYDirection(int ydirect) {
		yMove = ydirect;
	}

	public void move() {
		rocket.y += yMove;
		if (rocket.y <= 15) {
			rocket.y = 525;
		}
		if (rocket.y >= 570) {
			rocket.y = 570;
		}
	}

	public void draw(Graphics g) {
		switch (ID) {
		case 1:
			g.setColor(Color.RED);
			g.fillRect(rocket.x, rocket.y, rocket.width, rocket.height);
			break;
		case 2:
			g.setColor(Color.BLUE);
			g.fillRect(rocket.x, rocket.y, rocket.width, rocket.height);
			break;
		default:
			break;
		}
	}
public void collision(Rectangle meteor) {
		
		if (meteor.intersects(rocket)) {
			
			rocket.y = 525;
		}
		
	}

	@Override
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(2);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
