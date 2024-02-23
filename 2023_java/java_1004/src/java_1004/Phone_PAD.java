package java_1004;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Phone_PAD extends JFrame {
	public static final String[][] btns = {
			{"1","4","7","*"},
			{"2","5","8","0"},
			{"3","6","9","#"},
			{"통화","취소"}
	};
	
		public Phone_PAD() {
			super("Phone key pad");  //윈도우 제목 지정
			setDefaultCloseOperation(EXIT_ON_CLOSE);  //창을 닫을 때 프로세스도 같이닫음
			Container c = getContentPane();
			
			c.setLayout(new BorderLayout(0, 2));
			JPanel jp_num = new JPanel(new GridLayout(0,4)), jp_pad[] = new JPanel[4];
		
		
		
			for(int i=0; i<btns.length; i++) {
				jp_pad[i] = new JPanel(new GridLayout(0,1));
				jp_num.add(jp_pad[i]);
				for(int j=0; j<btns[i].length; j++) {
					jp_pad[i].add(new JButton(btns[i][j]));
				}
			}
			c.add(jp_num);
		
		
		
			pack();  // 컴포넌트의 실제 사이즈에 맞춰서창 크기를 실행해
			setVisible(true); // 이걸 실행해야 창이이 보임
			setLocationRelativeTo(null);  //창을 실행하면 중간에 나
	}
		public static void main(String[] args) {
			new Phone_PAD();

	}

}
