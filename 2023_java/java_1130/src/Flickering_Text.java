

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Flickering_Text extends JFrame {
	private static F_Lab[] labs = new F_Lab[5];
	public Flickering_Text() throws InterruptedException {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(new GridLayout(0, 5));
		
				
		for(int i = 0; i < labs.length; i++) {
			labs[i] = new F_Lab("STR_"+ i, new Color(Rand.r(0,255),Rand.r(0,255),Rand.r(0,255)), Rand.r(100,500));
			c.add(labs[i]);
		}
		
		
		setPreferredSize(new Dimension(300, 100));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		while(true) {
			for(int i = 0; i < labs.length; i++) {
				labs[i].On = !labs[i].On;
				Thread.sleep(500);
				labs[i].On = !labs[i].On;
			}
			for(int i = labs.length; i < labs.length; i--) {
				labs[i].On = !labs[i].On;
				Thread.sleep(500);
				labs[i].On = !labs[i].On;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Flickering_Text();
	}
	
	private class F_Lab extends JLabel implements Runnable{
		Color col;
		boolean On;
		int delay;
		Thread th;
		
		public F_Lab(String n, Color col, int d ) {
			super(n);
			this.col = col;
			On = true;
			delay = d;
			setOpaque(true);
			setBackground(col);
			setForeground(Color.WHITE);
			setHorizontalAlignment(SwingConstants.CENTER);
			
			th = new Thread(this);
			th.start();
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				if(On) {
					setBackground(Color.blue);
				} else {
					setBackground(col);
				}
				On = !On;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
