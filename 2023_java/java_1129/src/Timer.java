

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Timer extends JFrame {
	public static Container c;
	public Timer() {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
				
		setPreferredSize(new Dimension(300, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		
		MyLable timer1 = new MyLable(Color.red);
		
		timer1.start();
		
		
		
	}
	
	public static void main(String[] args) {
		new Timer();
	}
}
class MyLable extends Thread{
	JLabel lab;
	int n;
	Color col;
	public MyLable(Color col) {
		n = 0;
		this.col = col;
		lab = new JLabel(n+"", SwingConstants.CENTER);
		lab.setOpaque(true);
		lab.setFont(new Font("arial",Font.BOLD, 28));
		lab.setForeground(col);
		lab.setBackground(Color.WHITE);
		Timer.c.add(lab);
	}
	
	
	public void run() {
		while(true) {
			n++;
			lab.setText(n+"");

			try {
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
