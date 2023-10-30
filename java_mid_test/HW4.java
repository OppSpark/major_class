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


public class HW4 extends JFrame {


	private static JTextField outF = new JTextField("0");

	public HW4(String a1){
		super("문제#4");
		ImageIcon img0 = new ImageIcon("0.png");
		ImageIcon img1 = new ImageIcon("1.png");
		ImageIcon img2 = new ImageIcon("2.png");
		ImageIcon img3 = new ImageIcon("3.png");
		ImageIcon img4 = new ImageIcon("4.png");
		ImageIcon img5 = new ImageIcon("5.png");
		ImageIcon img6 = new ImageIcon("6.png");
		ImageIcon img7 = new ImageIcon("7.png");
		ImageIcon img8 = new ImageIcon("8.png");
		ImageIcon img9 = new ImageIcon("9.png");
		ImageIcon imgm = new ImageIcon("minus.png");
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		JPanel outPan = new JPanel(new GridBagLayout());
		
		
		//gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(3, 3, 3, 4);
		gc.ipadx = 150;
		gc.ipady = 20;
		
		
		for(int i = 0; i < a1.length(); i++) {
		
			switch (a1.substring(i,i+1)) {
			case "0" :
				JButton UPbtn = new JButton(img0);
				UPbtn.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn, gc);
				break;
			case "1" :
				JButton UPbtn1 = new JButton(img1);
				UPbtn1.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn1, gc);
				break;
			case "2" :
				JButton UPbtn2 = new JButton(img2);
				UPbtn2.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn2, gc);
				break;
			case "3" :
				JButton UPbtn3 = new JButton(img3);
				UPbtn3.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn3, gc);
				break;
			case "4" :
				JButton UPbtn4 = new JButton(img4);
				UPbtn4.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn4,gc);
				break;
			case "5" :
				JButton UPbtn5 = new JButton(img5);
				UPbtn5.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn5, gc);
				break;
			case "6" :
				JButton UPbtn6 = new JButton(img6);
				UPbtn6.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn6, gc);
				break;
			case "7" :
				JButton UPbtn7 = new JButton(img7);
				UPbtn7.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn7, gc);
				break;
			case "8" :
				JButton UPbtn8 = new JButton(img8);
				UPbtn8.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);

				break;
			case "9" :
				JButton UPbtn9 = new JButton(img9);
				UPbtn9.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtn9, gc);
				break;
			case "-" :
				JButton UPbtnm = new JButton(imgm);
				UPbtnm.setPreferredSize(new Dimension(510, 50));
				add(outPan, BorderLayout.NORTH);
				outPan.add(UPbtnm, gc);
				break;
			
			default:
				break;
			}
	
			
		}

		
		
        
		setPreferredSize(new Dimension(500, 130));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}	
	
public static void main(String[] args) {
	 String W1 = new String(args[0]);
		new HW4(W1);

}
}