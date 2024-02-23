import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider_Ex2 extends JFrame{
	private static JSlider red, green , blue ;
	//private static JLabel output = new JLabel();
	private static JTextField output = new JTextField(5);
	
	
	public Slider_Ex2() {
		super("JSlider ex");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(red = getSlider(Color.red, new MyHandler()));
		add(green = getSlider(Color.green, new MyHandler()));
		add(blue = getSlider(Color.blue, new MyHandler()));
		add(output);		
		output.setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));
		output.setOpaque(true);
		
		setPreferredSize(new Dimension(400,300));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
	}
	private static JSlider getSlider(Color col, MyHandler handler) {
		JSlider jsd = new JSlider(JSlider.HORIZONTAL,0,255,127);
		
		jsd.setPaintLabels(true);
		jsd.setPaintTrack(true);
		jsd.setPaintTicks(true);
		jsd.setMajorTickSpacing(64);
		jsd.setMinorTickSpacing(5);
		jsd.setForeground(col);
		jsd.addChangeListener(handler);
		return jsd;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Slider_Ex2();
	}
	private class MyHandler implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			output.setBackground(new Color(red.getValue(), green.getValue(), blue.getValue()));
			
		}
	
	}
}
