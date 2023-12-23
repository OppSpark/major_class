import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HW1 extends JFrame {
    public static Container c;
    public static int Num_Timers = 1;
    private static MyButton Btn[] = new MyButton[6];
    public static MyLabels[] labs = new MyLabels[Num_Timers];
    JRadioButton hourRadio, minuteRadio, secondRadio;
    private boolean timerUse = false;
    private boolean Stop = false;
    

    public HW1() {
        super("[HW#1] Timer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.WHITE);

        // 시작, 일시 중단 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 5));
        buttonPanel.setOpaque(false);
        for (int i = 0; i < 3; i++) {
            Btn[i] = new MyButton();
            Btn[i].addActionListener(new MyHandler());
            Btn[i].setBackground(new Color(97, 131, 187));
            Btn[i].setForeground(Color.WHITE);
        }

        Btn[0].setText("시작");
        Btn[1].setText("일시중단");
        Btn[2].setText("초기화");

        for (int i = 0; i < 3; i++) {
            buttonPanel.add(Btn[i]);
        }

        c.add(buttonPanel);

        // 숫자 타이머 패널
        JPanel timerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timerPanel.setPreferredSize(new Dimension(340, 60));
        timerPanel.setOpaque(false);
        labs[0] = new MyLabels();
        timerPanel.add(labs[0].lab);

        c.add(timerPanel);

        // UP, DOWN 버튼 패널
        JPanel upDownPanel = new JPanel(new GridLayout(0, 1));
        upDownPanel.setOpaque(false);
        Btn[4] = new MyButton();
        Btn[4].setText("\u2191");
        Btn[4].addActionListener(new MyHandler());
        Btn[5] = new MyButton();
        Btn[5].setText("\u2193");
        Btn[5].addActionListener(new MyHandler());
        upDownPanel.add(Btn[4]);
        upDownPanel.add(Btn[5]);

        c.add(upDownPanel);

        // 라디오 버튼 패널
        JPanel radioPanel = new JPanel(new GridLayout(0, 1, 10, 5));
        radioPanel.setOpaque(false);
        hourRadio = new JRadioButton("시");
        minuteRadio = new JRadioButton("분");
        secondRadio = new JRadioButton("초");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(hourRadio);
        buttonGroup.add(minuteRadio);
        buttonGroup.add(secondRadio);

        hourRadio.setHorizontalAlignment(SwingConstants.CENTER);
        minuteRadio.setHorizontalAlignment(SwingConstants.CENTER);
        secondRadio.setHorizontalAlignment(SwingConstants.CENTER);

        hourRadio.setBackground(Color.WHITE);
        minuteRadio.setBackground(Color.WHITE);
        secondRadio.setBackground(Color.WHITE);

        radioPanel.add(hourRadio);
        radioPanel.add(minuteRadio);
        radioPanel.add(secondRadio);

        c.add(radioPanel);
        
        labs[0].pause = true;
        labs[0].start();
       
        
        setPreferredSize(new Dimension(600, 150));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new HW1();
    }

    private class MyButton extends JButton {
    }

    private class MyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            switch(buttonText){
                case "시작":
                	labs[0].pause = false;
                	timerUse = true;
                	Stop = false;

                    break;
                case "일시중단":
                    labs[0].pause = true;
                    timerUse = false;
                    Stop = true;
                    break;
                case "초기화":
                    labs[0].n = 0;
                    labs[0].lab.setText("00:00:00");
                    labs[0].lab.setBackground(Color.WHITE);
                    labs[0].lab.setForeground(Color.black);
                    c.setBackground(Color.WHITE);
                    hourRadio.setBackground(Color.WHITE);
                    minuteRadio.setBackground(Color.WHITE);
                    secondRadio.setBackground(Color.WHITE);
                    hourRadio.setForeground(Color.BLACK);
                    minuteRadio.setForeground(Color.BLACK);
                    secondRadio.setForeground(Color.BLACK);

                    labs[0].hours = 0; labs[0].minutes = 0; labs[0].seconds = 0;
                    labs[0].alarmSet = false;
                    labs[0].pause = true;
                    timerUse = false;
                    Stop = false;
                    break;
                    
                    //UP
                case "\u2191":
                	if(!timerUse && !Stop ) {
                    if(hourRadio.isSelected()){
                    	labs[0].n = labs[0].n + 3600;
                        labs[0].hours++;
                    }else if(minuteRadio.isSelected()){
                    	labs[0].n = labs[0].n + 60;
                        labs[0].minutes++;
                    }else if(secondRadio.isSelected()){
                    	labs[0].n = labs[0].n + 1;
                        labs[0].seconds++;
                       
                    }
                    labs[0].updateLabel();
                	}
                	//labs[0].lab.setText(String.format("%02d:%02d:%02d", labs[0].hours, labs[0].minutes, labs[0].seconds));
                    break;
                    
                    //DOWN
                case "\u2193":  
                	if(!timerUse && !Stop) {
                		if(hourRadio.isSelected() && labs[0].hours > 0){
                            labs[0].hours--;
                            labs[0].n = labs[0].n - 3600;
                        }else if(minuteRadio.isSelected() && labs[0].minutes > 0){
                            labs[0].minutes--;
                            labs[0].n = labs[0].n - 60;
                        }else if(secondRadio.isSelected() && labs[0].seconds > 0){
                            labs[0].seconds--;
                            labs[0].n = labs[0].n - 1;
                        }
                        labs[0].updateLabel();
                	}
                	//labs[0].lab.setText(String.format("%02d:%02d:%02d", labs[0].hours, labs[0].minutes, labs[0].seconds));
                    break;
            }
        }
    }

    public class MyLabels extends Thread {
        JLabel lab;
        int n, hours, minutes, seconds;
        boolean pause, alarmSet;

        public MyLabels() {
            n = 0;
            hours = minutes = seconds = 0;
            pause = false;
            alarmSet = false;
            lab = new JLabel(n + "", SwingConstants.CENTER);
            lab.setOpaque(true);
            lab.setFont(new Font("Arial", Font.BOLD, 48));
            lab.setText("00:00:00");
            lab.setForeground(Color.BLACK);
            lab.setBackground(Color.WHITE);
        }

        public void updateLabel() {
            lab.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }

        public void run() {
        	
            while (true) {
                if(n > 0) n--;
                int currentHours = n / 3600;
                int currentMinutes = (n % 3600) / 60;
                int currentSeconds = n % 60;
                lab.setText(String.format("%02d:%02d:%02d", currentHours, currentMinutes, currentSeconds));

                if (n == 0 &&timerUse){
                    lab.setBackground(Color.RED);
                    lab.setForeground(Color.WHITE);
                    c.setBackground(Color.RED);
                    hourRadio.setBackground(Color.RED);
                    minuteRadio.setBackground(Color.RED);
                    secondRadio.setBackground(Color.RED);
                    hourRadio.setForeground(Color.WHITE);
                    minuteRadio.setForeground(Color.WHITE);
                    secondRadio.setForeground(Color.WHITE);
                    alarmSet = false;
                }

                try {
                    sleep(1000);
                    if (pause) {
                        while (pause) {
                            sleep(50);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

