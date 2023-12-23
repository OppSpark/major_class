
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics_EX extends JFrame{
	private static final int WIDTH = 500, HEIGHT = 500, F_X = 0, F_Y = 0, F_W = 100 ,F_H = 100;
	private static MyPanel p;
	private static boolean ShowRect = true, ShowCircle = true, RectSelected = true;
	private static Figure rect;
	private static Figure circle;
	public Graphics_EX() {
		super("Graphic Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p = new MyPanel();
		
		setContentPane(p);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		p.requestFocus();
		
	}
	private class MyHandler implements KeyListener,MouseWheelListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
			case KeyEvent.VK_F5:
				ShowRect = !ShowRect;
				repaint();
				break;
			case KeyEvent.VK_F6:
				ShowCircle = !ShowCircle;
				repaint();
				break;
			case KeyEvent.VK_F1:
				RectSelected = !RectSelected;
				setTitle(((RectSelected)?"사각형":"원")+"이 선택 됨");
				break;
			default:
				break;
			
			}
		}

	

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			if(e.getWheelRotation() < 0) {
				if(RectSelected) {
				rect.w += 5;
				rect.h += 5;
				}else {
				circle.w += 5;
				circle.h += 5;
				}
				
			}else {
				if(RectSelected) {
				rect.w -= 5;
				rect.h -= 5;
				}else {
				circle.w -= 5;
				circle.h -= 5;
				}
				
			}
			repaint();
		} 
		
	}
	

	
	public static void main(String[] args) {
		new Graphics_EX();
		
	}
	
	private class Figure{
		int x, y, w, h;
		Color col;
		public Figure(int xx, int yy, int ww, int hh, Color C) {
			x = xx; y = yy; w =ww; h = hh; col = C;
		}
		public void drawRect(Graphics g) {
			g.setColor(col);
			g.drawRect(x, y, w, h);
			
		}
		public void drawOval(Graphics g) {
			g.setColor(col);
			g.drawOval(x, y, w, h);
			
		}
	}
	
	
	private class MyPanel extends JPanel{
		public MyPanel() {
			addKeyListener(new MyHandler());
			addMouseWheelListener(new MyHandler());
			rect  = new Figure(F_X,F_Y , F_W, F_H, Color.cyan);
			circle = new Figure(F_X+200, F_Y+200, F_W, F_H, Color.blue);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int[] x = {200,20,200,420}, y = {20,200,420,200};
			
			if(ShowRect) {
				rect.drawRect(g);
			}
			if(ShowCircle) {
				circle.drawOval(g);
			}
			
			/*
			g.setColor(Color.red);
			g.drawRect(10,10,100,100);
			g.setColor(Color.blue);
			g.drawOval(200, 200, 100, 100);
			g.setColor(Color.magenta);
			g.drawRoundRect(200, 500, 100, 100, 50, 50);
			g.setColor(Color.cyan);
			g.fillOval(300, 300, 100, 100);
			g.setColor(Color.red);
			g.fillArc(200, 300, 100, 100, 0, 250);
			g.setColor(Color.pink);
			g.drawPolygon(x,y,x.length);
			*/
		}
	
	}
}
