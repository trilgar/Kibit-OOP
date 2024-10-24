package lecture10.solid.isp.badexample;

public class MainISP {
    public static void main(String[] args) {
        Worker robot = new Robot();
        Worker human = new Human();

        robot.eat();
        robot.work();

        human.eat();
        human.work();
    }
}

interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Робот не їсть, але змушений реалізувати цей метод
        throw new UnsupportedOperationException("Robots do not eat.");
    }
}

class Human implements Worker {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }
}

