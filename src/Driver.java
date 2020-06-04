import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Driver extends JFrame implements Runnable {
	//boolean[] moveKeyCodes;

	private Image image;
	private Graphics graphic;
	private Thread Driver = new Thread(this);
	private Player player1 = new Player(125, 525, 1);
	private Player player2 = new Player(675, 525, 2);
	private Thread p1 = new Thread(player1);
	private Thread p2 = new Thread(player2);
	private int gameWidth = 800;
	private int gameHeight = 600;
	public Dimension screenSize = new Dimension(gameWidth, gameHeight);
	private ArrayList<Meteor> meteorList = new ArrayList<Meteor>();

	public static void main(String[] args) {
		Driver d = new Driver();
		
	}

	public Driver() {
		this.setTitle("CS SpaceRace");
		this.setSize(screenSize);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		this.addKeyListener(new AL());
		startGame();
		// System.out.println(moveKeyCodes[0]);

	}
	/*
	 * public void init() { font = new Font("Courier New", 1, 20); moveKeyCodes =
	 * new boolean[4]; }
	 */

	/*
	 * @Override public void actionPerformed(ActionEvent e) { update(); repaint(); }
	 */

	public void startGame() {
		int lowerBound = 50;
		
		Driver.start();
//		meteors.start();
//		p1.start();
//		p2.start();
	}

	public void paint(Graphics g) {
		//System.out.println("Painting");
		image = createImage(getWidth(), getHeight());
		graphic = image.getGraphics();
		draw(graphic);
		g.drawImage(image, 0, 0, this);

	}

	public void draw(Graphics g) {
		//System.out.println("Drawing");
		for(Meteor m : meteorList) {
			
			m.draw(g);
		}
		
		player1.draw(g);
		player2.draw(g);

		g.setColor(Color.WHITE);
		g.drawString("" , 15, 50);
		g.drawString("" , 370, 50);
		
	}

	/*
	 * public void update() {
	 *
	 * if (moveKeyCodes[0]) { p1.move(-1); } if (moveKeyCodes[1]) { pp1.move(1); }
	 * if (moveKeyCodes[2]) { pp2.move(-1); } if (moveKeyCodes[3]) { pp2.move(1); }
	 *
	 * }
	 */

	/*
	 * @Override public void keyPressed(KeyEvent e) { // TODO Auto-generated method
	 * stub if(e.getKeyCode() == KeyEvent.VK_W) { moveKeyCodes[0] = true; }
	 * if(e.getKeyCode() == KeyEvent.VK_S) { moveKeyCodes[1] = true; }
	 * if(e.getKeyCode() == KeyEvent.VK_UP) { moveKeyCodes[2] = true; }
	 * if(e.getKeyCode() == KeyEvent.VK_DOWN) { moveKeyCodes[3] = true; }
	 *
	 * }
	 */

	/*
	 * @Override public void keyReleased(KeyEvent e) { if(e.getKeyCode() ==
	 * KeyEvent.VK_W) { moveKeyCodes[0] = false; } if(e.getKeyCode() ==
	 * KeyEvent.VK_S) { moveKeyCodes[1] = false; } if(e.getKeyCode() ==
	 * KeyEvent.VK_UP) { moveKeyCodes[2] = false; } if(e.getKeyCode() ==
	 * KeyEvent.VK_DOWN) { moveKeyCodes[3] = false; } // TODO Auto-generated method
	 * stub
	 *
	 * }
	 */
	public class AL extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) { // when key is pressed
			player1.keyPressed(e);
			player2.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) { // when key is released
			player1.keyReleased(e);
			player2.keyReleased(e);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				if(meteorList.size() < 30) {
					
					int direction = (int) (Math.random()*2);
					System.out.println(direction);
					meteorList.add(new Meteor(direction));
				}
				//System.out.println("hi");
				for(int i = 0; i < meteorList.size(); i++) {
					meteorList.get(i).move();
					player1.collision(meteorList.get(i).getRectangle());
					player2.collision(meteorList.get(i).getRectangle());
					//System.out.println("hi");
					if(meteorList.get(i).canRemove()) {
						//System.out.println("removed");
						meteorList.remove(i);
					}
					
				}
				//System.out.println(meteorList.size());
				player1.move();
				player2.move();
				repaint();
				Thread.sleep(17);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
