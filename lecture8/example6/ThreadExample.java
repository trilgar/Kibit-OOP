package lecture8.example6;

public class ThreadExample {
    public static void main(String[] args) {
        Thread tA = new MyThread("A:");
        Thread tB = new MyThread("\t\t\t\t\tB:");
        tA.setPriority(tA.getPriority()-2);
        tB.setPriority(tA.getPriority()-1);
        tA.start();
        tB.start();
    }
}

class MyThread extends Thread {
    String myName;

    MyThread(String myName) {
        this.myName = myName;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(myName + i);
        }
    }
}