import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Phone_PAD extends JFrame {
	private static final String[][] btns = {
			{"1","4","7","*"},
			{"2","5","8","0"},
			{"3","6","9","#"},
			{"통화","취소"}
	};
	private static JButton[][] buttons = new JButton[btns.length][];
	private static JTextField resWin = new JTextField("051-663-5140",20);
	private static boolean msgClicked = false;
	

	public Phone_PAD() {
		super("전화 키패드");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton btn;
		c.setLayout(new BorderLayout());
		
		JPanel jp_num = new JPanel(new GridLayout(0,4)), jp_pad[] = new JPanel[4];
		JPanel jp_btm = new JPanel(new GridLayout(0,2)), jp_left = new JPanel(new GridLayout(0,2));
		
		for(int i=0;i < btns.length;i++) {
			jp_pad[i] = new JPanel(new GridLayout(0, 1));
			jp_num.add(jp_pad[i]);
			buttons[i] = new JButton[btns[i].length];
			for(int j=0;j < btns[i].length;j++) {
				jp_pad[i].add(btn = new JButton(btns[i][j]));
				if(btns[i][j].compareTo("0")>= 0 && btns[i][j].compareTo("9") <= 0) {
					btn.addActionListener(new MyAction());
				}
				buttons[i][j] = btn;
			}
		}
		c.add(jp_num,BorderLayout.CENTER);
		jp_left.add(btn = new JButton("연락처"));
		btn.addActionListener(new MyAction());
		
		jp_left.add(btn = new JButton("메시지"));
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				if(msgClicked){btn.setText("메시지");}
				else {btn.setText("Message");}
				msgClicked = !msgClicked;
			}
		});
		jp_btm.add(jp_left);
		jp_btm.add(btn = new JButton("초기화"));
		btn.addActionListener(new MyAction());    //에드 엑션 리스너를 해야 이벤트차 처리됨
		c.add(jp_btm, BorderLayout.SOUTH);
		resWin.setHorizontalAlignment(JTextField.RIGHT);
		resWin.setBackground(Color.BLUE);
		resWin.setForeground(new Color(255,255,51));
		resWin.setMargin(new Insets(10,0,10,0));
		resWin.setEditable(false);
		
		c.add(resWin, BorderLayout.NORTH);
		
		
		
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	class MyAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JButton btn =  (JButton) e.getSource();
			//JFrame root =  (JFrame) btn.getTopLevelAncestor();
			String btnName = btn.getText();
			
			//root.setTitle(root.getTitle()+btnName);
			
			switch(btnName) {
			case "초기화" :
				resWin.setText("");
				break;
				
			case "연락처":
				for(JButton[] btns:buttons)
					for(JButton jb:btns) {
						jb.setBackground(Color.YELLOW);
						jb.setForeground(Color.BLUE);
					}
				break;
				
				default:
					resWin.setText(resWin.getText()+btnName);
					break;
			}
			
		}
	}
	
	public static void main(String[] args) {
		new Phone_PAD();
	}
	
	

}
















