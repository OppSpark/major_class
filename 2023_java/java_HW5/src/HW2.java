import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.AccessibleAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HW2 extends JFrame {
	private static JTextField outF = new JTextField("0");
	private static final String PER = "%", DIV = "\u00F7", PLUS = "\u002b", MINUS ="\u2212", MULTI = "\u00D7", EQ = "\u003D", SIGN = "\u00b1",DOT = "\u2219";
	private static String[][] bNames = {
			{PLUS,MINUS,MULTI,DIV},
			{"7","8","9",PER},
			{"4","5","6","CE"},
			{"1","2","3",EQ},
			{SIGN,"0",DOT}
	};
	private static String op1, op2, operator;
	private static JButton[][] btns = new JButton[bNames.length][];
	
	
	public HW2() {
		super("[과제#2] 계산기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel outPan = new JPanel(new GridBagLayout()), keyPan = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.gridx = gc.gridy = 0;
		gc.ipadx = 400;
		gc.ipady = 20;
		
		outF.setFont(new Font("Arial", Font.BOLD,24));
		outF.setHorizontalAlignment(JTextField.RIGHT);
		outF.setEditable(false);
		outF.setBackground(new Color(205,250,0));
		outF.setForeground(new Color(63,155,22));
		
		outPan.add(outF, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.ipadx = 0;
		
		
		JButton delButton = new JButton("DEL");
	    delButton.addActionListener(new MyHandler());
	    gc.gridx = 1;
	    gc.gridy = 0;
	    gc.ipadx = 0;
	    outPan.add(delButton, gc);    
	
		MakeKeyPad(keyPan);
		add(outPan, BorderLayout.NORTH);
		add(keyPan, BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(500,300));
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new HW2();
	}
	
	public void MakeKeyPad(JPanel p) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		
		for(int y = 0; y < bNames.length; y++) {
			btns[y] = new JButton[bNames[y].length];
			for(int x = 0; x < bNames[y].length; x++) {
				gc.gridx = x;
				gc.gridy = y;
				if(bNames[y][x].equals(EQ)) {
					gc.gridheight = 2;
				}else {
					gc.gridheight = 1;
				}
				p.add(btns[y][x] = new JButton(bNames[y][x]),gc);
				btns[y][x].setFocusPainted(false);
				btns[y][x].addActionListener(new MyHandler());
				
			}
		}
	}
	
	private static String compute(String AS, String oper, String BS) {
		float A , B;
		float result=0;
		
		A = Float.parseFloat(AS);
		B = Float.parseFloat(BS);
		
		switch (oper) {
		case PLUS:
			result = A + B;
			break;
		case MINUS:
			result = A - B;
			break;
		case DIV:
			if(B == 0) return("Divide By Zero"); // 0 이면 오류 출력
			
			A = (float) Math.floor(A);  // 나누기의 경우 예외적으로 반내림
			result = (float)A / B;
			
			if(result == Math.floor(result)) {
				return String.format("%.0f", result);  // 소수점이 0이면 소수점을 없애고 출력
			}else {
				return String.format("%.3f", result);  //소수점으로 나누어 떨어지면 소수점 3자리 까지 출력
		    }
		case PER:
	        if(B == 0) return("Divide By Zero"); // 0 이면 오류 출력
	        
	        A = (float) Math.floor(A);  // 백분률 의 경우 예외적으로 반내림
	        result = (float)A / 100 * B;

	        if(result == Math.floor(result)) {
	            return String.format("%.0f", result);
	        } else {
	            return String.format("%.3f", result);
	        }
	
		case MULTI:
			A = (float) Math.floor(A);
			result =(float)(A *B);
			break;
		default:
			break;
		}
		
		return (""+((int)result));
	}
	
	class MyHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String bName =((JButton)e.getSource()).getText();
			switch (bName) {
			case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":case "8":case "9":
				if(outF.getText().equals("Divide By Zero")) {  //Divide By Zero 가 있으면 값을 초기화 하는 문장을 추가함 
                    outF.setText(bName);
                } else if(outF.getText().equals("0")) {
                    outF.setText(bName);
                } else{
                    outF.setText(outF.getText()+bName);
                }
				break;
			case "CE":
				outF.setText("0");
				break;
	
			case "DEL":
                if(outF.getText().length()>1){
                    outF.setText(outF.getText().substring(0,outF.getText().length()-1));
                }else{
                    outF.setText("0");
                }
                break;
			case DOT:
				if(outF.getText().equals("Divide By Zero")) {
                    outF.setText(bName);
                }
				outF.setText(outF.getText()+".");
				break;
		    case SIGN:
	            if(!outF.getText().equals("0")){
	                int value=Integer.parseInt(outF.getText());
	                value=value*-1; 
	                outF.setText(Integer.toString(value));
	            }
	            break;
			case PLUS: case MINUS: case DIV: case MULTI: case PER:
				op1 = outF.getText();
				operator = bName;
				outF.setText("0");
				break;
				
			case EQ:
				op2 = outF.getText();
				
				outF.setText(compute(op1, operator, op2));
				break;

			default:
				break;
			}
			
		}
		
	}
}

