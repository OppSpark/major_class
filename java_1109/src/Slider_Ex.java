import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider_Ex extends JFrame{
	private static JSlider xSlider, ySlider;
	//private static JLabel output = new JLabel();
	//private static JTextField output = new JTextField(5);
	private static JLabel icon = new JLabel(new ImageIcon("ship.png"));
	private static JPanel output;
	
	public Slider_Ex() {
		super("JSlider ex");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		output = new JPanel(null);
		
		setLayout(new BorderLayout());
		
		xSlider = new JSlider(JSlider.HORIZONTAL, 0, 400, 200);
		ySlider = new JSlider(JSlider.VERTICAL, 0, 400, 200);
		
		setSlider(xSlider, Color.red, new MyHandler());
		setSlider(ySlider, Color.blue, new MyHandler());
		
		add(xSlider,BorderLayout.SOUTH);
		add(ySlider,BorderLayout.WEST);
		add(output, BorderLayout.CENTER);

		
		
		setPreferredSize(new Dimension(466,482));
        pack();
        setVisible(true);
        icon.setBounds(xSlider.getValue(),ySlider.getValue(),icon.getIcon().getIconWidth(),icon.getIcon().getIconHeight());
        output.add(icon);
        
        setLocationRelativeTo(null);
	}
	private static void setSlider(JSlider jsd,Color col, MyHandler handler) {
	
		jsd.setPaintLabels(true);
		jsd.setPaintTrack(true);
		jsd.setPaintTicks(true);
		jsd.setMajorTickSpacing(50);
		jsd.setMinorTickSpacing(5);
		jsd.setForeground(col);
		jsd.addChangeListener(handler);

		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Slider_Ex();
	}
	private class MyHandler implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		int x = xSlider.getValue(), y = ySlider.getValue();
		icon.setLocation(x, output.getHeight() - y);
		}
	
	}
}
