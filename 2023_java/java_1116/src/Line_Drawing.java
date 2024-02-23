
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.GapContent;

public class Line_Drawing extends JFrame {
	private static final int WIDTH = 500, HEIGHT = 500;
	private static MyPanel p;
	private static Vector<Line> vLines = new Vector<>();
	private static Line curLine = null;
	private static int start_x, start_y, end_x,end_y;
	public Line_Drawing() {
		super("Graphics Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new MyPanel();
		setContentPane(p);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);


	}
	public static void main(String[] args) {
		new Line_Drawing();
	}
	
	private class MyHadler implements MouseMotionListener, MouseListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			end_x = e.getX();
			end_y = e.getY();
			repaint();

			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			start_x = end_x = e.getX();
			start_y = end_y = e.getY();
			
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
		
	}

	private class MyPanel extends JPanel {
		public MyPanel() {
			curLine = new Line();
			curLine.setLine(50, 50, 400, 300);
			for(int i = 0; i < 5; i++) {
				Line line;
				
				vLines.add(line = new Line());
				line.setLine(Rand.r(100,200), Rand.r(100,200), Rand.r(250,450), Rand.r(250,450));
				
			}
			addMouseMotionListener(new MyHadler());
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i < vLines.size(); i++) {
				vLines.get(i).drawLine(g);
			}
			if(curLine != null) {
				curLine.setLine(start_x, start_y, end_x, end_y);
				curLine.drawLine(g);
			}
		}
	}
}
class Line{
	int sx, sy, ex, ey;
	
	public void setLine(int x1, int y1, int x2, int y2) {
		sx = x1; sy = y1; ex = x2; ey = y2;
		
	}
	public void drawLine(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(sx, sy, ex, ey);
	}
}