import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class List_Example extends JFrame{
	private static JList<String> list1;
	private static String[] colors = {"white","black","red","yellow","blue"};
	private static JTextArea output = new JTextArea(5,10);
	
	public List_Example() {
		super("JList Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setLayout(new FlowLayout());
	
		JButton btn = new JButton("선택");
		
		list1 = new JList<>(colors);
		add(list1);
		add(btn);
		btn.addActionListener(new MyHandler());
		add(output);
		
		
		
		
		
		setPreferredSize(new Dimension(450, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}

	
	
	
	
	public static void main(String args[]) {
		new List_Example();
		
	}
	
	
	private class MyHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			output.setText(null);
			for(int i:list1.getSelectedIndices()) {
				output.append(colors[i]+"\n");
			}
			
		}
		
}}
