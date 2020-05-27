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
	JFrame f;
	Timer t;
	Font font;
	Player pp1;
	Player pp2;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Driver d = new Driver();
	}
	
	public Driver() {
		f = new JFrame();
		f.setTitle("Ultimate Chicken Horse");
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
	}
	public void init() {
		font = new Font("Courier New", 1, 20);
		pp1 = new Player(15, 50, 1);
		pp2 = new Player(50, 30, 2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		pp1.draw(g);
		pp2.draw(g);
	}
	
	

	public void update() {
		
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
		if(e.getKeyCode() == e.VK_W) {
			pp1.move(-1);
		}
		if(e.getKeyCode() == e.VK_S) {
			pp1.move(+1);
		}
		if(e.getKeyCode() == e.VK_UP) {
			pp2.move(-1);
		}
		if(e.getKeyCode() == e.VK_DOWN) {
			pp2.move(+1);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
