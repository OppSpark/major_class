import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Filling_Bar extends JFrame {
	private static MyBar bar;
	private  static final int PRODUCER = 1, CONSUMER = 0;
	public Filling_Bar() throws InterruptedException {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar = new MyBar(100);
		bar.setBounds(20, 20, 440, 130);
		bar.setOpaque(true);
		bar.setBackground(Color.RED);
		c.add(bar);
		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					bar.fill();
					repaint();
				}
			}
		});
		setSize(new Dimension(500, 200));
		setVisible(true);
		setLocationRelativeTo(null);
		Worker consumer1 = new Worker(CONSUMER,200, bar), consumer2 = new Worker(CONSUMER,200, bar),
				producer = new Worker(PRODUCER,200,  bar);
		consumer1.start();
		consumer2.start();
		producer.start();
		c.requestFocus();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Filling_Bar();
	}

	private class Worker extends Thread{
		private int type, delay;


		public Worker(int ty, int d, MyBar b){
			type = ty; delay = d; bar = b;
		}


 public void run() {
			while(true){
				if(type == PRODUCER)
					bar.fill();
				else
					bar.consume();
				try{
					sleep(delay+Rand.r(0,50));
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				repaint();
			}
		}
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
			g.setColor(Color.BLUE);
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

















