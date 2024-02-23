import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.plaf.synth.SynthFormattedTextFieldUI;

public class HW1 extends JFrame {
   private static int WIDTH = 0, HEIGHT = 0;
   public String Names;
   private static   MyPanel p;
   private static   Line         curLine = null;
   private static 	polygon poly;
   private   boolean   polygon = true;
   public static boolean select = false;
   private static   Vector<Line>    vLines;
   private static   int s_x, s_y, e_x,  e_y,    cidx=0;
   private static   Color[] cols = {Color.red,Color.pink,Color.cyan,Color.magenta,Color.green,Color.blue};
   private static boolean M_mv = true;
   private static boolean first = true;
   public HW1(String W1, String H1, String Name) {
      super("Graphic Test");
      WIDTH = Integer.parseInt(W1);
      HEIGHT = Integer.parseInt(H1);
      Names = Name;

	  
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
          if(Names.equals("polygon")) {
        	  select = true;
    	  }else
    	  if(Names.equals("polygon")) {
    		  select = false;
    	  }
    	  if(Names.equals("random")){
    		  Rand r = new Rand();
    		  int a = Rand.r(0, 1);
    		  if(a == 1) {
    			  select = true;
    		  }else {
    			  select = false;
    		  }
    		  
    		  
    	  }
   
  
    		  int x = e.getX(); int y = e.getY();

        	  
        	  curLine = new Line(cols[(cidx++)%cols.length]);
        	  
        	  
        	  if (M_mv == true) {
        		  System.out.println(1);
        		  
        		   e_x = e.getX(); e_y = e.getY();
        		   curLine = new Line(cols[(cidx++) % cols.length]);
        		   s_x = e_x; s_y = e_y;
        		   if (poly.getSize() >= 2) {
        			   System.out.println(2);
        		      s_x = e_x; s_y = e_y;
        		   }
        		   if(poly.getSize() == 0) {
        			   System.out.println(3);
        		      s_x = x; s_y = y;
        		   }
        		   poly.addXY(x, y);
        		   curLine.setLine(x, y, e_x, e_y);

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
              break;
          case KeyEvent.VK_SPACE:
              if (poly.getSize() >= 2) {
                  poly.setShow(); 
                  curLine = null; 
                  vLines.removeAllElements(); 
                  repaint();
                  M_mv = true; 
              }
              if(poly.getSize() < 2) {
                  poly.setShow();
                  poly.reset();
                  curLine = null; 
                  vLines.removeAllElements();
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
	   if(args.length == 3) {
       String W1 = new String(args[0]);
       String H1 = new String(args[1]);
       String Name = new String(args[2]);
       if (Name.equals("polygon") || Name.equals("polyline") || Name.equals("random")) {
    	 
      new HW1(W1, H1, Name);
      }
       else {
		   System.out.println("다각형 선택 오류");
		  return;
	   }
       
	   }else {
		   System.out.println("매개변수 오류");
		  return;
	   }
   }
   private class MyPanel extends JPanel {
	   private	Color	col;
      public MyPanel() {

    	     int r = (int)(Math.random()*256);
             int g = (int)(Math.random()*256);
             int b = (int)(Math.random()*256);


         vLines = new Vector<>();
         poly = new polygon(new Color(r,g,b), polygon);
         
         addMouseListener(new MyHandler());
         addMouseMotionListener(new MyHandler());
         addKeyListener(new MyHandler());
      }
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         
         poly.drawPoly(g);
         
         
         if(curLine != null) {
        	
            curLine.setLine(s_x, s_y, e_x, e_y);
            curLine.drawLine(g);
         }

         
         for(Line l: vLines) l.drawLine(g);
 
      }
   }
   class polygon {
	   private   Vector<Integer> x, y;
	   private boolean show;
	   private   Color   col;

	   public polygon(Color c, boolean p) { 
	      col = c; polygon = p;
	      show = false;
	      x = new Vector<>(); y = new Vector<>();
	   }
	   public void setShow() {
	      show = true;//이거 고치기
	   }
	   public void setAdd() {
		   x.removeAll(x);
		   y.removeAll(y);

	   }   
	   public int getSize() {return x.size();}
	   public void reset() {
		   //show = false;
		   
		   //x.removeAll(x);
		   //y.removeAll(y);
		   
		   x.clear(); y.clear();
		   
	   }
	   public void addXY(int xx, int yy) {
	      x.add(xx); y.add(yy);
	   }
	   public void drawPoly(Graphics g) {
		   Graphics2D g2d = (Graphics2D) g;
		   
		   
	      int[]   xx = new int[x.size()], yy = new int[y.size()];
	      if(!show) {
	         return;
	      }
	      g.setColor(col);
	      for(int i=0;i < x.size();i++) {
	         xx[i] = x.get(i); yy[i] = y.get(i);
	      }
	      if(polygon == select) {
	    	  g.setColor(col);
	    	  g2d.setStroke(new BasicStroke(6.0f));
	         g.drawPolyline(xx, yy, xx.length);

	      }else {
	    	  g.setColor(col);
	    	  g2d.setStroke(new BasicStroke(6.0f));
	         g.drawPolyline(xx, yy, xx.length);
	      }
	   }
	}

	class Line {
		private	int		sx, sy, ex, ey;
		private	Color	col;
		
		public Line(Color c) { col = c; }
		public void setLine(int x1, int y1, int x2, int y2) {
			 sx = x1; sy = y1; ex = x2; ey = y2;

		}
		public void drawLine(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;

			g.setColor(col);
			g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10.0f, new float[] {10.0f,10.0f,5.0f,10.0f}, 0.0f));
			g.drawLine(sx, sy,   ex,  ey);
		}
	}
}

