import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Filling_Bar extends JFrame {
	private static MyBar bar;
	public Filling_Bar() throws InterruptedException {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar = new MyBar(100);
		bar.setBounds(20, 20, 440, 130);
		bar.setOpaque(true);
		bar.setBackground(Color.yellow);
		c.add(bar);
		
		setSize(new Dimension(500, 200));
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Filling_Bar();
	}
	
	private class MyBar extends JLabel {
		int		maxBar, barSize;
		public MyBar(int max_bar) {
			barSize = 50;
			maxBar = max_bar;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int width = (int) (getWidth()*((double)barSize/maxBar));
			if(width == 0) return;
			g.setColor(Color.red);
			g.fillRect(0, 0, width, getHeight());
		}
		
		synchronized void fill() {
			if(barSize == maxBar) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			barSize++;
		}
		synchronized void consume() {
			if(barSize == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			barSize--;
			notify();
		}
	}
}

















