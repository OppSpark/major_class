import java.awt.Color;
import java.awt.Graphics;

public class Line {
	private	int		sx, sy, ex, ey;
	private	Color	col;
	
	public Line(Color c) { col = c; }
	public void setLine(int x1, int y1, int x2, int y2) {
		sx = x1; sy = y1; ex = x2; ey = y2;
	}
	public void drawLine(Graphics g) {
		g.setColor(col);
		g.drawLine(sx, sy, ex, ey);
	}
}