import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class HW2 extends JFrame {
    private static int W1, H1;
    private static int selectedIdx = 0;
    private static int maxRectangles = 10;
    private int rectangleCount = 0;
    private MyPanel p;
    private JLabel[] lab = new JLabel[maxRectangles];
    private Rect[] rect = new Rect[maxRectangles];
	private int startX, startY;
    private boolean Re_Make = true, Re_Move = true;
    public int dragStatus = 0;
    private boolean isResizing = false;
    private int resizingIdx = -1;
    public HW2(String WH) {
        super("[과제 #1] 사각형1 선택 됨");
        W1 = Integer.parseInt(WH);
        H1 = Integer.parseInt(WH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(p = new MyPanel());

        p.addMouseListener(new MyMouseAdapter());
		p.addMouseMotionListener(new MyMouseAdapter());
        p.addMouseWheelListener(new MyHandler());
        p.addKeyListener(new MyHandler());

        setSize(W1, H1);
        setVisible(true);
        setLocationRelativeTo(null);
        p.requestFocus();
        
        
    }

    public class MyPanel extends JPanel {
        int x, y, width, height;
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Random Rand1 = new Random();
            
            if (dragStatus == 1) {
                g.drawRect(x, y, width, height);
            }
        

            for (int i = 0; i < rectangleCount; i++) {
                g.drawRect(rect[i].x, rect[i].y, rect[i].side_labs, rect[i].side_labs);
                lab[i].setBounds(rect[i].x + 3, rect[i].y, 55, 15);
            }
        }
    }
    
    
    public class MyMouseAdapter extends MouseInputAdapter {
		int x, y, width, height;
        private int endX, endY;
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();

			if (rectangleCount < maxRectangles) {
				int x = startX;
                int y = startY;


                lab[rectangleCount] = new JLabel("[사각형" + (rectangleCount + 1) + "]");
                lab[rectangleCount].setBounds(x + 3, y, 55, 15);
                lab[rectangleCount].setForeground(Color.BLUE);
                add(lab[rectangleCount]);

                rect[rectangleCount] = new Rect(x, y, 0, lab[rectangleCount]);
                rectangleCount++;

                repaint();
            }
        }

        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);

            if (rectangleCount < maxRectangles) {
                int x = Math.min(startX, endX);
                int y = Math.min(startY, endY);

                int side = Math.max(width, height);

                // 충돌 검사
                boolean collision = false;
                for (int i = 0; i < rectangleCount; i++) {
                    if (i != rectangleCount - 1 && isCollision(x, y, side, rect[i])) {
                        collision = true;
                        break;
                    }
                }

                if (!collision) {
                    rect[rectangleCount - 1] = new Rect(x, y, side, lab[rectangleCount - 1]);
                    repaint();
                }
            }
        }

        private boolean isCollision(int x, int y, int side, Rect other) {
            return !(x > other.x + other.side_labs ||
                     x + side < other.x ||
                     y > other.y + other.side_labs ||
                     y + side < other.y);
        }

        // public void mouseReleased(MouseEvent e) {
		// 	endX = e.getX();
        //     endY = e.getY();
        //     int width = Math.abs(endX - startX);
        //     int height = Math.abs(endY - startY);
        // }
    }
    
   /* class MyMouseAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (rectangleCount < maxRectangles) {
                int side = 50; // 초기 크기를 필요에 따라 조절할 수 있습니다.
                int x = e.getX();
                int y = e.getY();

                for (int i = 0; i < rectangleCount; i++) {
                    if ((x + side < rect[i].x || x > rect[i].x + rect[i].side_labs) ||
                            (y > rect[i].y + rect[i].side_labs || y + side < rect[i].y)) {
                    } else {
                        Re_Make = false;
                    }
                }

                if (Re_Make) {
                    lab[rectangleCount] = new JLabel("[사각형" + (rectangleCount + 1) + "]");
                    lab[rectangleCount].setBounds(x + 3, y, 55, 15);
                    lab[rectangleCount].setForeground(Color.BLUE);
                    add(lab[rectangleCount]);

                    rect[rectangleCount] = new Rect(x, y, side, lab[rectangleCount]);
                    rectangleCount++;
                } else {
                    Re_Make = true;
                }

                repaint();
            }
        }
    }
	*/
	public class Rect{
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
	
	public class MyHandler implements KeyListener, MouseWheelListener{


		@Override
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			
			switch (KeyCode) {
			case KeyEvent.VK_F1:
				setTitle("[과제 #2] 사각형1 선택 됨");
				selectedIdx = 0;
				for(int i=0; i<selectedIdx; i++) {
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
				for(int i=0; i<selectedIdx; i++) {
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
				for(int i=0; i<selectedIdx; i++) {
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
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F5:
				setTitle("[과제 #2] 사각형5 선택 됨");
				selectedIdx = 4;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F6:
				setTitle("[과제 #2] 사각형6 선택 됨");
				selectedIdx = 5;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F7:
				setTitle("[과제 #2] 사각형7 선택 됨");
				selectedIdx = 6;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F8:
				setTitle("[과제 #2] 사각형8 선택 됨");
				selectedIdx = 7;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F9:
				setTitle("[과제 #2] 사각형9 선택 됨");
				selectedIdx = 8;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_F10:
				setTitle("[과제 #2] 사각형10 선택 됨");
				selectedIdx = 9;
				for(int i=0; i<selectedIdx; i++) {
					if(selectedIdx == i) {
						lab[i].setForeground(Color.RED);
					}
					else{lab[i].setForeground(Color.BLUE);
					
					}
				}
				break;
			case KeyEvent.VK_UP:
				if(selectedIdx != -1) {
					for(int i=0; i<selectedIdx; i++) {
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
					for(int i=0; i<selectedIdx; i++) {
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
					for(int i=0; i<selectedIdx; i++) {
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
					for(int i=0; i<selectedIdx; i++) {
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
	        if (selectedIdx != -1) {
	            int wheelRotation = e.getWheelRotation();

	            if (wheelRotation < 0) {
	                // 휠을 위로 돌렸을 때
	                if (rect[selectedIdx].side_labs < Math.min(W1 - getInsets().right - rect[selectedIdx].x, H1 - getInsets().top - getInsets().bottom - rect[selectedIdx].y) - 1) {
	                    // 크기가 최대 크기보다 작은 경우
	                    for (int i = 0; i < rectangleCount; i++) {
	                        if (i != selectedIdx && isCollision(rect[selectedIdx], rect[i])) {
	                            Re_Move = false;
	                            break;  // 충돌이 하나라도 발생하면 루프 종료
	                        }
	                    }

	                    if (Re_Move) {
	                        rect[selectedIdx].side_labs += 1;
	                        setTitle("[과제 #2] 사각형" + (selectedIdx + 1) + " 선택 됨");
	                    } else {
	                        setTitle("[과제 #2] " + (selectedIdx + 1) + "번 사각형 조정 불가");
	                    }
	                }
	            } else {
	                // 휠을 아래로 돌렸을 때
	                if (rect[selectedIdx].side_labs > 5) {
	                    rect[selectedIdx].side_labs -= 1;
	                    setTitle("[과제 #2] 사각형" + (selectedIdx + 1) + " 선택 됨");
	                }
	            }

	            Re_Move = true;
	            repaint();
	        }
	    }

	    private boolean isCollision(Rect r1, Rect r2) {
	        return r1.x < r2.x + r2.side_labs &&
	                r1.x + r1.side_labs > r2.x &&
	                r1.y < r2.y + r2.side_labs &&
	                r1.y + r1.side_labs > r2.y;
	     }
		
		
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}


		
		
	}
}
