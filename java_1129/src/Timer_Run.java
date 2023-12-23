

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Timer_Run extends JFrame {
	public static Container c;
	private int Num_Timers = 3;
	private MyLable[] labs = new MyLable[Num_Timers];
	public Timer_Run() {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		setLayout(new GridLayout(0, Num_Timers));
				
		
		MyLable timer1 = new MyLable(Color.red);
		c.add(timer1);
		
		for(int i = 0; i < labs.length; i++) {
			c.add(labs[i] = new MyLable(Color.red));
		}
		labs[3].pause=true;
		
		
		setPreferredSize(new Dimension(50* Num_Timers, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		

	
		
		
		labs[3].pause=true;
		
		
	}
	
	public static void main(String[] args) {
		new Timer_Run();
	}
	private class MyLable extends Thread implements Runnable{

		int n;
		Color col;
		Thread th;
		boolean pause;
		public MyLable(Color col) {
			n = 0;
			this.col = col;
			pause = false;
			setOpaque(true);
			//setHo]\
			setFont(new Font("arial",Font.BOLD, 28));
			setForeground(col);
			setBackground(Color.WHITE);
			
			th = new Thread(this);
			th.start();
		}
		
		
		public void run() {
			while(true) {
				n++;
				setText(n+"");

				try {
					Thread.sleep(1000);
					if(pause) {
						while(pause) {
							Thread.sleep(100);
						}
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		}
	}
}

