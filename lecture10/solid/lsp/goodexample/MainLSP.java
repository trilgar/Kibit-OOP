package lecture10.solid.lsp.goodexample;


// Головний клас для демонстрації
public class MainLSP {
    public static void main(String[] args) {
        BirdWatcher watcher = new BirdWatcher();

        Sparrow sparrow = new Sparrow();  // Горобець, який може літати
        Penguin penguin = new Penguin();  // Пінгвін, який не може літати

        // Спостерігаємо за польотом горобця
        watcher.watchBirdFly(sparrow);

        // Пінгвін не передається в метод спостереження за польотом, оскільки він не реалізує Flyable
        penguin.swim();  // Пінгвін плаває замість польоту
    }
}

// Базовий клас птахів
class Bird {
    public void eat() {
        System.out.println("This bird is eating");
    }
}

// Інтерфейс для птахів, які можуть літати
interface Flyable {
    void fly();
}

// Підклас Sparrow, який може літати
class Sparrow extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Підклас Penguin, який не може літати
class Penguin extends Bird {
    // Пінгвін має лише методи, які не включають політ
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

// Клас, який взаємодіє з птахами, що можуть літати
class BirdWatcher {
    public void watchBirdFly(Flyable bird) {
        bird.fly();
    }
}
