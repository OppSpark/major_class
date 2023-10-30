import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseAction_Ex3 extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener{
   
   private static JButton prevBtn;
   private static Container c;
   
   public MouseAction_Ex3() {
      super("Mouse Event");
      c = getContentPane();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c.setLayout(null);
      
      prevBtn = new JButton("FOLLOW");
      prevBtn.setBounds(0,  0,  100,  30);
      prevBtn.setFocusPainted(false);
      c.add(prevBtn);
      c.addMouseListener(this);
      
      setSize(500, 500);
      setVisible(true);
      setLocationRelativeTo(null);
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new MouseAction_Ex3();

   }
   
   class MyHandler2 extends MouseAdapter {
	   
	   @Override
		public void mouseClicked(MouseEvent e) {  //클릭
			// TODO Auto-generated method stub
			
		}

      @Override
      public void mousePressed(MouseEvent e) {
         int x = e.getX(); int y = e.getY();
         
         
         c.remove(prevBtn);
         prevBtn = new JButton("OK");
         prevBtn.setBounds(x,  y,  100,  30);
         prevBtn.setFocusPainted(false);
         c.add(prevBtn);
         setTitle(String.format("Mouse<%d,%d> Button<%d,%d>", x,y,prevBtn.getX(),prevBtn.getY()));
         c.repaint();
         //press 한 좌표가 나옴
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

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}