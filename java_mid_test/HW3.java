import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class HW3 extends JFrame {


	private static JTextField outF = new JTextField("0");

	public HW3(){
		super("문제#3");
		
		ImageIcon imgup = new ImageIcon("up.png");
		ImageIcon imgdown = new ImageIcon("down.png");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		JPanel outPan = new JPanel(new GridBagLayout());
		
		
		//gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.ipadx = 150;
		gc.ipady = 20;
		
		
		
		outF.setFont(new Font("Arial", Font.BOLD,24));
		outF.setHorizontalAlignment(JTextField.RIGHT);
		outF.setEditable(false);
		outPan.add(outF, gc);
		
		
		JButton UPbtn = new JButton("  ",imgup);
		
		UPbtn.addActionListener(new MyHandler());
		add(outPan, BorderLayout.NORTH);
		outPan.add(UPbtn);
		
		JButton DOWNbtn = new JButton(" ",imgdown);
		DOWNbtn.addActionListener(new MyHandler());
		outPan.add(DOWNbtn);
		
		add(outPan, BorderLayout.NORTH);
		
        
		setPreferredSize(new Dimension(300, 100));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}	
	
public static void main(String[] args) {
		
		new HW3();
	}
class MyHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		String bName =((JButton)e.getSource()).getText();

		switch(bName) {
	
		case"  ":
			int value=Integer.parseInt(outF.getText());
			value=value+1; 
			outF.setText(Integer.toString(value));
			break;
		case" ":
			int value2=Integer.parseInt(outF.getText());
			value2=value2 - 1; 
			outF.setText(Integer.toString(value2));
			break;
		default:
			break;
		}
		
			
		
	}
	
}


}
