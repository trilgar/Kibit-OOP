package lecture8.example5;

class MyRunnable implements Runnable {
    String myName;

    MyRunnable(String myName) {
        this.myName = myName;
    }

    public void run() {
        System.out.println("Hello from " + myName + " at " + System.currentTimeMillis());
//        for(;;);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        System.out.println("Begin main()");
        Runnable rA = new MyRunnable("A:");
        Thread tA = new Thread(rA);
        tA.start();
        try {
            tA.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End main()");
    }
}
