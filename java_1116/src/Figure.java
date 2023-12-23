import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	protected int x, y, w,h;
	protected boolean show;
	protected Color	col;
	public Figure(int xx, int yy, int ww, int hh, Color c) {
		x = xx; y = yy; w = ww; h = hh; col = c; show = true;
	}
	
	public void setShow() {
		show  = !show;
	}
	public void setColor(Color c) {
		if(!show)
			return;
		col = c;
	}
	public void setSize(int step) {
		if(!show)
			return;
		w += step; h += step;
	}
	public void setCoord(int xx, int yy) {
		if(!show)
			return;
		x = xx; y = yy;
		
	}
	public void changeCoord(int x_step, int y_step, int f_w, int f_h){
		if(!show)
			return;
		if((x+x_step < 0) || (y+y_step < 0) || (x+x_step + w > f_w) || (y+y_step + h > f_h))
			return;

		x += x_step; y += y_step;

	}
	public abstract void drawFigure(Graphics g);
	
	public void drawRect(Graphics g) {
		g.setColor(col);
		g.drawRect(x, y, w, h);
	}
	public void drawOval(Graphics g) {
		g.setColor(col);
		g.drawOval(x, y, w, h);
	}
	
	
}

class Rectangle extends Figure{

	public Rectangle(int xx, int yy, int ww, int hh, Color c) {
		super(xx, yy, ww, hh, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawFigure(Graphics g) {
		// TODO Auto-generated method stub
		if(!show) return;
		g.setColor(col);
		g.drawRect(x, y, w, h);
		
	}
	
}

class Circle extends Figure{

	public Circle(int xx, int yy, int ww, int hh, Color c) {
		super(xx, yy, ww, hh, c);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void drawFigure(Graphics g) {
		// TODO Auto-generated method stub
		if(!show) return;
		g.setColor(col);
		g.drawOval(x, y, w, h);
		
	}
	
}
