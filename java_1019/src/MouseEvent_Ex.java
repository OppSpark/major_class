import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEvent_Ex extends JFrame{
   public static Container c;
   public static JLabel infoLab = new JLabel("()", JLabel.CENTER), cursor = new JLabel("()", JLabel.LEFT);
   public static JLabel F1 = new JLabel(), F2 = new JLabel();
		   
   public static final int LAB_WIDTH = 160, LAB_HEIGHT = 20, WIDTH = 500, HEIGHT = 500;
   
   public int x, y;
   public static ImageIcon Car = new ImageIcon("car.png"), F1img = new ImageIcon("airPlane.png"),F2img = new ImageIcon("ship.png");
   
   public MouseEvent_Ex() {
      super("()");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      c = getContentPane();
      c.setLayout(null);
      
      
      
      infoLab.setBounds((c.getWidth()-LAB_WIDTH)/2, 20, LAB_WIDTH, LAB_HEIGHT);
      infoLab.setBackground(Color.blue);
      infoLab.setForeground(Color.white);
      infoLab.setOpaque(true);
      // 불투명하게
      
      
      cursor.setBounds(0, 0, LAB_WIDTH, LAB_HEIGHT);
      

      c.addMouseListener(new MyHandler());
      c.addMouseMotionListener(new MyHandler());
      c.addMouseWheelListener(new MyHandler());
      c.addKeyListener(new MyHandler());
      
      
   
      c.add(infoLab);
      c.add(cursor);
     
      
      F1.setBounds(0, 0,F1img.getIconWidth(),F1img.getIconHeight());
      
      c.add(F1);
      c.add(F2);
      c.setFocusable(true);
      c.requestFocus();
      setLocationRelativeTo(null);
   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new MouseEvent_Ex();
   }
   
   private class MyHandler implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
         infoLab.setText(String.format("Wheel Moved (%d)", e.getWheelRotation()));
         
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         x = e.getX();
         y = e.getY();
         
         infoLab.setText(String.format("Mouse Dragged(%d, %d)", x,y));
         cursor.setBounds(x-15, y-Car.getIconHeight()+15,Car.getIconWidth(), Car.getIconHeight());
//         cursor.setText(String.format("(%d, %d)", x,y));
         cursor.setText(null);
         setTitle(String.format("Mouse Dragged(%d, %d)", x,y));
         cursor.setIcon(Car);
         F1.setIcon(null);
      }

      @Override
      public void mouseMoved(MouseEvent e) {
         x = e.getX();
         y = e.getY();
         
         infoLab.setText(String.format("Mouse Moved", x,y));
         setTitle(String.format("Mouse Moved (%d, %d)", x,y));
         cursor.setLocation(x, y-LAB_HEIGHT);
         cursor.setText(String.format("(%d,%d)",x,y));
         F1.setIcon(null);
      }

      @Override
      public void mouseClicked(MouseEvent e) {
         infoLab.setText(String.format("Mouse Clicked (%d)", e.getClickCount()));
      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         int x = e.getX(), y = e.getY();
         
         infoLab.setText(String.format("Mouse Released", x,y));
         setTitle(String.format("Mouse Released (%d, %d)", x,y));
         cursor.setIcon(null);
         cursor.setLocation(x, y-LAB_HEIGHT);
         cursor.setText(String.format("(%d,%d)",x,y));

      }

      @Override
      public void mouseEntered(MouseEvent e) {
         int x = e.getX(), y = e.getY();
         c.setBackground(Color.white);
         cursor.setText(null);
         cursor.setIcon(null);
         infoLab.setText(String.format("Mouse Entered (%d, %d)", x,y));
      }

      @Override
      public void mouseExited(MouseEvent e) {
         int x = e.getX(), y = e.getY();
         // TODO Auto-generated method stub
         c.setBackground(Color.yellow);
         cursor.setText(null);
         cursor.setIcon(null);
         infoLab.setText(String.format("Mouse Exited"));
    
      }

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
    	  int kCode = e.getKeyCode();
    	  
    	  switch(kCode) {
    	  case KeyEvent.VK_F1:
    		  F1.setLocation(x,y);
    		  F1.setIcon(F1img);
    		  infoLab.setText(String.format("F1 Selected"));
    	  case KeyEvent_Ex.VK_UP:
    	  case KeyEvent_Ex.VK_KP_UP:
    	  }
;
   }

      @Override
      public void keyReleased(KeyEvent e) {
      }
      
   }

}