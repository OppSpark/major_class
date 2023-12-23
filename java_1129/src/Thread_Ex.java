import java.lang.Thread.State;
import java.util.Vector;

public class Thread_Ex {

	public static void main(String[] args) throws InterruptedException {
		Vector<MyThread> 	threads = new Vector<>();
		int		cnt = Rand.r(5, 10);

		for(int i=0;i < cnt;i++) {
			threads.add(new MyThread("TH_"+(i+1)));
			threads.get(i).start();  //쓰레드 실행
			System.out.printf("[%s] started\n", "TH_"+i);
		}
		Thread.sleep(3000);
		//	for(MyThread th:threads)
		//		th.interrupt();
		for(MyThread th:threads) 
			th.run = false;
	
		boolean run = true;  //다른쓰레드가 가 끝났는지 확인하는쓰레드 
		while(run) {
			run = false;
			for(int i=0;i < cnt;i++) {
				if (threads.get(i).getState() != State.TERMINATED) {  //쓰레드의 현대 상태를 확인)
					run = true;
					break;
				}
			}
		}

		System.out.println("END.");
	}
}
class MyThread extends Thread {
	private String	ID;
	boolean run;
	public MyThread(String n) {
		ID = n;
		run = true;
	}
	public void Stop() { run = false; }
	public void run() {
		int 	n=0;
		
		while(run) {
			try {
				sleep(Rand.r(500, 1000));
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