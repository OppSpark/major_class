
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Arrays;
import java.util.Random;

import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class HW2 extends JFrame{
	private static int W1, H1;
	private static int selectedIdx = 0;
	private MyPanel p;
	private JLabel[] lab = new JLabel[4];
	private Rect[] rect = new Rect[4];
	private boolean Re_Make = true, Re_Move = true;

	public HW2(String WH) {
		super("[과제 #1] 사각형1 선택 됨");
		W1 = Integer.parseInt(WH);
		H1 = Integer.parseInt(WH);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(p = new MyPanel());
	
		p.addKeyListener(new MyHandler());
		p.addMouseWheelListener(new MyHandler());
		
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
					g.drawRect(rect[i].x, rect[i].y, rect[i].side_labs, rect[i].side_labs);
					lab[i].setBounds(rect[i].x+3, rect[i].y, 55, 15);
				}
			}else {
				for(int i=0; i<4; i++) {
					int side = Rand1.nextInt(W1-25<H1-50?W1-25:H1-50)+1;
					int x = Rand1.nextInt(W1-15-side), y = Rand1.nextInt(H1-40-side)+1;
					
					for(int j=0; j<i; j++) {
						if((x+side < rect[j].x || x > rect[j].x+rect[j].side_labs) ||
								(y > rect[j].y+rect[j].side_labs || y+side < rect[j].y)) {
						}else Re_Make = false;
					}
					
					if(Re_Make) {
						lab[i] = new JLabel("[사각형"+(i+1)+"]");
						lab[i].setBounds(x+3, y, 55, 15);
						lab[i].setForeground(Color.BLUE);
						add(lab[i]);
						
						g.drawRect(x, y, side, side);
						rect[i] = new Rect(x, y, side, lab[i]);
					}else {
						Re_Make = true;
						i--;
					}
				}
			}
		}
	}
	
	class Rect{
		JLabel lab;
		int x, y, side_labs;
		public Rect(int x, int y, int side, JLabel lab) {
			this.x = x; this.y = y;  
			this.side_labs = side; this.lab = lab;
		}
	}
	
	
	public static void main(String[] args) {
		if(args.length == 1) {
			String W = new String(args[0]); 

			new HW2(W);
		}else{
			System.out.println("인자값이 잘못되었습니다.");
		}
	}
	
	class MyHandler implements KeyListener, MouseWheelListener{


		@Override
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			
			switch (KeyCode) {
			case KeyEvent.VK_F1:
				setTitle("[과제 #2] 사각형1 선택 됨");
				selectedIdx = 0;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else { lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F2:
				setTitle("[과제 #2] 사각형2 선택 됨");
				selectedIdx = 1;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F3:
				setTitle("[과제 #2] 사각형3 선택 됨");
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
				setTitle("[과제 #2] 사각형4 선택 됨");
				selectedIdx = 3;
				for(int i=0; i<4; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_UP:
				if(selectedIdx != -1) {
					for(int i=0; i<4; i++) {
						if(i != selectedIdx) {
							int x1 = rect[selectedIdx].x, x2 = rect[selectedIdx].x+rect[selectedIdx].side_labs;
							int y1 = rect[selectedIdx].y, y2 = rect[selectedIdx].y+rect[selectedIdx].side_labs;
							int x3 = rect[i].x, x4 = rect[i].x+rect[i].side_labs;
							int y3 = rect[i].y, y4 = rect[i].y+rect[i].side_labs;
							
							if(((x1<x4 && x4<x2)||(x1<x3 && x3<x2)||(x1<x3 && x4<x2)||(x3<x1 && x2<x4))&& y4==y1) Re_Move = false;
						}
					}
		
					if(Re_Move) { 
						if(rect[selectedIdx].y > 1) {rect[selectedIdx].y -= 1; 
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
						}
					}else setTitle("[과제 #2] "+(selectedIdx+1)+"번 사각형 조정 불가");
				}
				break;
			case KeyEvent.VK_DOWN:
				if(selectedIdx != -1 && rect[selectedIdx].y + rect[selectedIdx].side_labs < H1 - getInsets().top - 1) {
					for(int i=0; i<4; i++) {
						if(i != selectedIdx) {
							int x1 = rect[selectedIdx].x, x2 = rect[selectedIdx].x+rect[selectedIdx].side_labs;
							int y1 = rect[selectedIdx].y, y2 = rect[selectedIdx].y+rect[selectedIdx].side_labs;
							int x3 = rect[i].x, x4 = rect[i].x+rect[i].side_labs;
							int y3 = rect[i].y, y4 = rect[i].y+rect[i].side_labs;
							
							if(((x1<x3 && x3<x2)||(x3<x1 && x1<x4)||(x1<x3 && x4<x2)||(x3<x1 && x2<x4))&& y2==y3) Re_Move = false;
						}
					}
					
					if(Re_Move) {
						rect[selectedIdx].y += 1;
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
					}
					else setTitle("[과제 #2] "+(selectedIdx+1)+"번 사각형 조정 불가");
				}
				break;
			case KeyEvent.VK_LEFT:
				if(selectedIdx != -1) {
					for(int i=0; i<4; i++) {
						if(i != selectedIdx) {
							int x1 = rect[selectedIdx].x, x2 = rect[selectedIdx].x+rect[selectedIdx].side_labs;
							int y1 = rect[selectedIdx].y, y2 = rect[selectedIdx].y+rect[selectedIdx].side_labs;
							int x3 = rect[i].x, x4 = rect[i].x+rect[i].side_labs;
							int y3 = rect[i].y, y4 = rect[i].y+rect[i].side_labs;
							
							if(((y3<y1 && y1<y4)||(y1<y3 && y3<y2)||(y1<y3 && y4<y2)||(y3<y1 && y2<y4))&&x4==x1) Re_Move = false;
						}
					}
					
					if(Re_Move) { 
						if(rect[selectedIdx].x > 0) rect[selectedIdx].x -= 1; 
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
					}else setTitle("[과제 #2] "+(selectedIdx+1)+"번 사각형 조정 불가");
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(selectedIdx != -1 && rect[selectedIdx].x + rect[selectedIdx].side_labs < W1 - 1) {
					for(int i=0; i<4; i++) {
						if(i != selectedIdx) {
							int x1 = rect[selectedIdx].x, x2 = rect[selectedIdx].x+rect[selectedIdx].side_labs;
							int y1 = rect[selectedIdx].y, y2 = rect[selectedIdx].y+rect[selectedIdx].side_labs;
							int x3 = rect[i].x, x4 = rect[i].x+rect[i].side_labs;
							int y3 = rect[i].y, y4 = rect[i].y+rect[i].side_labs;
							
							if(((y3<y1 && y1<y4)||(y1<y3 && y3<y2)||(y1<y3 && y4<y2)||(y3<y1 && y2<y4))&&x2==x3) Re_Move = false;
						}
					}
						
					if(Re_Move) {
						rect[selectedIdx].x += 1;
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
					}else setTitle("[과제 #2] "+(selectedIdx+1)+"번 사각형 조정 불가");
				}
				break;
			default:
				break;
			}
			
			Re_Move = true;
			repaint();
		}
		
		
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
		    if (e.getWheelRotation() < 0) {
		    	if (rect[selectedIdx].side_labs < Math.min(W1 - getInsets().right - rect[selectedIdx].x, H1 - getInsets().top - getInsets().bottom - rect[selectedIdx].y) - 1) {
					for(int i=0; i<4; i++) {
						if(i != selectedIdx) {
							int x1 = rect[selectedIdx].x, x2 = rect[selectedIdx].x+rect[selectedIdx].side_labs;
							int y1 = rect[selectedIdx].y, y2 = rect[selectedIdx].y+rect[selectedIdx].side_labs;
							
							int x3 = rect[i].x, x4 = rect[i].x+rect[i].side_labs;
							int y3 = rect[i].y, y4 = rect[i].y+rect[i].side_labs;
							
							if(((y3<y1 && y1<y4)||(y1<y3 && y3<y2)||(y1<y3 && y4<y2)||(y3<y1 && y2<y4))&&x2==x3) Re_Move = false;
							if(((x1<x3 && x3<x2)||(x3<x1 && x1<x4)||(x1<x3 && x4<x2)||(x3<x1 && x2<x4))&& y2==y3) Re_Move = false;
						}
					}
					
					if(Re_Move) {
						rect[selectedIdx].side_labs += 1;
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
					}else setTitle("[과제 #2] "+(selectedIdx+1)+"번 사각형 조정 불가");
				}else return;
			}else {
				if(rect[selectedIdx].side_labs > 5) {
						rect[selectedIdx].side_labs -= 1; 
						setTitle("[과제 #2] 사각형"+(selectedIdx+1)+" 선택 됨");
				}else return;
			}
			
			Re_Move = true;
			repaint();
		}
		
		
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
	}
}
