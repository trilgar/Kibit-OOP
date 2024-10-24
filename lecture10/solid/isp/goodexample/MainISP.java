package lecture10.solid.isp.goodexample;

// Головний клас для демонстрації
public class MainISP {
    public static void main(String[] args) {
        Working robot = new Robot();
        Working human = new Human();

        robot.work();
        human.work();

        Eating humanEating = (Eating) human; // Людина також їсть
        humanEating.eat();
    }
}

// Інтерфейс для робочої активності
interface Working {
    void work();
}

// Інтерфейс для харчування
interface Eating {
    void eat();
}

class Robot implements Working {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

class Human implements Working, Eating {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }
}


