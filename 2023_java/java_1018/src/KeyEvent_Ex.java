import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEvent_Ex extends JFrame{
	public static String[] keyNames = {"KeyCode","keyChar","keyText"};
	public static JLabel[] keyAttrs = new JLabel[keyNames.length];
	public KeyEvent_Ex() {
		setTitle("Key Event");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		for(int i =0; i < keyAttrs.length; i++) {
			keyAttrs[i]= new JLabel(keyNames[i], JLabel.CENTER);
			keyAttrs[i].setBounds(80* i + 50,100,60,20);
			keyAttrs[i].setBackground(Color.blue);
			keyAttrs[i].setForeground(Color.white);
			keyAttrs[i].setOpaque(true);
			
			add(keyAttrs[i]);
		}
		addKeyListener(new Myhandler());
		requestFocus(true);
		request();
		

		
		setSize(500,300);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		
		new KeyEvent_Ex();
		
	}
	
	private class Myhandler implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int code = e.getKeyCode();
			char kChar = e.getKeyChar();
			
			keyAttrs[0].setText(code+"");
			keyAttrs[1].setText(kChar+"");
			keyAttrs[2].setText(e.getKeyText(code));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
