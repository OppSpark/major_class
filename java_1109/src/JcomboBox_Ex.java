import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class JcomboBox_Ex extends JFrame{
    private static JComboBox<String> list1;
    private static String[] name = {"airplane","bus","ship","train","truck"};
    private static ImageIcon[] icons = {new ImageIcon("airplane.png"),
            new ImageIcon("bus.png"), new ImageIcon("ship.png"), 
            new ImageIcon("train.png"), new ImageIcon("truck.png")};

    private static JLabel output = new JLabel();
    public JcomboBox_Ex() {
        super("List Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton btn = new JButton("선택");

        list1 = new JComboBox<>(name);
        add(list1);
        add(btn);
        btn.addActionListener(new MyHandler());
        output.setBackground(Color.yellow);
        output.setIcon(icons[list1.getSelectedIndex()]);
        add(output);



        setPreferredSize(new Dimension(400,300));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new JcomboBox_Ex();

    }
    private class MyHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            output.setIcon(icons[list1.getSelectedIndex()]);
            //Label에 아이콘 세팅이 됨
        }

    }

}
