import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player{
	
	private int x, y;
	private int yMove, ID;
	public int points;
	public Rectangle rocket;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Player(int x, int y, int ID) {
		points = 0;
		this.x = x;
		this.y = y;
		this.ID = ID;
		rocket = new Rectangle(this.x, this.y, 5, 25); //adjust height/width accordingly
	}
	
	/*
	 * public void keyPressed(KeyEvent e) { switch(ID) { case 1: if(e.getKeyCode()
	 * == e.VK_W) { setYMove(-1); } if(e.getKeyCode() == e.VK_S) { setYMove(+1); }
	 * break; case 2: if(e.getKeyCode() == e.VK_UP) { setYMove(-1); }
	 * if(e.getKeyCode() == e.VK_DOWN) { setYMove(+1); } break; default: break; } }
	 */
	/*
	 * public void keyReleased(KeyEvent e) { switch(ID) { case 1: if(e.getKeyCode()
	 * == e.VK_W) { setYMove(0); } if(e.getKeyCode() == e.VK_S) { setYMove(0); }
	 * break; case 2: if(e.getKeyCode() == e.VK_UP) { setYMove(0); }
	 * if(e.getKeyCode() == e.VK_DOWN) { setYMove(0); } break; default: break; } }
	 */
	
	public void move(int ymove) {
		rocket.y += ymove;
		if(rocket.y <= 15) {
			rocket.y = screenSize.height-100;
		}
		if(rocket.y >= screenSize.height-100) {
			rocket.y = screenSize.height-100;
			points++;
		}
	}
	public void draw(Graphics g) {
		switch(ID) {
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
	
}
