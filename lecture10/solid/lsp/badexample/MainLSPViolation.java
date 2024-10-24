package lecture10.solid.lsp.badexample;

// Головний клас для демонстрації
public class MainLSPViolation {
    public static void main(String[] args) {
        BirdWatcher watcher = new BirdWatcher();

        Bird sparrow = new Bird();  // Звичайний птах
        Bird penguin = new Penguin();  // Пінгвін, який не може літати

        watcher.watchBirdFly(sparrow);  // Це працює, бо горобець може літати
        watcher.watchBirdFly(penguin);  // Це призведе до помилки, бо пінгвін не може літати
    }
}


// Базовий клас птахів
class Bird {
    public void fly() {
        System.out.println("This bird is flying");
    }
}

// Підклас Pingvin, який є птахом, але не може літати
class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

// Клас, який взаємодіє з птахами
class BirdWatcher {
    public void watchBirdFly(Bird bird) {
        bird.fly();
    }
}

