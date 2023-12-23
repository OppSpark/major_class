import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HW2 extends JFrame {
	private static ImageIcon O = new ImageIcon("O.png"), X = new ImageIcon("X.png");
	private static ImageIcon Os = new ImageIcon("Os.png"), Xs = new ImageIcon("Xs.png");
	private static ImageIcon Or = new ImageIcon("Or.png"), Xr = new ImageIcon("Xr.png");
	private static MyButton Btn[][] = new MyButton[3][3], curBtn = null;
	private static JLabel infoLab = new JLabel("다음 차례는 O", JLabel.CENTER);
	private static boolean nextO = true;
	private static int Xcnt = 0, Ocnt = 0;
	private boolean ox_key = true;
	public HW2() {
		super("Tic Tac Toe Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(1,2));
		JPanel	msgPan = new JPanel(new GridLayout(0, 1)), bordPan = new JPanel(new GridLayout(3, 3));
		infoLab.setFont(new Font("그래픽", Font.BOLD, 34));
		infoLab.setBackground(Color.blue);
		infoLab.setForeground(Color.white);
		infoLab.setOpaque(true);
		
		msgPan.add(infoLab);
		add(msgPan, BorderLayout.NORTH);
		add(bordPan, BorderLayout.CENTER);
		
		for(int i=0;i < 3;i++) 
			for(int j=0;j < 3;j++) {
				Btn[i][j] = new MyButton(i, j);
				Btn[i][j].setBackground(Color.white);
				Btn[i][j].setFocusPainted(false);
				Btn[i][j].addActionListener(new MyHandler());
				Btn[i][j].addKeyListener(new MyHandler());
				bordPan.add(Btn[i][j]);
			}
		
		
		
		addKeyListener(new MyHandler());
		setPreferredSize(new Dimension(500, 500));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setFocusable(true);
		requestFocus();
	}
	public static void main(String[] args) {
		new HW2();
	}

	private class MyHandler implements ActionListener, KeyListener{
		
			
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MyButton btn = (MyButton) e.getSource();
			
			
			ox_key = false; //OX 입력 비허용
			if(btn.getIcon() == null) {
			
			if(nextO) {
				btn.setIcon(O);
				//btn.setPressedIcon(Os);
				//btn.setRolloverIcon(Or);
			}
			else {
				btn.setIcon(X);
				//btn.setPressedIcon(Xs);
				//btn.setRolloverIcon(Xr);
			}
			nextO = !nextO;
			
			infoLab.setText("다음 차례는 "+ ( (nextO) ? "O":"X"));
			checkGameStatus();
			}

			
		}
		

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			
			switch (keyCode) {
			case KeyEvent.VK_ESCAPE:
				for(int i=0;i < 3;i++) {
					for(int j=0;j < 3;j++) {
						Btn[i][j].setIcon(null);
						Btn[i][j].setBackground(Color.white);
					}
				}
				curBtn = null;
				resetGame();

			case KeyEvent.VK_O:
				if(ox_key == true) {
				nextO = false;
				nextO = !nextO;
				infoLab.setText("다음 차례는 "+ ( (nextO) ? "O":"X"));
				}
				break;
			case KeyEvent.VK_X:
				if(ox_key == true) {
				nextO = true;
				nextO = !nextO;
				infoLab.setText("다음 차례는 "+ ( (nextO) ? "O":"X"));
				break;
				}
				/*
			case KeyEvent.VK_UP:
				if(curBtn.row == 0)
					break;
				curBtn.SwapIcon(Btn[curBtn.row - 1][curBtn.col]);
				curBtn.setBackground(Color.white);
				curBtn = Btn[curBtn.row - 1][curBtn.col];
				curBtn.setBackground(Color.yellow);
				curBtn.requestFocus();
				break;
			case KeyEvent.VK_DOWN:
			    if (curBtn.row == 2)
			        break;
			    curBtn.SwapIcon(Btn[curBtn.row + 1][curBtn.col]);
			    curBtn.setBackground(Color.white);
			    curBtn = Btn[curBtn.row + 1][curBtn.col];
			    curBtn.setBackground(Color.yellow);
			    curBtn.requestFocus();
				break;
			case KeyEvent.VK_LEFT:
				if(curBtn.col == 0)
					break;
				curBtn.SwapIcon(Btn[curBtn.row][curBtn.col - 1]);
				curBtn.setBackground(Color.white);
				curBtn = Btn[curBtn.row][curBtn.col - 1];
				curBtn.setBackground(Color.yellow);
				curBtn.requestFocus();
				break;
				
			case KeyEvent.VK_RIGHT:
				if(curBtn.col == 2)
					break;
				curBtn.SwapIcon(Btn[curBtn.row][curBtn.col + 1]);
				curBtn.setBackground(Color.white);
				curBtn = Btn[curBtn.row][curBtn.col + 1];
				curBtn.setBackground(Color.yellow);
				curBtn.requestFocus();
				break;
				*/
			default:
				break;
			}
			
			
		}
		
		private void checkGameStatus() {
            // 가로 체크
            for (int i = 0; i < 3; i++) {
                if (Btn[i][0].getIcon() != null && Btn[i][0].getIcon().equals(Btn[i][1].getIcon()) && Btn[i][1].getIcon().equals(Btn[i][2].getIcon())) {
                    showWinner(Btn[i][0].getIcon());
                    return;
                }
            }
            
            // 세로 체크
            for (int j = 0; j < 3; j++) {
                if (Btn[0][j].getIcon() != null && Btn[0][j].getIcon().equals(Btn[1][j].getIcon()) && Btn[1][j].getIcon().equals(Btn[2][j].getIcon())) {
                    showWinner(Btn[0][j].getIcon());
                    return;
                }
            }
            
            // 대각선 체크
            if (Btn[0][0].getIcon() != null && Btn[0][0].getIcon().equals(Btn[1][1].getIcon()) && Btn[1][1].getIcon().equals(Btn[2][2].getIcon())) {
                showWinner(Btn[0][0].getIcon());
                return;
            }
            if (Btn[0][2].getIcon() != null && Btn[0][2].getIcon().equals(Btn[1][1].getIcon()) && Btn[1][1].getIcon().equals(Btn[2][0].getIcon())) {
                showWinner(Btn[0][2].getIcon());
                return;
            }
            
            // 무승부 체크
            boolean isDraw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Btn[i][j].getIcon() == null) {
                        isDraw = false;
                        break;
                    }
                }
            }
            
            if (isDraw) {
                showDraw();
            }
            
		}
		//이긴 경우
		private void showWinner(Icon icon) {
            String winner = (icon.equals(O)) ? "O" : "X";
            
            if(winner == "O") {
            	Ocnt++;
            }else {
            	Xcnt++;
            }
            infoLab.setText("[O:X] = ["+Ocnt+":"+Xcnt+"] "+winner+"가 승리함");
           setEnabled(false);
           
            
            
        }
        
       //무승부
        private void showDraw() {
            infoLab.setText("[O:X] = ["+Ocnt+":"+Xcnt+"] 무승부이다.");
            setEnabled(false);
        }
        //게임 초기화
        private void resetGame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Btn[i][j].setIcon(null);
                    setEnabled(true);  //버튼 허용
                    ox_key = true; 	// OX 변경 허용
                    
                }
            }
        }
        

		@Override
		public void keyReleased(KeyEvent e) {
		}
		
	}
	private class MyButton extends JButton {
		int		row, col;
		
		public MyButton(int r, int c) {
			row = r; col = c;
		}
	}
}