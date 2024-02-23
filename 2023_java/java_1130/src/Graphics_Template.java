import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics_Template extends JFrame {
	private static final int WIDTH = 500, HEIGHT = 500;
	private static MyPanel p;
	public Graphics_Template() {
		super("Graphic Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new MyPanel();
		setContentPane(p);
		
				
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Graphics_Template();
	}
	private class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		}
	}
}