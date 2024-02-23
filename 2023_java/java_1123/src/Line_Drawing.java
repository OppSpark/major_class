import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Line_Drawing extends JFrame {
   private static final int WIDTH = 500, HEIGHT = 500;
   private static   MyPanel p;
   private static   Line         curLine = null;
   private static 	polygon poly;

   private static   Vector<Line>    vLines;
   private static ImageIcon  bg_img = new ImageIcon("lake.jpg");
   private static   int   s_x, s_y, e_x, e_y, cidx=0;
   private static   Color[] cols = {Color.red,Color.pink,Color.cyan,Color.magenta,Color.green,Color.blue};
   private static boolean M_mv = true;
   private static boolean Space = true;
   public Line_Drawing() {
      super("Graphic Test");
      
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      p = new MyPanel();
      setContentPane(p);
      
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      p.requestFocus();
      setLocationRelativeTo(null);
   }
   private class MyHandler implements MouseMotionListener, MouseListener, KeyListener {

      @Override
      public void mouseDragged(MouseEvent e) {
          //e_x = e.getX(); e_y = e.getY();
         // repaint();
      }

      @Override
      public void mouseMoved(MouseEvent e) {
    	  if (M_mv == true) {
    		  e_x = e.getX(); e_y = e.getY();
    		  //System.out.println(e_x+" "+ e_y);
    		  repaint();
    	  }

      }

      @Override
      public void mouseClicked(MouseEvent e) {
    	  //poly.addXY(e.getX(), e.getY());
    	  
    	  
    	  if()
    	  
    	  int x = e.getX(); int y = e.getY();
    	  M_mv = true;
    	  
    	  curLine = new Line(cols[(cidx++)%cols.length]);
    	  
    	  
    	  if (M_mv == true) {
    		  System.out.println(1);
    		  
    		   e_x = e.getX(); e_y = e.getY();
    		   curLine = new Line(cols[(cidx++) % cols.length]);
    		   s_x = x; s_y = y;
    		   if (poly.getSize() >= 2) {
    			   System.out.println(2);
    		      s_x = e_x; s_y = e_y;
    		   }
    		   if(poly.getSize() == 0) {
    			   System.out.println(3);
    		      s_x = x; s_y = y;
    		   }
    		   poly.addXY(x, y);
    		   curLine.setLine(s_x, s_y, e_x, e_y);
    		   poly.addXY(e_x, e_y);
    		   vLines.add(curLine);
    		   repaint();
    		}

    	        


      }

      @Override
      public void mousePressed(MouseEvent e) {
    	  
    	 
          
          
      }

      @Override
      public void mouseReleased(MouseEvent e) {
    	  


      }
      public void mouseEntered(MouseEvent e) {}
      public void mouseExited(MouseEvent e) {}

      @Override
      public void keyTyped(KeyEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()) {
         case KeyEvent.VK_ESCAPE:
            curLine = null;
            vLines.removeAll(vLines);
            poly.reset();
            repaint();
            M_mv = false;
            break;
         case KeyEvent.VK_SPACE:
        	 
    		 
        	  if (poly.getSize() >= 2) {
        	      poly.setShow(); // 다각형 그리기 활성화
        	      curLine = null; // 현재 그리는 선 초기화
        	      vLines.removeAllElements(); // 이전에 그렸던 선들 제거
        	      repaint();
        	      M_mv = true; // M_mv 값을 true로 설정하여 이전 좌표값을 유지
        	   }
        	if(poly.getSize() <= 2) {
        	   poly.setShow(); // 다각형 그리기 활성화
        	   poly.reset(); // 다각형 좌표 초기화
     	      curLine = null; // 현재 그리는 선 초기화
        	   repaint();
        	   M_mv = false;

        	}	

            break;
         default:
            break;
         }
      }

      @Override
      public void keyReleased(KeyEvent e) {
         // TODO Auto-generated method stub
         
      }
   }
   public static void main(String[] args) {
      new Line_Drawing();
   }
   private class MyPanel extends JPanel {
      public MyPanel() {
         vLines = new Vector<>();
         poly = new polygon(Color.blue, true);
         
         addMouseListener(new MyHandler());
         addMouseMotionListener(new MyHandler());
         addKeyListener(new MyHandler());
      }
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         
         Image img = bg_img.getImage();
         g.drawImage(img, 0,0, getWidth(),getHeight(),200,200,300,300,this);
         
         
         poly.drawPoly(g);
         
         
         if(curLine != null) {
            curLine.setLine(s_x, s_y, e_x, e_y);
            curLine.drawLine(g);
         }
         for(Line l: vLines) l.drawLine(g);
         
      }
   }
}

class polygon {
   private   Vector<Integer> x, y;
   private boolean show;
   private   Color   col;
   private   boolean   polygon = true;
   public polygon(Color c, boolean p) { 
      col = c; polygon = p;
      show = false;
      x = new Vector<>(); y = new Vector<>();
   }
   public void setShow() {
      show = true;
   }
   public void setAdd() {
	   x.removeAll(x);
	   y.removeAll(y);
   }   
   public int getSize() {return x.size();}
   public void reset() {
	   show = false;
	   /*
	   x.removeAll(x);
	   y.removeAll(y);
	   */
	   x.clear(); y.clear();
	   
   }
   public void addXY(int xx, int yy) {
      x.add(xx); y.add(yy);
   }
   public void drawPoly(Graphics g) {
      int[]   xx = new int[x.size()], yy = new int[y.size()];
      if(!show) {
         return;
      }
      g.setColor(col);
      for(int i=0;i < x.size();i++) {
         xx[i] = x.get(i); yy[i] = y.get(i);
      }
      if(polygon) {
         g.drawPolygon(xx, yy, xx.length);
      }
      else {
 
         g.drawPolyline(xx, yy, xx.length);
      }
   }
}



