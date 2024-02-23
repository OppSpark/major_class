import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.LinkedTransferQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HW2 extends JFrame{
	public static Lab LT[];
	public static int N;
	public static String words[];
	
	public HW2() {
		setTitle("[과제 #2] 반짝 반짝");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 0));
		
		LT = new Lab[words.length];
		
		for(int i=0; i<words.length; i++) {
			c.add(LT[i] = new Lab(words[i]));
		}
		
		setPreferredSize(new Dimension(100*words.length+35, 160));
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}

	public static void main(String[] args) throws InterruptedException {
		words = args[0].split("X");	
		N = Integer.parseInt(args[1]);
		
		new HW2();
		
		switch (N) {
		 case 1: 
	            for(int i=0; i<words.length; i++) {
	                Thread.sleep(500);
	                LT[i].setBackground(Color.RED);
	                LT[i].setForeground(Color.WHITE);
	                
	            }
	            Thread.sleep(1500);
	            for(int i=words.length - 1; i>=0; i--) {
	                Thread.sleep(500);
	                LT[i].setBackground(Color.white);
	                LT[i].setForeground(Color.black);
	            }
	           

	            break;
		case 2:
			for(int i=0; i<words.length/2; i++) {
				Thread.sleep(500);
				LT[i].setBackground(Color.BLUE);
				LT[i].setForeground(Color.RED);
				LT[words.length-1-i].setBackground(Color.RED);
				LT[words.length-1-i].setForeground(Color.BLUE);
			}
			if(words.length%2 != 0) {
				Thread.sleep(500);
				LT[words.length/2].setBackground(Color.BLACK);
				LT[words.length/2].setForeground(Color.white);
				Thread.sleep(500);
				LT[words.length/2].setBackground(Color.white);
				LT[words.length/2].setForeground(Color.black);
				
			}
			
			for(int i=words.length/2-1; i>=0; i--) {
				Thread.sleep(500);
				LT[i].setBackground(Color.white);
				LT[i].setForeground(Color.black);
				LT[words.length-1-i].setBackground(Color.white);
				LT[words.length-1-i].setForeground(Color.black);
			}
			break;
		case 3:
			for(int i=0; i<words.length; i++) {
				Thread.sleep(500);
				if(i%2 != 0) {
					LT[i].setBackground(Color.DARK_GRAY);
					LT[i].setForeground(Color.ORANGE);
				}else {
					LT[i].setBackground(Color.yellow);
					LT[i].setForeground(Color.blue);
				}
			}
			for(int j=0; j<words.length/2+1; j++) {
				Thread.sleep(500);
				for(int i=0; i<words.length; i++) {
					if(i%2 == 0) {
						LT[i].setBackground(Color.red);
						LT[i].setForeground(Color.white);
					}else {
						LT[i].setBackground(Color.CYAN);
						LT[i].setForeground(Color.GRAY);
					}
				}
				
				for(int i=0; i<words.length/2; i++) {
					Thread.sleep(500);
					LT[i].setBackground(Color.red);
					LT[i].setForeground(Color.white);
					LT[words.length-1-i].setBackground(Color.ORANGE);
					LT[words.length-1-i].setForeground(Color.white);
				}
				Thread.sleep(500);
				for(int i=0; i<words.length; i++) {
					if(i%2 != 0) {
						LT[i].setBackground(Color.red);
						LT[i].setForeground(Color.blue);
					}else {
						LT[i].setBackground(Color.magenta);
						LT[i].setForeground(Color.WHITE);
					}
				}
				
			}
			
			for(int i=0; i<words.length; i++) {
				LT[i].setBackground(Color.white);
				LT[i].setForeground(Color.black);
			}
			break;
		case 4:
			for(int i=0; i<words.length; i++) {
				LT[i].setBackground(Color.black);
				LT[i].setForeground(Color.pink);
			}
			for(int i=0; i<words.length*2; i++) {
				Thread.sleep(300);
				if(i<words.length) {
					for(int j=0; j<=i; j++) {
						LT[j].setText("");
						LT[i].setBackground(Color.magenta);
						LT[i].setForeground(Color.BLUE);
						
					}
					for(int j=i+1; j<words.length; j++) {
						LT[j].setText(words[j-i-1]);
						LT[i].setForeground(Color.BLUE);
					}
				}else {
					for(int j=0; j<=i-words.length; j++) {
						LT[j].setText(words[words.length-(i-words.length)-1+j]);

					}
				}
			}
			for(int i=0; i<words.length; i++) {
				Thread.sleep(300);
				LT[i].setBackground(Color.white);
				LT[i].setForeground(Color.black);
			}
			break;
		case 5:
			for(int i=0; i<words.length; i++) {
				LT[i].setBackground(Color.black);
				LT[i].setForeground(Color.GREEN);
				LT[i].setText("");
			}
			for(int k=0; k<3; k++) {
				for(int i=0; i<words.length; i++) {
					Thread.sleep(180);
					for(int j=0; j<=i; j++) {
						LT[words.length-j-1].setText(words[i-j]);
						LT[i].setBackground(Color.PINK);
						LT[i].setForeground(Color.yellow);
					}
				}
				for(int i=0; i<words.length; i++) {
					LT[i].setBackground(Color.BLUE);
					Thread.sleep(180);
					for(int j=0; j<words.length-i-1; j++) {
						
						LT[j].setText(words[j+i+1]);
						
						LT[i].setForeground(Color.ORANGE);
					}
					for(int j=0; j<=i; j++) {
						LT[words.length-j-1].setText("");
					}
				}
			}
			for(int i=0; i<words.length; i++) {
				Thread.sleep(180);
				for(int j=0; j<=i; j++) {
					LT[words.length-j-1].setText(words[i-j]);
					LT[i].setBackground(Color.BLACK);
					LT[i].setForeground(Color.CYAN);
				}
			}
			for(int i=0; i<words.length; i++) {
				Thread.sleep(150);
				LT[i].setBackground(Color.white);
				Thread.sleep(150);
				LT[i].setForeground(Color.black);
			}
			break;
		default:
			break;
		}
	}
}

class Lab extends JLabel implements Runnable {
	boolean	pause = false, cont=true;
	Color col;
	Thread	th;
	
	public Lab(String n) {
		th = new Thread(this);
		setText(n);
		setOpaque(true);
		setBackground(Color.white);
		setForeground(Color.black);
		setFont(new Font("Arial", Font.BOLD, 24));
		setHorizontalAlignment(SwingConstants.CENTER);
		
		th.start();
	}
	
	public void run() {
		HW2 sTHw2 = (HW2) getTopLevelAncestor();
		boolean On = true;
		while(cont) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				;
			}
			if(pause) {
				while(pause) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						if(!pause) {
							break;
						}
					}
				}
			}
		}
	}
}