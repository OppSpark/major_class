import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboPopup;

public class Text_Example extends JFrame {
	private static JTextField input = new JTextField(28);
	private static JTextArea output = new JTextArea(10, 28);
	private static JList<String> list;
	private static String[] cols = {"blue","black","pink","red"};
	private static int idx = 1;
	public Text_Example() {
		super("TEXT Field/Area Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		setLayout(new BorderLayout());
		JTextField fd;
		JPanel p1 = new JPanel(new FlowLayout()), p2 = new JPanel(new GridLayout(0,1));
		JButton btn = new JButton("선택");
		
		list = new JList<>(cols);
		p2.add(list);
		p2.add(btn);
		btn.addActionListener((e) -> {
			Vector<String> vs = new Vector<>(Arrays.asList(cols));
			String[]  strs = output.getText().split("\\n");
			if(strs.length > 0) {
			output.setText(null);
				for(int i=0;i < strs.length; i++) {
					vs.add(strs[i]);
				}
				list.setListData(vs);
			}
			
		});
		
		p1.add(fd = new JTextField("이름", 4));
		fd.setEditable(false);
		fd.setBorder(null);
		fd.setHorizontalAlignment(JTextField.CENTER);
		p1.add(input);
		input.addActionListener(new MyHandler());
		input.addKeyListener(new MyHandler());
		
		p1.add(fd = new JTextField("리스트", 4));
		fd.setEditable(false);
		fd.setBorder(null);
		fd.setHorizontalAlignment(JTextField.CENTER);
		p1.add(new JScrollPane(output));
		output.setEditable(false);
		output.addKeyListener(new MyHandler());
		
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.EAST);
		
		
		
		
		setPreferredSize(new Dimension(450, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Text_Example();

	}
	private class MyHandler implements ActionListener,KeyListener{

		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			output.append(input.getText()+ "\n");
			input.setText(null);
		}

		
	

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			String[]  strs = output.getText().split("\\n");
			
			switch(keyCode) {
			case KeyEvent.VK_ESCAPE:
				output.setText(null);
				input.setText(null);
				idx = 1;
				break;
			case KeyEvent.VK_F2:
				if(strs.length > 0) {
				output.setText(null);
					for(int i=1;i < strs.length-1; i++) {
						output.append(strs[i]+ "\n");
					}
				}
				break;
			case KeyEvent.VK_F3:
				
				if(strs.length > 0) {
				output.setText(null);
					for(int i=0;i < strs.length-1; i++) {
						output.append(strs[i]+ "\n");
					}
				}
				break;
				
			default:
				break;
			}
			
		}
		
		
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}

}
