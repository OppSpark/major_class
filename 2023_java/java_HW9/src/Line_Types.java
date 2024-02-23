import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Line_Types extends JFrame {
	public Line_Types() {
		setTitle("선의 종류 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());

		setSize(400,300);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Line_Types();
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			
			Font f = new Font("그래픽", Font.BOLD, 24);
			
			g.setColor(Color.blue);
			g.setFont(f);
			g.drawString("[얇은점선]", 20, 60);
			
			g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10.0f, new float[] {10.0f,10.0f,5.0f,10.0f}, 0.0f));
			g.drawLine(20, 80, 360, 80);
			
			g.setColor(Color.red);
			g.setFont(f);
			g.drawString("[굵은점선]", 20, 120);
			
			g2d.setStroke(new BasicStroke(6.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10.0f, new float[] {10.0f,10.0f,5.0f,10.0f}, 0.0f));
			g.drawLine(20, 140, 360, 140);
			
			g.setColor(Color.magenta);
			g.setFont(f);
			g.drawString("[굵은선]", 20, 180);
			
			g2d.setStroke(new BasicStroke(6.0f));	// 6.0f를 작게 하면 얇은 선이 됨
			g.drawLine(20, 200, 360, 200);
		}
	}
}