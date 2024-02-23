import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NULL_Layout extends JFrame {
	
	private static String[] names = {"학번","성명","학과","학년"};
	private static int WIDTH=300, HEIGHT=200;
	public NULL_Layout() {
		super("Null Layout Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JLabel lab;
		JTextField txt;
		c.setLayout(null);
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		//System.out.printf("(%dx%d), (%dx%d)\n",getWidth(),getHeight(), c.getWidth(), c.getHeight());
		int w = c.getWidth(), h = c.getHeight();
		int compH = h / names.length;
		
		for(int i=0; i<names.length; i++) {
			lab = new JLabel(names[i],JLabel.CENTER);
			lab.setHorizontalAlignment(SwingConstants.LEFT);
			txt = new JTextField();
			lab.setBounds(0, i * compH, w/3, compH);
			txt.setBounds(w/3, i * compH, (int)(w*(2/3.0)), compH);
			
			//c.add(lab = new JLabel(s));

			//c.add(new JTextField(10));
			
			c.add(lab);
			c.add(txt);
		}
		
		repaint();
		
		//setResizable(false);
		//setVisible(true);
		
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		new NULL_Layout();
	}

}
