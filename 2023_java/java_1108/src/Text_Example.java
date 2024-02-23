import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboPopup;

public class Text_Example extends JFrame {
	private static JTextField input = new JTextField(30);
	private static JTextArea output = new JTextArea(14, 30);
	private static int idx = 1;
	public Text_Example() {
		super("TEXT Field/Area Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		setLayout(new FlowLayout());
		JTextField fd;
		
		
		
		add(fd = new JTextField("이름", 4));
		fd.setEditable(false);
		fd.setBorder(null);
		fd.setHorizontalAlignment(JTextField.CENTER);
		add(input);
		input.addActionListener(new MyHandler());
		input.addKeyListener(new MyHandler());
		
		add(fd = new JTextField("리스트", 4));
		fd.setEditable(false);
		fd.setBorder(null);
		fd.setHorizontalAlignment(JTextField.CENTER);
		add(new JScrollPane(output));
		output.setEditable(false);
		output.addKeyListener(new MyHandler());
		
		
		
		
		
		
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
			output.append("["+(idx++)+"]"+input.getText()+ "\n");
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
						output.append("["+i+"]"+strs[i]+ "\n");
					}
				}
				break;
			case KeyEvent.VK_F3:
				
				if(strs.length > 0) {
				output.setText(null);
					for(int i=0;i < strs.length-1; i++) {
						output.append("["+(i+1)+"]"+strs[i]+ "\n");
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
