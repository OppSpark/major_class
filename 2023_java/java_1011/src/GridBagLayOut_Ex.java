import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GridBagLayOut_Ex extends JFrame{
		private static JFrame fr;
		
	
	public  GridBagLayOut_Ex() {
		super("GridBag Laayout Manage Example");
		fr = this;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;   // 크기를 조절 할 때 안쪽 컴포넌트가 어떻게 변하는지
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		//gc.insets = new Insets(5, 5, 5, 5);
		
		
		
		
		addComponent(new JButton("button 1"), 0, 0, 1, 2, gc);
		addComponent(new JButton("button 2"), 1, 0, 1, 1, gc);
		gc.ipadx = 80;
		addComponent(new JButton("button 3"), 1, 0, 1, 1,  gc);
		gc.ipadx = 0;
		addComponent(new JButton("button 4"), 3, 0, 1, 2,  gc);
		gc.ipadx = 80;
		addComponent(new JButton("button 5"), 1, 1, 2, 1,  gc);
		gc.ipadx = 0;
		
		gc.insets = new Insets(5, 10, 0, 10);
		addComponent(new JButton("button 6"), 0, 2, 4, 1,  gc);
		
		
		setPreferredSize(new Dimension(500, 300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		
		new GridBagLayOut_Ex();
	}
	
	public static void addComponent(JComponent comp, int x, int y ,int width , int height, GridBagConstraints gc) {
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		
		fr.add(comp, gc);
	}

}
