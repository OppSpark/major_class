package java_1019;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TicTacToe extends JFrame{
	private static JPanel Up = new JPanel(new GridLayout(1,1)), Down = new JPanel((new GridLayout(1,1)));
	private static Mybutton Boards[][] = new Mybutton[3][3];
	private static JTextField infoWin = new JTextField("Ti Tac Toe game");
	public TicTacToe() {
			super("Tic Tac Toe Game");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new BorderLayout(3,3));
			
			for(int i = 0; i < Boards.length; i++) {
				for(int j = 0; j < Boards[i].length; j++) {
					Boards[i][j] = new Mybutton(i, j);
					Down.add(Boards[i][j]);
					
				}
			}
			Up.add(infoWin);
			add(Up, BorderLayout.NORTH);
			add(Up, BorderLayout.CENTER);
			
			setPreferredSize(new Dimension(400,400));
			pack();
			setVisible(true);
			setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToe();

	}
	private class Mybutton extends JButton{
		
		int row, col;
		char ox;
		
		public Mybutton(int r, int c) {
			row = r; col = c;
			
		}
		
	}

}
