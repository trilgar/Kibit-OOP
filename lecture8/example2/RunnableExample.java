package lecture8.example2;

class MyRunnable implements Runnable {
    String myName;

    MyRunnable(String myName) {
        this.myName = myName;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(myName + i + " at " + System.currentTimeMillis());
            Thread.yield();
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Runnable rA = new MyRunnable("A:");
        Runnable rB = new MyRunnable("\t\t\tB:");
        Thread tA = new Thread(rA);
        Thread tB = new Thread(rB);
        tA.start();
        tB.start();
        new Thread(new MyRunnable("\t\t\t\t\t\tC:")).start();
    }
}
