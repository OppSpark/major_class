import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ThreadPoolExecutor;

public class Thread_Ex {
    public static void main(String[] args) throws InterruptedException {
        Vector<MyThread> threads = new Vector<>();
        int cnt = Rand.r(5, 10);
        for (int i = 0; i < cnt; i++) {
            threads.add(new MyThread("TH_" + (i + 1)));
            threads.get(i).start();
        }
        Thread.sleep(5000);
        for (MyThread th : threads) {
            th.interrupt();
        }

    }

    static class MyThread extends Thread {
        private String ID;
        private boolean run;

        public MyThread(String n) {
            ID = n;
            run = true;
        }

        public void Stop() {
            run = false;
        }

        public void run() {
            int n = 0;
            while (run) {
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
}