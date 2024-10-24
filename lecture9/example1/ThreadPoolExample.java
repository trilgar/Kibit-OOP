package lecture9.example1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPoolExample {
    private static final Logger logger = Logger.getLogger(ThreadPoolExample.class.getName());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        MyRunnable r1 = new MyRunnable("1", 100);
        MyRunnable r2 = new MyRunnable("\t2", 200);
        MyRunnable r3 = new MyRunnable("\t\t3", 300);
        MyRunnable r4 = new MyRunnable("\t\t\t4", 400);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);
        executor.execute(r4);


        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        List<Runnable> canceledTask = executor.shutdownNow();
        System.out.println("End of main");

    }
}

class MyRunnable implements Runnable {

    String name;
    int n;
    private static final Logger logger = Logger.getLogger(MyRunnable.class.getName());

    public MyRunnable(String name, int n) {
        this.name = name;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(name);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("No, I will work until I finish my job!");
            }
        }
    }

}