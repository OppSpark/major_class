import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Car_Racing extends JFrame {
    private static Container c;
    private static ImageIcon[] carIcons = {
            new ImageIcon("Car1.png"),new ImageIcon("Car2.png"),
            new ImageIcon("Car3.png"),new ImageIcon("Car4.png"),new ImageIcon("Car5.png")};
    private static ImageIcon[] buletIcons = {
            new ImageIcon("bullet1.png"),new ImageIcon("bullet2.png.png"),
            new ImageIcon("bullet3.png"),new ImageIcon("bullet4.png"),new ImageIcon("bullet5.png")};
    private static Car cars[] = new Car[carIcons.length];

    public Car_Racing() {
        super("JFrame Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        c = getContentPane();
        c.setLayout(null);
        c.add(cars[0] =  new Car(1,5));
        for(int i = 0; i < 5; i++){
            c.add(cars[i] = new Car(i + 1, Rand.r(3,10)));
        }

        setSize(new Dimension(600, 500));

        setVisible(true);
        setLocationRelativeTo(null);

    }
    private class Car extends  JLabel implements Runnable{
        private ImageIcon car_icon;
        private int speed,position, x, y;
        private Thread th;
        public Car(int p, int s){
            speed = s;
            position = p;
            car_icon = carIcons[p-1];
            x = 5;
            y = (position-1)*car_icon.getIconHeight();
            setIcon((car_icon));
            setBounds(s,s,car_icon.getIconWidth(), car_icon.getIconHeight());
            th = new Thread(this);
            th.start();
        }
public void setPosition(){
    setLocation(x,y);

}
        @Override
        public void run() {

            while(true){
                if(x +speed > c.getWidth())
                    x = 5;
                else x += speed;
                x += speed;
                setPosition();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static void main(String[] args) {
        new Car_Racing();
    }
    private class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);


            ImageIcon imgIcon = new ImageIcon("castle_bg.jpg");
            Image bgIcon = imgIcon.getImage();
            g.drawImage(bgIcon,0,0,c.getWidth(),c.getHeight(),this);
        }
    }
}













