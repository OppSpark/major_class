

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Timer_Ex extends JFrame {
	public static Container	c;
	public static int Num_Timers = 10;
	public static MyLabel[] labs = new MyLabel[Num_Timers];

	public Timer_Ex() {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new GridLayout(0, Num_Timers));
		c.addKeyListener(new MyHandler());
		for(int i = 0; i < labs.length; i++) {
			labs[i] = new MyLabel(Color.red);
			labs[i].start();
		}
		
		setPreferredSize(new Dimension(Num_Timers * 80, 100));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		c.requestFocus();
	}
	private class MyHandler extends KeyAdapter{

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			for(int i = 0; i < 10; i++) {    // F1 부터 F10 까지 스위치문을 해당 문법으로 코딩함
				if(e.getKeyCode() == KeyEvent.VK_F1 + i)
					labs[i].pause = !labs[i].pause;
			}
		}
	}
	
	public static void main(String[] args) {
		new Timer_Ex();
	}
}
class MyLabel extends Thread {
	JLabel	lab;
	int		n;
	Color	col;
	boolean pause;
	public MyLabel(Color col) {
		n = 0;
		pause = false;
		this.col = col;
		lab = new JLabel(n+"", SwingConstants.CENTER);
		lab.setOpaque(true);
		lab.setFont(new Font("Arial", Font.BOLD, 28));
		lab.setForeground(col);
		lab.setBackground(Color.white);
		Timer_Ex.c.add(lab);
	}
	public void run() {
		while(true) {
			n++;
			lab.setText(n+"");
			try {
				sleep(1000);
				if(pause) {
					while(pause) {
						sleep(50);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




