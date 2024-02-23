

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Filling_bar extends JFrame {
	private static MyBar bar;
	
	public Filling_bar() throws InterruptedException {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(null);
		bar = new MyBar(100);
		bar.setBounds(20,20,440,130);
		bar.setOpaque(true);
		bar.setBackground(Color.yellow);
		c.add(bar);
		
		

		
		setSize(new Dimension(500, 200));

		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Filling_bar();
	}
	
	private class MyBar extends JLabel {
		int maxBar, BarSize;
		public MyBar(int max_bar) {
			BarSize = 50;
			maxBar = max_bar;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int width = (int) (getWidth()*((double)BarSize / maxBar));
			if(width == 0) {
				return;
			}
			g.setColor(Color.RED);
			g.fillRect(0, 0, width, getHeight());
		}
		
		synchronized void fill() {
			if(BarSize == maxBar) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			BarSize++;
		}
		synchronized void consume() {
			if(BarSize == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			BarSize--;
			notify();
		}
	}
}





