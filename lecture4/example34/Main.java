package lecture4.example34;

public class Main {
    public static void main(String args[]) {
        SalesManager sm = new SalesManager("Sara");
        if (sm.takeOrder())
            if (sm.authorize()) {
                sm.collectPayment();
            }
    }
}


interface Manage {
    boolean authorize();
}

class Employee {
    String name;

    Employee() {
    }

    String getName() {
        return name;
    }
}

class SalesPerson extends Employee {
    boolean takeOrder() {
        return true;
    }

    void collectPayment() {
        System.out.println("Payment collected");
    }
}

class SalesManager extends SalesPerson implements Manage {
    SalesManager(String n) {
        name = n;
    }

    @Override
    public boolean authorize() {
        // authorisation by a sales manager
        return true;
    }
}

interface Colourable {
    int RED = 1;
    int GREEN = 2;
    int BLUE = 3;
    void setColour (int c);
    int getColour();
}