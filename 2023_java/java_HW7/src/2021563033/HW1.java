import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class HW1 extends JFrame{
	private static JSlider xSlider, ySlider;
	//private static JLabel output = new JLabel();
	//private static JTextField output = new JTextField(5);
	private static JLabel icon_ship = new JLabel(new ImageIcon("ship.png"));
	private static JLabel icon_bus = new JLabel(new ImageIcon("bus.png"));
	private static JLabel icon_airplane = new JLabel(new ImageIcon("airplane.png"));
	private static JPanel output;
	private static int img_key = 1;
	private static int x11 = 200, x22= 200, x33 = 200;
	private static int y11 = 200,y22 = 200,y33 = 200;
	private static int x = 200,x2 = 200,x3 = 200;
	private static int y = 200,y2 = 200,y3 = 200;
	
	public HW1() {
		super("[과제 #1] 비행기 선택 됨");
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
		
		addKeyListener(new MyHandler());
		setFocusable(true);
		requestFocus();
		
		setPreferredSize(new Dimension(466,482));
        pack();
        setVisible(true);
        
        icon_ship.setBounds(xSlider.getValue(),ySlider.getValue(),icon_ship.getIcon().getIconWidth(),icon_ship.getIcon().getIconHeight());
        icon_bus.setBounds(xSlider.getValue(),ySlider.getValue(),icon_bus.getIcon().getIconWidth(),icon_bus.getIcon().getIconHeight());
        icon_airplane.setBounds(xSlider.getValue(),ySlider.getValue(),icon_airplane.getIcon().getIconWidth(),icon_airplane.getIcon().getIconHeight());
        
        output.add(icon_ship);
        output.add(icon_bus);
        output.add(icon_airplane);

        setResizable(false);
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
		new HW1();
	}
	private class MyHandler implements ChangeListener,KeyListener{
		
		@Override
		public void stateChanged(ChangeEvent e) {
			
			switch(img_key){
			case 1:
				x = xSlider.getValue();
				y = ySlider.getValue();
				icon_airplane.setLocation(x, output.getHeight() - y);
				requestFocus();
				break;
			
			case 2:
				x2 = xSlider.getValue();
				y2 = ySlider.getValue();
				icon_bus.setLocation(x2, output.getHeight() - y2);
				requestFocus();
				break;
				
			case 3:
				x3 = xSlider.getValue();
				y3 = ySlider.getValue();
				icon_ship.setLocation(x3, output.getHeight() - y3);
				requestFocus();
				break;

			}
		}		
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_F1 :
				
				setTitle("[과제 #1] 비행기 선택 됨");
				
				img_key = 1;

				x11 = xSlider.getValue();
				y11 = (output.getHeight() - y);
				
				x22 = xSlider.getValue();
				y22 = (output.getHeight() - y2);
				
				x33 = xSlider.getValue();
				y33 = (output.getHeight() - y3);
				
				xSlider.setValue(x);
				ySlider.setValue(output.getHeight() - y11);
				
				requestFocus();
				break;
			case KeyEvent.VK_F2:
				
				setTitle("[과제 #1] 버스 선택 됨");
				
				img_key = 2;
				
				x11 = xSlider.getValue();
				y11 = (output.getHeight() - y);
				
				x22 = xSlider.getValue();
				y22 = (output.getHeight() - y2);
				
				x33 = xSlider.getValue();
				y33 = (output.getHeight() - y3);
				
				xSlider.setValue(x2);
				ySlider.setValue(output.getHeight() - y22);
				
				requestFocus();
				break;
			case KeyEvent.VK_F3:
				
				setTitle("[과제 #1] 배 선택 됨");
				
				img_key = 3;
				
				x11 = xSlider.getValue();
				y11 = (output.getHeight() - y);
				
				x22 = xSlider.getValue();
				y22 = (output.getHeight() - y2);
				
				x33 = xSlider.getValue();
				y33 = (output.getHeight() - y3);
				
				xSlider.setValue(x3);
				ySlider.setValue(output.getHeight() - y33);
				
				requestFocus();
				break;
			case KeyEvent.VK_ESCAPE:
				
				switch(img_key){
				case 1:
					x = 0;
					y = 400;
					icon_airplane.setLocation(x, output.getHeight() - y);

					
					requestFocus();
					break;
				
				case 2:
					x2 = 0;
					y2 = 400;
					icon_bus.setLocation(x2, output.getHeight() - y2);
					
;
					requestFocus();
					break;
					
				case 3:
					x3 = 0;
					y3 = 400;
					icon_ship.setLocation(x3, output.getHeight() - y3);
					
					
					requestFocus();
					break;
				}
				break;
			default:
				break;
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
}
