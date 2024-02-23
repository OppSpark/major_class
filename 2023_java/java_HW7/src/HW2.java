import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HW2 extends JFrame {
    private static int W = 60, H = 50, R, C;
    private static JButton[][] btn;
    private int selectedRow = 0;
    private int selectedCol = 0;
    private int click_i = 0, click_j = 0;
    private boolean select_btn = false;
    
    private int null_btnR = R;
    private int null_btnC = C;
    
    private boolean R_btn = false;
    private boolean C_btn = false;
    
    private int mv_btn;
    

    public HW2(String W1, String H1) {
        super("[과제#2]");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        R = Integer.parseInt(W1);
        C = Integer.parseInt(H1);

        Container c = getContentPane();
        btn = new JButton[R][C];

        c.setLayout(new BorderLayout());

        JPanel number_Layout = new JPanel(new GridLayout(R, 0));
        JPanel[] jp_pad = new JPanel[R];

        c.setSize(W * C, H * R);

        int num_cnt = 0;
        int totalButtons = R * C - 1;
        Random random = new Random();
        int[] numbers = new int[totalButtons];

        // 버튼의 순서를 랜덤하게 설정
        for (int i = 0; i < totalButtons; i++) {
            numbers[i] = i + 1;
        }
        for (int i = totalButtons - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        for (int i = 0; i < R; i++) {
            jp_pad[i] = new JPanel(new GridLayout(1, 0));
            number_Layout.add(jp_pad[i]);
            btn[i] = new JButton[C];
            for (int j = 0; j < C; j++) {
                num_cnt++;
                if (num_cnt <= totalButtons) {
                    JButton bt = new JButton(Integer.toString(numbers[num_cnt - 1]));
                    bt.setBackground(new Color(255, 255, 150));
                    bt.setForeground(new Color(0, 76, 154));
                    
                    bt.setPreferredSize(new Dimension(W, H));
                    bt.addActionListener(new MyHandler());
                    bt.addKeyListener(new MyHandler());
                    jp_pad[i].add(bt);
                    
                    btn[i][j] = bt;
                    
                } else {
                    JButton emptyButton = new JButton();
                    emptyButton.setBackground(Color.WHITE);
                    emptyButton.setForeground(new Color(0, 76, 154));
                    emptyButton.setPreferredSize(new Dimension(W, H));
                    emptyButton.addActionListener(new MyHandler());
                    emptyButton.addKeyListener(new MyHandler());
                    jp_pad[i].add(emptyButton);
                    btn[i][j] = emptyButton;
                    
                }
            }
        }

        null_btnR = R - 1;
        null_btnC = C - 1;
        c.add(number_Layout);

        pack();
        setVisible(true);
        setFocusable(true);
        requestFocus();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        String W1 = new String(args[0]);
        String H1 = new String(args[1]);
        new HW2(W1, H1);
    }
    
    private class MyHandler implements ActionListener, KeyListener{ 	
		
    	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			String tempText = btn[click_i][click_j].getText(); // 클릭한 버튼의 텍스트 임시 저장
			switch (keyCode) {
		    case KeyEvent.VK_UP:
		        // 위로 이동
		    	btn[null_btnR][null_btnC].setBackground(new Color(255, 255, 150));
		    	for(int i = 0 ; i<=R;i++) {
		    		up();
		    	}
		    	btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		        break;
		    case KeyEvent.VK_DOWN:
		        // 아래로 이동
		    	btn[null_btnR][null_btnC].setBackground(new Color(255, 255, 150));
		    	for(int i = 0 ; i<=R;i++) {
		    		down();
		    	}
		    	btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		        break;
		    case KeyEvent.VK_LEFT:
		        // 왼쪽으로 이동
		    	btn[null_btnR][null_btnC].setBackground(new Color(255, 255, 150));
		    	for(int i = 0 ; i<=C;i++) {
		    		left();
		    		
		    	}
		    	btn[null_btnR][null_btnC].setBackground(Color.WHITE);
			        
		    	
		        break;
		    case KeyEvent.VK_RIGHT:
		        // 오른쪽으로 이동
		    	btn[null_btnR][null_btnC].setBackground(new Color(255, 255, 150));
		    	for(int i = 0 ; i<=C;i++) {
		    		right();
		    		
		    	}
		    	btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		    	
		    	
		        break;
		    default:
		        break;
		}




			
		}
		public void actionPerformed(ActionEvent e) {
		    JButton clickedButton = (JButton) e.getSource();
		    
		    String btnName = clickedButton.getText();
		    if(clickedButton.getText().equals("")) {
		    	btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		    	
		    }else {
		    setTitle("[과제#2] " +clickedButton.getText()+" 선택 됨");

		    if(select_btn == false) {
		    select_btn = true;
		    btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		    clickedButton.setBackground(new Color(210,20,17));
		    clickedButton.setForeground(new Color(255,175,176));
		    for (int i = 0; i < R; i++) {
		        for (int j = 0; j < C; j++) {
		            if (clickedButton == btn[i][j]) {
		                // 버튼의 배열값 출력
		            	click_i = i;
		            	click_j = j;
		                btn[null_btnR][null_btnC].setBackground(Color.WHITE);
		                return;
		            }
		        }
		    }
		    }else {
	    	
		    btn[null_btnR][null_btnC].setBackground(Color.WHITE);
	    	 btn[click_i][click_j].setBackground(new Color(255, 255, 150));
	    	 btn[click_i][click_j].setForeground(new Color(0, 76, 154));
	    	 clickedButton.setBackground(new Color(210,20,17));
			 clickedButton.setForeground(new Color(255,175,176));

			    for (int i = 0; i < R; i++) {
			        for (int j = 0; j < C; j++) {
			            if (clickedButton == btn[i][j]) {
			                // 버튼의 배열값 출력
			            	click_i = i;
			            	click_j = j;
			                btn[null_btnR][null_btnC].setBackground(Color.WHITE);
			                return;
			            }
			        }
			    }
		    
		    }

		}
		}

		
		public void up() {
			 for (int i = click_i - 1; i >= 0; i--) {
		            if (btn[i][click_j].getText().equals("")) {
		                // 빈 버튼이 있을 때
		                btn[i][click_j].setText(btn[i + 1][click_j].getText());
		                btn[i + 1][click_j].setText("");
		                
		                null_btnR = i+1;
		                
		                

		            }
		        }
		}

		
		public void down() {
			for (int i = click_i + 1; i < R; i++) {
	            if (btn[i][click_j].getText().equals("")) {
	                // 빈 버튼이 있을 때
	                btn[i][click_j].setText(btn[i - 1][click_j].getText());
	                btn[i - 1][click_j].setText("");
	                
	                null_btnR = i -1;

	            }
	        }
		}
		
		public void left() {
			 for (int j = click_j - 1; j >= 0; j--) {
		            if (btn[click_i][j].getText().equals("")) {
		                // 빈 버튼이 있을 때
		                btn[click_i][j].setText(btn[click_i][j + 1].getText());
		                btn[click_i][j + 1].setText("");
		                
		                null_btnC = j +1;
		                

		            }
		        }
	        
		}
		
		public void right() {
			
			for (int j = click_j + 1; j < C; j++) {
	            if (btn[click_i][j].getText().equals("")) {
	            	
	                // 빈 버튼이 있을 때
	                btn[click_i][j].setText(btn[click_i][j - 1].getText());
	                btn[click_i][j - 1].setText("");
	                
	                null_btnC = j -1;

	            }
	        }
		}
		
		
		
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
		
		
		@Override
		public void keyTyped(KeyEvent e) {
		}

    	
    }
    
}



