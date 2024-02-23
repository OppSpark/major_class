import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class CheckBox_Ex {

	private static final ImageIcon[] icons = { new ImageIcon("airplane.png"), new ImageIcon("bus.png")};
	private static final ImageIcon[] icons_S = { new ImageIcon("airplane_s.png"), new ImageIcon("bus_s.png")};
	private static final String[] names = {"비행기","버스","배"};
	
	private static JCheckBox[] chkBox = new JCheckBox[icons.length];
	 public class CheckBox_ex extends JFrame{
		 public CheckBox_ex(){
		 super("CheckBOx Example");
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLayout(new GridLayout(0, 3));

		 
		 for(int i=0; i < icons.length;i++) {
			 chkBox[i] = new JCheckBox(names[i], icons[i]);
			 chkBox[i].setBorderPainted(false);
			 chkBox[i].setSelectedIcon(icons_S[i]);
			 chkBox[i].setBackground(Color.white);
			 chkBox[i].setHorizontalAlignment(SwingConstants.CENTER);
			 chkBox[i].addItemListener(new MyHandler());
			 add(chkBox[i]);
			 
		 }
		 
		 
		 //chkBox[i].setSelected(true);
		 setPreferredSize(new Dimension(500, 500));
		 pack();
		 setVisible(true);
		 setLocationRelativeTo(null);
		 
		 }
	 }
	
	private class MyHandler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox chkB = (JCheckBox) e.getItem();
			if(e.getStateChange() == ItemEvent.SELECTED){
				chkB.setBackground(Color.pink);
			}else {
				chkB.setBackground(Color.WHITE);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBox_ex();

	}

}
