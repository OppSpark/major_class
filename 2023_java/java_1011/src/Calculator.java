import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	private static JTextField outF = new JTextField("0");
	public Calculator(){
		super("계산기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel outPan = new JPanel(new GridBagLayout()),KetPan = new JPanel(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 400;
		outPan.add(outF, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 0;
		outPan.add(new JButton("DEL"), gc);
		
		add(outPan, BorderLayout.NORTH);
		
		
		
		
		
		
		
		setPreferredSize(new Dimension(500, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}	
public static void main(String[] args) {
		
		new Calculator();
	}
}
