import java.lang.Thread.State;

import javax.swing.plaf.synth.SynthColorChooserUI;

public class Thread_SUM {
	static Integer num = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NUM n = new NUM();
		
		Summation th1 = new Summation("S1", n);
		Summation th2 = new Summation("S2", n);
		Summation th3 = new Summation("S3", n);
	
		while(th1.th.getState() != State.TERMINATED || th2.th.getState() != State.TERMINATED|| th3.th.getState() != State.TERMINATED);
		
		System.out.printf("SUN : %s \n", n);
	}

}
class NUM{
	private int num;
	public NUM() {
		num = 0;
	}
	synchronized public void add() {
		num ++;
	}
	public String toString() {
		return num+"";
	}
}

class Summation implements Runnable{
	String name;
	Thread th;
	NUM nn;
	public Summation(String n, NUM nu) {
		name = n;
		nn = nu;
		th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(5);
				/*
				synchronized(Thread_SUM.num) {
					Thread_SUM.num++;
					
				
				}
				*/
			nn.add();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
				System.out.printf("[Thread %s] %s \n", name , nn);
		}
	}
}