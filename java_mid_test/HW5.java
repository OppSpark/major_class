import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HW5 extends JFrame {
	private static final String DIV="\u00f7",PLUS="\u002b",MINUS="\u2212",
				MULTI="\u00D7",EQ="\u003D", SIGN="\u00b1", DOT="\u2219";
	private static JTextField outF = new JTextField("0");
	private static String[][] bNames = {
			{PLUS,MINUS,MULTI,DIV},
			{"7","8","9","%"},
			{"4","5","6","CE"},
			{"1","2","3",EQ},
			{SIGN,"0",DOT}
	};
	private static String op1, op2, operator;
	private	static	JButton[][] btns = new JButton[bNames.length][];
	public HW5() {
		super("문제#5");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel outPan = new JPanel(new GridBagLayout()), keyPan = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		JButton	btn;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.gridx = gc.gridy = 0;
		gc.ipadx = 400;
		gc.ipady = 20;
		outF.setFont(new Font("Arial", Font.BOLD, 28));
		outF.setHorizontalAlignment(JTextField.RIGHT);
		outF.setEditable(false);
		outF.setBackground(new Color(51, 0, 102));
		outF.setForeground(new Color(255, 255, 204));
		outPan.add(outF, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 0;
		outPan.add(btn = new JButton("DEL"), gc);	
		btn.addActionListener(new MyHandler());
		MakeKeyPad(keyPan);
		add(outPan, BorderLayout.NORTH);
		add(keyPan, BorderLayout.CENTER);
		addKeyListener(new MyHandler());
		
		setPreferredSize(new Dimension(500,300));
		pack();
		setVisible(true);
		setFocusable(true);
		requestFocus();
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Calculator();
	}
	public void MakeKeyPad(JPanel p) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(2, 2, 2, 2);
		for(int y=0;y < bNames.length;y++) {
			btns[y] = new JButton[bNames[y].length];
			for(int x=0;x < bNames[y].length;x++) {
				gc.gridx = x;
				gc.gridy = y;
				if(bNames[y][x].equals(EQ)) {
					gc.gridheight = 2;
				} else {
					gc.gridheight = 1;
				}
				p.add(btns[y][x] = new JButton(bNames[y][x]),gc);
				btns[y][x].setFocusPainted(false);
				btns[y][x].addActionListener(new MyHandler());
			}
		}
	}
	private static String compute(String AS, String oper, String BS) {
		int		A, B;
		float	result=0;
		A = Integer.parseInt(AS);
		B = Integer.parseInt(BS);
		
		switch (oper) {
		case PLUS:
			result = A + B;
			break;
		case MINUS:
			result = A - B;
			break;
		case DIV:
			result = (float)A / B;
			break;
		case "%":
			result = A % B;
			break;
		case MULTI:
			result = A * B;
			break;
		default:
			break;
		}
		
		return (""+((int)result));
	}
	private static void Execute(String bName) {
		switch (bName) {
		case "0": case "1": case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
			if(outF.getText().equals("0"))
				outF.setText(bName);
			else {
				outF.setText(outF.getText()+bName);
			}
			break;
		case "CE":
			outF.setText("0");
			break;
		case PLUS: case MINUS: case DIV: case MULTI: case "%":
			op1 = outF.getText();
			operator = bName;
			outF.setText("0");
			break;
		case EQ:
			op2 = outF.getText();
			outF.setText(compute(op1, operator, op2));
			break;
		case "DEL":
			if(outF.getText().length() > 1)
				outF.setText(outF.getText().substring(0, outF.getText().length()-1));
			else
				outF.setText("0");
			break;
		default:
			break;
		}
	}
	private class MyHandler implements ActionListener, KeyListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String bName = ((JButton)e.getSource()).getText();
			Execute(bName);
			requestFocus();
		}
		public void keyPressed(KeyEvent e) {
			int		kCode = e.getKeyCode();
			char	kChar = e.getKeyChar();
			String	bName = null;
			
			switch (kCode) {
			case KeyEvent.VK_8:
				if(kChar == '*') {
					bName = MULTI;
					break;
				}
			case KeyEvent.VK_0:case KeyEvent.VK_1:case KeyEvent.VK_2:case KeyEvent.VK_3:case KeyEvent.VK_4:
			case KeyEvent.VK_5:case KeyEvent.VK_6:case KeyEvent.VK_7:case KeyEvent.VK_9:
			case KeyEvent.VK_NUMPAD0: case KeyEvent.VK_NUMPAD1:case KeyEvent.VK_NUMPAD2:case KeyEvent.VK_NUMPAD3:
			case KeyEvent.VK_NUMPAD4: case KeyEvent.VK_NUMPAD5:case KeyEvent.VK_NUMPAD6:case KeyEvent.VK_NUMPAD7:
			case KeyEvent.VK_NUMPAD8: case KeyEvent.VK_NUMPAD9:
				bName = kChar+""; break;
			case KeyEvent.VK_BACK_SPACE: case KeyEvent.VK_DELETE:
				bName = "DEL";	break;
			case KeyEvent.VK_HOME:
				bName = "CE"; break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0); break;
			case KeyEvent.VK_SLASH:
				bName = DIV; break;
			case KeyEvent.VK_MINUS:
				bName = MINUS; break;
			case KeyEvent.VK_ENTER:
				bName = EQ; break;
			
			default:
				switch (kChar) {
				case '+':
					bName = PLUS;
					break;
				case '%':
					bName = "%";
					break;
				case '*':
					bName = MULTI;
					break;
				case '-':
					bName = MINUS;
					break;
				case '/':
					bName = DIV;
					break;
				default:
					break;
				}
				break;
			}
			if(bName != null) Execute(bName);
		}
		public void keyReleased(KeyEvent e) {}	
		public void keyTyped(KeyEvent e) {}
	}
}

