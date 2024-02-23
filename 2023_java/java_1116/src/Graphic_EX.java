
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.GapContent;

public class Graphic_EX extends JFrame {
	private static final int WIDTH = 500, HEIGHT = 500,F_X=20, F_Y=20,F_W=100,F_H=100;
	private static MyPanel p;
	private	static	boolean RectSelected = true;
	private static	Figure rect, circle, curFigure;
	public static Color[] cols = {Color.RED, Color.ORANGE, Color.PINK, Color.GREEN, Color.blue};
	private static int cidx = 0;
	public Graphic_EX() {
		super("Graphics Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new MyPanel();
		setContentPane(p);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		p.requestFocus();
	}
	private class MyHandler implements KeyListener, MouseWheelListener, MouseMotionListener {

		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_F1) {
				RectSelected = !RectSelected;
				curFigure = (RectSelected)? rect : circle;
				setTitle(((RectSelected)?"사각형":"원")+"이 선택 됨");
			}
			
			switch (e.getKeyCode()) {

			case KeyEvent.VK_F5:
				rect.setShow();
				break;
			case KeyEvent.VK_F6:
				circle.setShow();
				break;
			case KeyEvent.VK_UP:
				curFigure.changeCoord(0, -5, p.getWidth(), p.getHeight());
				break;
				
			case KeyEvent.VK_DOWN:
				curFigure.changeCoord(0, +5, p.getWidth(), p.getHeight());
				break;
			case KeyEvent.VK_LEFT:
				curFigure.changeCoord(-5, 0, p.getWidth(), p.getHeight());
				break;
			case KeyEvent.VK_RIGHT:
				curFigure.changeCoord(5, 0, p.getWidth(), p.getHeight());
				break;
			case KeyEvent.VK_PLUS:
				cidx++;
				cidx %= cols.length;
				curFigure.setColor(cols[cidx]);
				break;
			case KeyEvent.VK_MINUS:
				cidx--;
				cidx = (cidx < 0) ? cols.length-1 : cidx;;
				curFigure.setColor(cols[cidx]);
				break;
			default:
				break;
			}	
			if(curFigure.show)
				repaint();
		}
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if(e.getWheelRotation() < 0) {
				curFigure.setSize(5);
			} else {
				curFigure.setSize(-5);
			}
			repaint();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX(), y = e.getY();
			
			curFigure.setCoord(x,y);
			
			if(curFigure.show)
				repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public static void main(String[] args) {
		new Graphic_EX();
	}

	private class MyPanel extends JPanel {
		public MyPanel() {
			rect  = new Rectangle(F_X, F_Y, F_W, F_H, cols[cidx]);
			circle = new Circle(F_X+200, F_Y+200, F_W, F_H, cols[cols.length -1]);
			curFigure = rect;
			addKeyListener(new MyHandler());
			addMouseWheelListener(new MyHandler());
			addMouseMotionListener(new MyHandler());
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			rect.drawFigure(g);
			circle.drawFigure(g);
		}
	}
}