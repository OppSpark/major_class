import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic_Ex extends JFrame{
	public Graphic_Ex() {
		super("Graphic Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()){
				case KeyEvent.VK_SPACE:
					repaint();
					break;
				
				}
			}
		});
		
		
		
		
		
		
		
		
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graphic_Ex();

	}
	private class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i < 10; i++) {
				g.setColor(new Color(Rand.r(0,255),Rand.r(0,255),Rand.r(0,255)));
			
				switch (Rand.r(1,3)) {
				case 1:
					g.drawRect(Rand.r(0,300),Rand.r(0,300),Rand.r(1,3)*100, Rand.r(1,3)*100);
					
					break;
				case 2:
					g.drawOval(Rand.r(0,300),Rand.r(0,300),Rand.r(1,3)*100, Rand.r(1,3)*100);
				case 3:
					g.setFont((new Font("Arial", Font.BOLD, Rand.r(20,50))));
					g.drawString("Hello", Rand.r(0,300), Rand.r(0,300));
					break;
					

				default:
					break;
				}
			}
			
			
			
			
			g.setColor(Color.red);
			g.drawRect(50, 50, 200, 200);
			g.setColor(Color.blue);
			g.drawOval(100, 100, 200, 200);
			g.setColor(Color.pink);
			g.drawOval(100, 100, 200, 1100);
		}
	}

}
