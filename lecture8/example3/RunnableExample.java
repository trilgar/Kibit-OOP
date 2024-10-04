package lecture8.example3;

class MyRunnable implements Runnable {
    String myName;

    MyRunnable(String myName) {
        this.myName = myName;
    }

    public void run() {
        System.out.println("Hello from " + myName + " at " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Someone interrupted me! I was sleeping!");
        }
        System.out.println("Goodbye from " + myName + " at " + System.currentTimeMillis());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Runnable rA = new MyRunnable("A:");
        Thread tA = new Thread(rA);
        tA.start();
        tA.interrupt();
    }
}
