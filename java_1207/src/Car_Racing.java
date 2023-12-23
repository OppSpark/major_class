import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Car_Racing extends JFrame {
	private Container c;
	private static ImageIcon[] carIcons = {
		new ImageIcon("car1.png"), new ImageIcon("car2.png"), new ImageIcon("car3.png"),	
		new ImageIcon("car4.png"), new ImageIcon("car5.png"),
	};
	private static ImageIcon[] bulletIcons = {
			new ImageIcon("bullet1.png"), new ImageIcon("bullet2.png"), new ImageIcon("bullet3.png"),	
			new ImageIcon("bullet4.png"), new ImageIcon("bullet5.png"),
		};
	private static Car	cars[] = new Car[carIcons.length], curCar;
	private static Bullet curBullet;
	public Car_Racing() {
		super("Car #1 선택됨");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyHandler());
		setSize(new Dimension(700,500));
		for(int i=0; i<5; i++) {
			c.add(cars[i] = new Car(i+1, Rand.r(3, 10)));
		}

		setVisible(true);
		c.add(curBullet = new Bullet(1, 10));
		
		curCar = cars[0];
		
		System.out.printf("<%d X %d>\n",c.getWidth(),c.getHeight());
		//ContentPane의 가로 세로 크기 확정 순간은 SetVisible 할 때 이다
		// 즉, c.add 등의 명령어로 뭘 만들기 위해서는 setVisible 뒤에 둬야한다
		c.requestFocus();
		//setLocationRelativeTo(null);
	}
	private class Car extends JLabel implements Runnable {
		private ImageIcon car_icon;
		private int speed, position, x, y;
		private Blinking blink;
		private Thread th;
		
		public Car(int p, int s) {
			speed = s;
			position = p;
			car_icon = carIcons[p-1];
			x = 5;
			y = (position-1)*car_icon.getIconHeight();
			setIcon(car_icon);
			setBounds(x, y, car_icon.getIconWidth(), car_icon.getIconHeight());
			blink = new Blinking(this);
			th = new Thread(this);
			th.start();
			blink.start();
		}
		public void setPosition() {
			setLocation(x, y);
		}
		public void DoBlink() {
			blink.doBlinking();
		}
		
		
		public void Up() {
			if (y-speed<0) return;
			y-= speed;
			setPosition();
		}
		public void Down() {
			if(y+speed+car_icon.getIconHeight() > c.getWidth()) return;
			y+= speed;
			setPosition();
		}
		
		public void run() {
			while(true) {
				if(x+speed > c.getWidth()) x = 5;
				else x+= speed;
				setPosition();
				
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private class Bullet extends JLabel implements Runnable {
		private ImageIcon icon;
		private int speed, position, x, y;
		private Blinking blink;
		private boolean fired;
		private Thread th;
		
		public Bullet(int p, int s) {
			speed = s;
			position = p;
			icon = bulletIcons[p-1];
			x = c.getWidth()/2;
			y = c.getHeight()-icon.getIconHeight();
			setIcon(icon);
			setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
//			blink = new Blinking(this);
			th = new Thread(this);
			th.start();
//			blink.start();
		}
		public void setPosition() {
			setLocation(x, y);
		}
		public void DoBlink() {
			blink.doBlinking();
		}
		public void Fire() {
			fired = true;
			th.interrupt();
		}
		public void Left() {
			if (x-speed<0 || fired) return;
			x-= speed;
			setPosition();
		}
		public void Right() {
			if(x+speed+icon.getIconWidth() > c.getWidth() || fired ) return;
			x+= speed;
			setPosition();
		}
		
		public void run() {
			while(true) {
				if (fired) {
					while(fired) {
						if (y-speed < 0) {
							y = c.getHeight() - icon.getIconHeight();
							fired = false;
							setPosition();
							break;
						}
						else y -= speed;
						setPosition();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							continue;
						}
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					continue;
				}
			}
		}
	}

	private class Blinking extends Thread {
		private JLabel comp;
		private boolean On;
		public Blinking(JLabel comp) {
			this.comp = comp;
			On = false;
		}
		public void doBlinking() {
			On = !On;
			this.interrupt();
		}
		public void setCar(Car car) {
			comp = car;
		}
		public void run() {
			boolean blinking = false;
			while(true) {
				if (On) {
					blinking = true;
					c.requestFocus();
					while(On) {
						comp.setVisible(blinking);
						try {
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("Woke !!");
							break;
						}
						blinking = !blinking;
					}
					setVisible(true);
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					continue;
				}
			}
		}
	}
	private class MyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_UP:
				curCar.Up();
				break;
			case KeyEvent.VK_DOWN:
				curCar.Down();
				break;
			case KeyEvent.VK_LEFT:
				curBullet.Left();
				break;
			case KeyEvent.VK_RIGHT:
				curBullet.Right();;
				break;
			case KeyEvent.VK_PLUS:
				curCar.DoBlink();
			case KeyEvent.VK_SPACE:
				curBullet.Fire();
			default:
				break;
			}
			for (int i=0; i<cars.length; i++) {
				if(keyCode == KeyEvent.VK_F1+i) {
					curCar = cars[+ i];
					setTitle("Car #"+(i+1));
					break;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new Car_Racing();
	}
	private class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			ImageIcon imgIcon = new ImageIcon("castle_bg.jpg");
			Image	bgIcon = imgIcon.getImage();
			
			g.drawImage(bgIcon, 0, 0, c.getWidth(), c.getHeight(), this);
			
		}
	}
}