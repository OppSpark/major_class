import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	static final String[][] names = {
			{"0","1","2","3"},
			{"4","5","6,","7"},
			{"8","9","C","CE"},
			{"+","-","X","/"},
			{"CANCLE","EXIT","SAVE","RESTORE"}
			
	};
	
	public MyFrame() {
		super("스윙 프레임 만들기!!");  // JFram 의 기본 컨스트럭터를 호출 윈도우 타이틀 부분
		setDefaultCloseOperation(EXIT_ON_CLOSE);   //  프로그램 창을 닫으면 프로그램을 종료(프로세스를 종료) 이 문장이 없으면 프로그램 종료시 프로세스는 살아있음
		
		Container c = getContentPane();
		c.setBackground(Color.cyan);
		//c.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		//c.setLayout(new GridLayout(names.length,names[0].length,10,10));
		c.setLayout(new BorderLayout());
		//c.setLayout(null);  //만역 null 로 하면 버튼을 지정 할 때 좌표를 지정해야함
		
		c.add(new JButton("HELLO"),BorderLayout.CENTER);
		c.add(new JButton("OK"),BorderLayout.WEST);
		c.add(new JButton("CANCLE"),BorderLayout.EAST);
		c.add(new JButton("SAVE"),BorderLayout.SOUTH);
		c.add(new JButton("RESTORE"),BorderLayout.NORTH);
		
		
		
		
		
		/*
		c.add(new JButton("OK"));
		c.add(new JButton("Cancle"));
		c.add(new JButton("EXIT"));
		*/
		
		
		/*
		for(String[] sa : names) {
			for(String n : sa) {
				c.add(new JButton(n));
				
				
			}
		}
		*/
		setSize(500,300);  //윈도우즈 창 크기 조정
		setResizable(false);  // 창 크기를 조절 가능하게 하는 것 True , faslse
		setVisible(true);  //창을 보이게 하는것.
		setLocationRelativeTo(null);  //화면을 켜면 정 중앙에서 실행됨  없으면 위치가 달라
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}