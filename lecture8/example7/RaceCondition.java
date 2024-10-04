package lecture8.example7;

public class RaceCondition {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(bank);
        t1.start();
        t2.start();
    }
}

class Bank implements Runnable {
    int a = 500;
    int b = 500;

    void transactAB(int c) {
        a = a - c;
        b = b + c;
    }

    void transactBA(int c) {
        a = a + c;
        b = b - c;
    }

    void transactRandom() {
        int c;
        if (Math.random() > 0.5) {
            transactAB(c = (int) (Math.random() * a));
        } else {
            transactBA(c = (int) (Math.random() * b));
        }
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            transactRandom();
        }
        System.out.println("a=" + a + " b=" + b
                + " sum=" + (a + b));
    }
}

