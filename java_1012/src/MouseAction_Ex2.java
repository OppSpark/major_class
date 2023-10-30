import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseAction_Ex2 extends JFrame {
	
	private static JButton btn;
	private static Container c;
	public MouseAction_Ex2() {
		super("Mouse Event");
		Container c = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		btn = new JButton("FOLLOW");
		btn.setBounds(0,0,120,30);
		btn.setFocusPainted(false);
		c.add(btn);
		c.addMouseListener(new MyHandler2());
		
		setSize(500,500);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	
	public static void main(String[] args) {
		new MouseAction_Ex2();
		
	}
	
	class MyHandler2 extends MouseAction_Ex2{

		@Override
		public void mouseClicked(MouseEvent e) {  //클릭
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); int y = e.getY();
			JButton b = new JButton("OK");
			b = new JButton("FOLLOW");
			b.setBounds(x,y,120,30);
			b.setFocusPainted(false);
			c.add(b);
			
			setTitle(String.format("Mouse<%d,%d> Button<%d,%d>", x,y,btn.getX(),btn.getY()));
			
			c.repaint();
	         //press 한 좌표가 나옴
	      }

		@Override
		public void mouseReleased(MouseEvent e) {
			/*
			// TODO Auto-generated method stub
			int x = e.getX(); int y = e.getY();
			btn.setLocation(0,0);
			setTitle(String.format("Mouse<%d,%d> Button<%d,%d>", x,y,btn.getX(),btn.getY()));
			*/
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {  //윈도우 프레임 안으
			// TODO Auto-generated method stub
			
		}
		
	}
}