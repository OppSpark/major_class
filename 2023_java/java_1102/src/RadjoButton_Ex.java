import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadjoButton_Ex extends JFrame {
	private static ImageIcon O = new ImageIcon("O.png"), X = new ImageIcon("X.png");
	private static ImageIcon Os = new ImageIcon("Os.png"), Xs = new ImageIcon("Xs.png");
	private static ImageIcon Or = new ImageIcon("Or.png"), Xr = new ImageIcon("Xr.png");
	private static RadjoButton_Ex Btn[] = new RadjoButton_Ex[3], curBtn = null;
	private static JLabel infoLab = new JLabel("다음 차례는 O", JLabel.CENTER);
	private static boolean nextO = true;
	public RadjoButton_Ex() {
		super("RadjoButton_Ex");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(1,2));
		JPanel	msgPan = new JPanel(new GridLayout(0, 1)), bordPan = new JPanel(new GridLayout(3, 3));
		infoLab.setFont(new Font("그래픽", Font.BOLD, 34));
		infoLab.setBackground(Color.blue);
		infoLab.setForeground(Color.white);
		infoLab.setOpaque(true);
		
		msgPan.add(infoLab);
		add(msgPan, BorderLayout.NORTH);
		add(bordPan, BorderLayout.CENTER);
		ButtonGroup g = new ButtonGroup();
		
		for(int i=0;i < 3;i++) {
				JRadioButton[] chkBbox;
				chkBbox[i] = new JRadioButton(name[i], icons[i]);
				chkBbox[i].setBackground(Color.white);
				chkBbox[i].setFocusPainted(false);
				chkBbox[i].addActionListener(new MyHandler());
				chkBbox[i].addKeyListener(new MyHandler());
				g.add(chkBbox[i]);
				bordPan.add(Btn[i]);
			}
		
		
		
		addKeyListener(new MyHandler());
		setPreferredSize(new Dimension(500, 500));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setFocusable(true);
		requestFocus();
	}
	public static void main(String[] args) {
		new RadjoButton_Ex();
	}

	private class MyHandler implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RadjoButton_Ex btn = (RadjoButton_Ex) e.getSource();
			
			if(btn.getIcon() == null) {
			
			if(nextO) {
				btn.setIcon(O);
				btn.setPressedIcon(Os);
				btn.setRolloverIcon(Or);
			}
			else {
				btn.setIcon(X);
				btn.setPressedIcon(Xs);
				btn.setRolloverIcon(Xr);
			}
			nextO = !nextO;
			
			infoLab.setText("다음 차례는 "+ ( (nextO) ? "O":"X"));
			
			}
			
			if( curBtn != null)
				curBtn.setBackground(Color.white);
			curBtn = btn;
			btn.setBackground(Color.yellow);
			requestFocus();
			
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch (keyCode) {
			case KeyEvent.VK_ESCAPE:
				for(int i=0;i < 3;i++) {
					for(int j=0;j < 3;j++) {
						Btn[i][j].setIcon(null);
						Btn[i][j].setBackground(Color.white);
						
					}
				}
				curBtn = null;

			case KeyEvent.VK_O:
				nextO = true;
				break;
			case KeyEvent.VK_X:
				nextO = false;
				break;
			case KeyEvent.VK_UP:
				if(curBtn.row == 0)
					break;
				curBtn.SwapIcon(Btn[curBtn.row - 1][curBtn.col]);
				curBtn.setBackground(Color.white);
				curBtn = Btn[curBtn.row - 1][curBtn.col];
				curBtn.setBackground(Color.yellow);
				curBtn.requestFocus();

			default:
				break;
			}
			infoLab.setText("다음 차례는 "+ ( (nextO) ? "O":"X"));
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
		
	}
	
	private class MyButton extends JButton {
		int		row, col;
		
		public MyButton(int r, int c) {
			row = r; col = c;
		}
		public void SwapIcon(MyButton otherBtn) {
			Icon tmp = otherBtn.getIcon();
			
			otherBtn.setIcon(getIcon());
			setIcon(tmp);
		}
	}
	
}
