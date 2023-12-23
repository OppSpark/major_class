
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HW1 extends JFrame{
	private static int W1, H1;
	private static int selectedIdx = 0;
	private MyPanel p;
	private JLabel[] lab = new JLabel[4];
	private Rect[] rect = new Rect[4];
	

	
	public HW1(String W, String H) {
		
		super("[과제 #1] 사각형1 선택 됨");
		W1 = Integer.parseInt(W);
		H1 = Integer.parseInt(H);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(p = new MyPanel());
	
		p.addKeyListener(new Myhandler());
		p.addMouseWheelListener(new Myhandler());
		
		setSize(W1, H1);
		setVisible(true);
		setLocationRelativeTo(null);
		p.requestFocus();
		lab[0].setForeground(Color.RED);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Random Rand1 = new Random(); 
			
			if(rect[0] != null) {
				for(int i=0; i<4; i++) {
					g.drawRect(rect[i].x, rect[i].y, rect[i].Side_lab, rect[i].Side_lab);
					lab[i].setBounds(rect[i].x+3, rect[i].y, 55, 15);
				}
			}else {
				for(int i=0; i<4; i++) {
					int side = Rand1.nextInt(W1-25<H1-50?W1-25:H1-50)+1;
					int x = Rand1.nextInt(W1-15-side), y = Rand1.nextInt(H1-40-side)+1;
					
					lab[i] = new JLabel("[사각형 "+(i+1)+"]");
					lab[i].setBounds(x+3, y, 55, 15);
					lab[i].setForeground(Color.BLUE);
					add(lab[i]);
					
					g.drawRect(x, y, side, side);
					rect[i] = new Rect(x, y, side, lab[i]);
				}
			}
		}
		
		
		
	}
	
	class Rect{
		JLabel lab;
		int x, y, Side_lab;
		public Rect(int x, int y, int side, JLabel lab) {
			this.x = x; this.y = y;  
			this.Side_lab = side; this.lab = lab;
		}
	}
	
	public static void main(String[] args) {
		if(args.length == 2) {
			String W = new String(args[0]); 
			String H = new String(args[1]);
			new HW1(W,H);
		}else{
			System.out.println("인자값이 잘못되었습니다.");
		}
	}
	
	class Myhandler implements KeyListener, MouseWheelListener{
	
		public void mouseWheelMoved(MouseWheelEvent e) {
		    if(e.getWheelRotation() < 0) {
		        if(rect[selectedIdx].Side_lab < (W1 < H1 ? W1:H1) && 
		            rect[selectedIdx].x + rect[selectedIdx].Side_lab + 3 < W1 && 
		            rect[selectedIdx].y + rect[selectedIdx].Side_lab + 3 < H1 - 25) {
		            rect[selectedIdx].Side_lab += 3;
		        } else {
		            return;
		        }
		    } else {
		        if(rect[selectedIdx].Side_lab > 5) {
		            rect[selectedIdx].Side_lab -= 3;
		        } else {
		            return;
		        }
		    }
		    
		    repaint();
		}


		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch (keyCode) {
			case KeyEvent.VK_F1:
				setTitle("[과제 #1] 사각형1 선택 됨");
				selectedIdx = 0;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i)
						{lab[i].setForeground(Color.RED);
						}
					else { 
						lab[i].setForeground(Color.BLUE);
						}
					}
				break;
			case KeyEvent.VK_F2:
				setTitle("[과제 #1] 사각형2 선택 됨");
				selectedIdx = 1;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{
						lab[i].setForeground(Color.BLUE);
					}
				}
				break;
			case KeyEvent.VK_F3:
				setTitle("[과제 #1] 사각형3 선택 됨");
				selectedIdx = 2;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{
						lab[i].setForeground(Color.BLUE);
					}
				}
				break;
			case KeyEvent.VK_F4:
				setTitle("[과제 #1] 사각형4 선택 됨");
				selectedIdx = 3;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{
						lab[i].setForeground(Color.BLUE);
					}
				}
				break;
			case KeyEvent.VK_UP:
				if(selectedIdx != -1) {
					if(rect[selectedIdx].y > 1) {
						rect[selectedIdx].y -= 1;
					}
				}
				break;
			case KeyEvent.VK_DOWN:
			    if(selectedIdx != -1) {
			        if(rect[selectedIdx].y < H1 - rect[selectedIdx].Side_lab-25) {
			            rect[selectedIdx].y += 1;
			        }
			    }
				break;
			case KeyEvent.VK_LEFT:
				if(selectedIdx != -1) {
					if(rect[selectedIdx].x > 0) {
						rect[selectedIdx].x -= 1;
					}
				}
				break;
			case KeyEvent.VK_RIGHT:
			    if(selectedIdx != -1) {
			        if(rect[selectedIdx].x < W1 - rect[selectedIdx].Side_lab) {
			            rect[selectedIdx].x += 1;
			        }
				}
				break;
			default:
				break;
			}
			
			repaint();
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {		
		}	
	}
}
