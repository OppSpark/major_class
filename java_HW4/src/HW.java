import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HW extends JFrame{
	
	private static int W, H, R, C;
	private static JButton[][] btn;
	
	public HW(String W1,String H1,String R1 ,String C1) {
		super();
		W = Integer.parseInt(W1);  //받은 인자값을 인티져로 변환 후 W H R C 에 대입함
		H = Integer.parseInt(H1);
		R = Integer.parseInt(R1);
		C = Integer.parseInt(C1);
		
		setTitle("[과제] "+R+"행 "+C+"열 "+"("+W+"X"+H+")");  //타이틀 명을 변경
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton buttons;
		
		btn = new JButton[R][C];
		
		c.setLayout(new BorderLayout());  //큰 틀을 구성
		
		JPanel number_Layout = new JPanel(new GridLayout(R,0)), jp_pad[] = new JPanel[R];   // 이게 문제임 배열의 크기를 초과하면
		JPanel select_Layout = new JPanel(new GridLayout(0,4));
		
		c.setSize(W,H);
		//JPanel num_pad = new JPanel(new GridLayout(R,C));
		//JPanel num_button = new JPanel(new GridLayout(0,1));
		int num_cnt = 0;
		for(int i=0; i < R; i++) {
			jp_pad[i] = new JPanel(new GridLayout(1,0));
			number_Layout.add(jp_pad[i]);
			btn[i] = new JButton[C];
			for(int j = 0; j < C; j++) {
				num_cnt++;
				JButton bt = new JButton(Integer.toString(num_cnt));  // 버튼 생성 
				
				bt.setForeground(new Color(255, 255, 15)); // 버튼 글씨 색상
				bt.setBackground(new Color(0, 76, 154));  //버튼 배경 색상
				bt.setPreferredSize(new Dimension(W,H)); //버튼 사이즈 조절
				bt.addActionListener(new BT_Action());
				
				jp_pad[i].add(bt); 
				
				btn[i][j] = bt;
			}
		}
		// 단 버튼을 구성하코드
		// H는 버턴의 높이를 구성함
		select_Layout.add(buttons = new JButton("홀수"));
		buttons.setPreferredSize(new Dimension(0,H));  
		buttons.addActionListener(new BT_Action());
		
		select_Layout.add(buttons = new JButton("짝수"));
		buttons.addActionListener(new BT_Action());
		
		select_Layout.add(buttons = new JButton("소수"));
		buttons.addActionListener(new BT_Action());
		
		select_Layout.add(buttons = new JButton("초기화"));
		buttons.addActionListener(new BT_Action());
		
		//컨테이너 추가
		c.add(select_Layout,BorderLayout.SOUTH);
		c.add(number_Layout, BorderLayout.NORTH);
	
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class BT_Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			JButton buttons = (JButton) e.getSource();
			String btnName = buttons.getText();  //버튼의 스트링을 받아옴
			
			switch(btnName) {
			case "홀수" :	
				for(int i = 0; i < R; i++) {
			        for(int j = 0; j < C; j++) {
			            int check = i * C + j + 1; // 버튼의 위치에 해당하는 숫자  +1은  배열이 1부터 시작하니
			                boolean isOdd = true;
			                for(int k = 0; k <= check; k++) {
			                    if(check % 2 == 0) {
			                    	isOdd = false;
			                        break;
			                    }
			                }
			                if(isOdd) {
			                	btn[i][j].setBackground(new Color(0, 76, 154));
			                    btn[i][j].setForeground(new Color(255, 255, 150));
			                }else {
			                    btn[i][j].setForeground(new Color(0, 76, 154));
			                    btn[i][j].setBackground(new Color(255, 255, 150));
			                }
			                
			            }
			        }
				setTitle("[과제] "+R+"행 "+C+"열 "+"("+W+"X"+H+") - 홀수만 표시");  //타이틀 명을 변경
				break;
			case "짝수" :
				for(int i = 0; i < R; i++) {
			        for(int j = 0; j < C; j++) {
			            int check = i * C + j + 1;
			                boolean isEven = true;
			                for(int k = 0; k <= check; k++) {
			                    if(check % 2 == 1) {
			                    	isEven = false;
			                        break;
			                    }
			                }
			                if(isEven) {
			                	btn[i][j].setBackground(new Color(0, 76, 154));
			                    btn[i][j].setForeground(new Color(255, 255, 150));
			                }else {
			                	btn[i][j].setForeground(new Color(0, 76, 154));
			                    btn[i][j].setBackground(new Color(255, 255, 150));
			                }
			                
			            }
			        }
				setTitle("[과제] "+R+"행 "+C+"열 "+"("+W+"X"+H+") - 짝수만 표시");  //타이틀 명을 변경
				break;
			case "소수":
				for(int i = 0; i < R; i++) {
			        for(int j = 0; j < C; j++) {
			            int check = i * C + j + 1;
			            if(check <= 1) {
			                // 1은 소수가 아님
			            	btn[i][j].setBackground(new Color(0, 76, 154));
		                    btn[i][j].setForeground(new Color(255, 255, 150));
			            } else {
			                boolean isPrime = true;
			                for(int k = 2; k * k <= check; k++) {
			                    if(check % k == 0) {
			                        isPrime = false;
			                        break;
			                    }
			                }
			                if(isPrime) {
			                	btn[i][j].setBackground(new Color(0, 76, 154));
			                    btn[i][j].setForeground(new Color(255, 255, 150));
			                }else {
			                	btn[i][j].setForeground(new Color(0, 76, 154));
			                    btn[i][j].setBackground(new Color(255, 255, 150));
			                }
			                
			            }
			        }
			    }
				setTitle("[과제] "+R+"행 "+C+"열 "+"("+W+"X"+H+") - 소수만 표시");  //타이틀 명을 변경
			    break;
			case "초기화" :  
				for(int i=0; i < R; i++) {
					for(int j = 0; j < C; j++) {						
						btn[i][j].setForeground(new Color(255, 255, 15));
						btn[i][j].setBackground(new Color(0, 76, 154));
					}
					
				}
				setTitle("[과제] "+R+"행 "+C+"열 "+"("+W+"X"+H+")");  //타이틀 명을 변경
				break;
			default:  //아무것도 안함
				break;
			}
		}
	}
	public static void main(String[] args) {
		String W1 = new String(args[0]);  //인자 값을 스트링으로 받는다.
		String H1 = new String(args[1]);
		String R1 = new String(args[2]);  
		String C1 = new String(args[3]);
		new HW(W1,H1,R1,C1);
	}

}
