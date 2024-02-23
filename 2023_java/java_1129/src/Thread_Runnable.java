import java.lang.Thread.State;
import java.util.Vector;

public class Thread_Runnable {

	public static void main(String[] args) throws InterruptedException {
		Vector<MyThread_Run> 	threads = new Vector<>();
		int		cnt = Rand.r(5, 10);

		for(int i=0;i < cnt;i++) {
			threads.add(new MyThread_Run("TH_"+(i+1)));

			System.out.printf("[%s] started\n", "TH_"+i);
		}
		Thread.sleep(3000);
		//	for(MyThread th:threads)
		//		th.interrupt();
		for(MyThread_Run th:threads) 
			th.run = false;
	
		boolean run = true;  //다른쓰레드가 가 끝났는지 확인하는쓰레드 
		while(run) {
			run = false;
			for(int i=0;i < cnt;i++) {
				if (threads.get(i).th.getState() != State.TERMINATED) {  //쓰레드의 현대 상태를 확인)
					run = true;
					break;
				}
			}
		}

		System.out.println("END.");
	}
}
class MyThread_Run implements Runnable {
	private String	ID;
	boolean run;
	Thread th;
	public MyThread_Run(String n) {
		ID = n;
		run = true;
		th = new Thread(this);
		th.start();
		
		
	}
	public void Stop() { run = false; }
	public void run() {
		int 	n=0;
		
		while(run) {
			try {
				Thread.sleep(Rand.r(500, 1000));
				n++;
				System.out.printf("[%s] %d\n", ID, n);
			} catch (InterruptedException e) {
				System.out.printf("[%s] Interrupted\n", ID);
				return;
			}
		}
		System.out.printf("[%s] Completed\n", ID);
	}
}