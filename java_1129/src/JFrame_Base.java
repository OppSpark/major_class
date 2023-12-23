

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class JFrame_Base extends JFrame {
	public JFrame_Base() {
		super("JFrame Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
				
		setPreferredSize(new Dimension(300, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new JFrame_Base();
	}
}
