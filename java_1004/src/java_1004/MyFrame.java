package java_1004;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	public static final int ROW = 4, COL = 3; //그리드에 사용할 행 렬 변수
	
	public MyFrame() {
		super("Layout Manager Test");  //윈도우 제목 지정
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //창을 닫을 때 프로세스도 같이닫음
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(0, 2)); //그리드 레이아웃을 사용함
		
		
		JPanel jp0 = new JPanel(new GridLayout(0,1));
		JPanel jp1 = new JPanel(new GridLayout(0,3));
		JPanel jp2 = new JPanel(new GridLayout(0,2));
		JPanel jp3 = new JPanel(new GridLayout(0,1));
		
		
		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
		
		
		jp0.add(jp1);jp0.add(jp2);jp0.add(jp3);
		
		
		jp1.add(new JButton("OK"));
		jp1.add(new JButton("IGNORE"));
		jp1.add(new JButton("CALCLE"));
		
		jp2.add(new JButton("EXIT"));
		jp2.add(new JButton("GO"));
		
		jp3.add(new JButton("JAVA"));
		
		
		c.add(new JButton("Software"), BorderLayout.NORTH);
		c.add(new JButton("BABO"), BorderLayout.WEST);
		c.add(jp0, BorderLayout.CENTER);
		c.add(new JButton("Kyungsung"), BorderLayout.SOUTH);
		
		
		
		//그리드 레이아웃은 크기가 다같음
		//보더 레이아웃을 사하면 각기 다르게 할 수 있음
		
		
		
		
		
		
		/*
		for(int i=0; i<ROW; i++) {  //for roof를 이용해 버튼을 생성함
			for(int j=0; j<COL;j++) {
				c.add(new JButton(""+(i+1)));
			}
		}
		*/
		
		
		
		//setSize(300,300);  //제이프레임 창 크기 설정 
		pack();  // 컴포넌트의 실제 사이즈에 맞춰서창 크기를 실행해
		setVisible(true); // 이걸 실행해야 창이이 보임
		setLocationRelativeTo(null);  //창을 실행하면 중간에 나

	}
	public static void main(String[] args) {
		new MyFrame();
		
		
	
	}

}
