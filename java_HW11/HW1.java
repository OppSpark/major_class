import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.peer.MenuPeer;
import java.lang.Thread.State;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HW1 extends JFrame {
	private Container c;
	private int currentBgIndex = 0;
	private static ImageIcon[] carIcons = {
		new ImageIcon("ID1.png"), new ImageIcon("ID2.png"), new ImageIcon("ID3.png"),	
		new ImageIcon("ID4.png"), new ImageIcon("ID5.png"),
		};
	private static ImageIcon[] bulletIcons = {
			new ImageIcon("LA1.png"), new ImageIcon("LA2.png"), new ImageIcon("LA3.png"),	
			new ImageIcon("LA4.png"), new ImageIcon("LA5.png")
		};
	
	private static ImageIcon[] character = {
			new ImageIcon("CA1.png"), new ImageIcon("CA2.jpg"), new ImageIcon("CA3.jpg"),	
			new ImageIcon("CA4.png"),
	};
	private static ImageIcon[] bgs = {
			new ImageIcon("BG1.png"), new ImageIcon("BG2.png"), new ImageIcon("BG3.png"),	
		};
	
	private static Car	cars[] = new Car[carIcons.length], curCar;
	private static Bullet curBullet;
	private static Cha curCha;
	public int Chx, Chy;
	public int bulnum;
	private int score;
	private int remainingTime;
    private JLabel timeLabel;
    private JLabel menu;
    
    private JLabel scoreLabel;
    private Timer gameTimer;
    private boolean gameRunning;
    private boolean shot = false;
    private boolean shot2 = false;
   
	public HW1() {
		
		super("HW#1 코딩을 해라!");
		Rand r = new Rand();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyHandler());
		setSize(new Dimension(600,600));


		bulnum  = 0;
		gameRunning = true;
		
		c.add(cars[0] = new Car(0+1, Rand.r(3, 10)));

		
		setVisible(true);
		c.add(curBullet = new Bullet(1, 10));
		c.add(curCha = new Cha(1, 10));

		curCar = cars[0];
		
		System.out.printf("<%d X %d>\n",c.getWidth(),c.getHeight());


		timeLabel = new JLabel("Time: 1:30");
        timeLabel.setBounds(50, c.getHeight() - 50,200, 20);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        c.add(timeLabel);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(50, c.getHeight() - 100, 2000, 20);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 25));
        c.add(scoreLabel);

        menu = new JLabel("총알선택 숫자 1~5번");
        menu.setBounds(50, c.getHeight() - 550, 2000, 20);
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(menu);
        
        menu = new JLabel("캐릭터 선택 숫자 Q, W, E, R");
        menu.setBounds(50, c.getHeight() - 500, 2000, 20);
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        c.add(menu);
        
        scoreLabel.setText("Score: " + 0);
        remainingTime = 90;

        initializeGame();
        updateLabels();
		
        c.requestFocus();
        shot = false; 
		
        while (true) {
            if (curBullet.th.getState() == State.TERMINATED &&
                curCha.th.getState() == State.TERMINATED &&
                curCar.th.getState() == State.TERMINATED) {
                initializeGame();  // 게임이 종료되면 게임을 초기화하고 재실행
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gameTimer.purge() > 0) {
                // 대기 중인 작업이 있다면
                gameTimer.cancel();
                gameRunning = false;
            }

            
        }
        
 
		//
		//while(curBullet.th.getState() != State.TERMINATED || curCha.th.getState() != State.TERMINATED|| curCar.th.getState() != State.TERMINATED);
	}

	private void addNewCars() {
	    // 새로운 차량을 생성하고 화면에 추가하는 로직
	    for (int i = 0; i < 2; i++) {
	        int randomPosition = Rand.r(0, 3);
	        c.add(cars[i] = new Car(randomPosition + 1, Rand.r(3, 10)));
	    }
	}
	private void removeCar() {
	    setVisible(false);
	    c.remove(this);
	}
	private void updateLabels() {
        timeLabel.setText("Time: " + String.format("%d:%02d", remainingTime / 60, remainingTime % 60));
        scoreLabel.setText("Score: " + score);
    }
	private void initializeGame() {
        remainingTime = 90;
        score = 0;
        scoreLabel.setText("Score: " + score);

        if (gameTimer != null) {
            gameTimer.cancel();  // 이전 타이머가 있다면 중지
        }
        
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    remainingTime--;
                    updateLabels();
                } else {

                    
                    gameTimer.cancel();  // 시간이 0이 되면 타이머 종료
                    gameRunning = false;  // 게임 중단

                    // 게임 중단 또는 종료 로직을 추가할 수 있음
                }
            }
        }, 1000, 1000);

        updateLabels();
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
			y = (position-1)*80;
			setIcon(car_icon);
			setBounds(x, y, 80, 80);
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
			int u,d,l,r;
			int Po;
			
			while(true) {

				Po = Rand.r(0, 3);
				switch(Po) {
				
				case 0:
					if (y+speed<0) y = 1;
					y+= speed;
					setPosition();
					break;
				case 1:
					if(y-speed+car_icon.getIconHeight() > c.getWidth()) y = 1;
					y-= speed;
					setPosition();
					break;

				case 2:
					if (x-speed<0) x = 1;
					else x-= speed;
					setPosition();
					break;
					
				case 3:
				if(x+speed > c.getWidth()) x = 1;
				else { x+= speed;
				x+= speed;
				x+= speed;
				}
				setPosition();
					break;
					
				}
				/*
				if(x+speed > c.getWidth()) x = 5;
				else x+= speed;
				setPosition();
				*/
				
				

				try {
					Thread.sleep(30);
		            //System.out.println(x+ " " + y);
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

			setBounds(x, y, 80,80);
//			blink = new Blinking(this);
			
			th = new Thread(this);
			th.start();
//			blink.start();
			
		}
	    private void checkCollision() {
	        if (getBounds().intersects(curCar.getBounds())) {
	            y = c.getHeight() - icon.getIconHeight();

				shot = false;
				
				curBullet.setVisible(false);

	            fired = false;
	            

	            score ++;
	            
	            
	            curCar.DoBlink();
	            curCar.setIcon(carIcons[Rand.r(0,4)]);
	            try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            curCar.DoBlink();

	            
	            setPosition2();
	            
	        }
	        shot2 = false;
	    }
		
		public void setPosition() {
			setLocation(x, y);
		}
		public void setPosition2() {
			shot = false;
			shot2 = false;
			curBullet.setVisible(false);
			
			setLocation(curCha.getX(), y);
			x = curCha.getX();

		}

		public void DoBlink() {
			blink.doBlinking();
		}
		public void Fire() {
			fired = true;
			th.interrupt();
		}
		public void Left() {
			if (bulnum == 2) {
				x-= speed;
				setPosition();
			}else if (x-speed<0|| fired ) {
				 return;
			}else {
			x-= speed;
			setPosition();
			}
			}
		public void Right() {
			if (bulnum == 2) {
				x+= speed;
				setPosition();
			}
			else if(x+speed+icon.getIconWidth() > c.getWidth() || fired ) {return;
			}else {
				x+= speed;
				setPosition();
			}

		}
		
		public void run() {
				while(true) {
					if (fired) {
						
						while(fired) {
							
							if (y-speed < 0) {
								checkCollision();
								checkCollision();
								checkCollision();
								checkCollision();
								checkCollision();
								y = c.getHeight() - icon.getIconHeight();
								checkCollision();
								checkCollision();
								checkCollision();
								checkCollision();
								fired = false;
								setPosition2();
								break;
							}
							else y -= speed;
							setPosition();
							try {
								if (bulnum == 1) {
								Thread.sleep(10);
								}else if (bulnum == 2){
									Thread.sleep(35);
								}else if (bulnum == 3){
									int php = 0;
									php = Rand.r(0,3);
									
									switch(php) {
									case 0:
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										break;
									case 1:
										Thread.sleep(5);
										x-= speed;
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										break;
									case 2:
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										break;
									case 3:
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										Thread.sleep(5);
										x+= speed;
										setPosition();
										Thread.sleep(5);
										x-= speed;
										setPosition();
										break;
									}
									
									
								
								}else if (bulnum == 4){
									Thread.sleep(4);
									x+= speed;
									x+= speed;
									x+= speed;
									x+= speed;
									x+= speed;
									x+= speed;
									x+= speed;
									x+= speed;

									setPosition();
									Thread.sleep(4);
									x-= speed;
									x-= speed;
									x-= speed;
									x-= speed;
									x-= speed;
									x-= speed;
									x-= speed;
									x-= speed;

									setPosition();
								}
								else {
									Thread.sleep(22);
								}
							} catch (InterruptedException e) {
								setPosition2();
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
	
	
	public class Cha extends JLabel {
		private ImageIcon icon;
		public int speed, position;
		private Blinking blink;
		private boolean fired;
		private Thread th;
		
		
		public Cha(int p, int s) {
			speed = s;
			position = p;
			icon = character[p-1];
			Chx = c.getWidth()/2;
			Chy = c.getHeight()-icon.getIconHeight();
			setIcon(icon);

			setBounds(Chx, Chy, 80,80);

//			blink.start();
		}
		public void setPosition() {
			setLocation(Chx, Chy);
		}


		public void Left() {
			if (Chx-speed<0 || fired) return;
			Chx-= speed;
			setPosition();
		}
		public void Right() {
			if(Chx+speed+icon.getIconWidth() > c.getWidth() || fired ) return;
			Chx+= speed;
			setPosition();
		}
	}
	
	private class menu extends JLabel{
		public menu(){
			setText("점수 : "+score);
			
		}
	}
	

	public class Blinking extends Thread {
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
							sleep(110);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block

						
							break;
						}
						blinking = !blinking;
					}
					comp.setVisible(true);
					
				}
				try {
					sleep(2000);
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

			case KeyEvent.VK_LEFT:
				if (remainingTime > 0) {
				curBullet.Left();
				curCha.Left();
				gameRunning = true;
				updateLabels();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (remainingTime > 0) {
				curBullet.Right();
				curCha.Right();
				gameRunning = true;
				updateLabels();
				}
				break;

			case KeyEvent.VK_SPACE:
				if (remainingTime > 0) {
					if(shot2 == false) {
						shot = true;
						shot2 = true;
						curBullet.setVisible(true);
	                    curBullet.Fire();
	                    gameRunning = true;
	                    updateLabels();
					}
                }

                break;
			 case KeyEvent.VK_ESCAPE:
				 if (remainingTime ==  0) {
				 currentBgIndex = (currentBgIndex + 1) % bgs.length;
				 initializeGame();  // ESC 키로 게임 초기화
				 c.repaint();
				 }
                 break;
                 
			 case KeyEvent.VK_1:
				 curBullet.setIcon(bulletIcons[0]);
				 bulnum  = 0;
					break;
			 case KeyEvent.VK_2:
				 curBullet.setIcon(bulletIcons[1]);
				 bulnum  = 1;
					break;
			 case KeyEvent.VK_3:
				 curBullet.setIcon(bulletIcons[2]);
				 bulnum  = 2;
					break;
			 case KeyEvent.VK_4:
				 curBullet.setIcon(bulletIcons[3]);
				 bulnum  = 3;
					break;
			 case KeyEvent.VK_5:
				 curBullet.setIcon(bulletIcons[4]);
				 bulnum  = 4;
				 	break;
			 case KeyEvent.VK_Q:
				 curCha.setIcon(character[0]);

					break;
			 case KeyEvent.VK_W:
				 curCha.setIcon(character[1]);

					break;
			 case KeyEvent.VK_E:
				 curCha.setIcon(character[2]);

					break;
			 case KeyEvent.VK_R:
				 curCha.setIcon(character[3]);

					break;

			default:
				break;
			}
		}
	}
	public static void main(String[] args) {
		new HW1();
	}
	private class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			ImageIcon imgIcon = bgs[currentBgIndex];
	        Image bgIcon = imgIcon.getImage();

	        g.drawImage(bgIcon, 0, 0, c.getWidth(), c.getHeight(), this);


			
		}
	}
}

