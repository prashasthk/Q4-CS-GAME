import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener, KeyListener,
MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JFrame f;
	Timer t;
	Font font;
	boolean[] moveKeyCodes;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	Player pp1;
	Player pp2;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Driver d = new Driver();
	}
	
	public Driver() {
		f = new JFrame();
		f.setTitle("Space Race");
		f.setExtendedState(Frame.MAXIMIZED_BOTH);
		f.setResizable(true);
		f.addKeyListener(this);
		f.addMouseListener(this);
		init();	
		t = new Timer(17, this);
		t.start();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
		System.out.println(moveKeyCodes[0]);
		
	}
	public void init() {
		font = new Font("Courier New", 1, 20);
		pp1 = new Player(50, screenSize.height-100, 1);
		pp2 = new Player(screenSize.width-50, screenSize.height-100, 2);
		moveKeyCodes = new boolean[4];
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, screenSize.width, screenSize.height);
		pp1.draw(g);
		pp2.draw(g);

	}
	
	

	public void update() {
	
		if (moveKeyCodes[0]) {
			pp1.move(-1);
		}
		if (moveKeyCodes[1]) {
			pp1.move(1);
		}
		if (moveKeyCodes[2]) {
			pp2.move(-1);
		}
		if (moveKeyCodes[3]) {
			pp2.move(1);
		}
	
	}
	
	 private Image getImage(String path) {
		 Image tempImage = null;
		 try {
		 URL imageURL = Driver.class.getResource(path);
		 tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return tempImage;
	}

	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W) {
			moveKeyCodes[0] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			moveKeyCodes[1] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moveKeyCodes[2] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveKeyCodes[3] = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			moveKeyCodes[0] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			moveKeyCodes[1] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moveKeyCodes[2] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveKeyCodes[3] = false;
		}
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
