
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEvent_Ex extends JFrame {
	private static String AttrNames[] = {"KeyCode", "KeyChar", "KeyText"};
	private static JLabel KeyAttrs[] = new JLabel[AttrNames.length];
	public KeyEvent_Ex() {
		super("Key Event Handling");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container	c = getContentPane();
		int		x=100;
		c.setLayout(null);
		
		for(int i=0;i < AttrNames.length;i++) {
			KeyAttrs[i] = new JLabel(AttrNames[i], JLabel.CENTER);
			KeyAttrs[i].setBounds(x*i+90, 100, 60, 20);
			c.add(KeyAttrs[i]);
			KeyAttrs[i].setBackground(Color.blue);
			KeyAttrs[i].setForeground(Color.white);
			KeyAttrs[i].setOpaque(true);
		}
		c.addKeyListener(new MyKeyHandler());
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		setPreferredSize(new Dimension(500, 300));
		pack();
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new KeyEvent_Ex();
	}
	
	class MyKeyHandler implements KeyListener {

		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
			int	Kcode = e.getKeyCode();
			char Kchar = e.getKeyChar();
			
			KeyAttrs[0].setText(""+Kcode);
			KeyAttrs[1].setText(""+Kchar);
			KeyAttrs[2].setText(e.getKeyText(Kcode));
		}
		
	}

}
