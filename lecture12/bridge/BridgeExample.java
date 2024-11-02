package lecture12.bridge;

public class BridgeExample {
    public static void main(String[] args) {
        // Створення червоного кола
        Color red = new RedColor();
        Shape redCircle = new Circle(red);
        redCircle.draw();

        // Створення синього квадрата
        Color blue = new BlueColor();
        Shape blueSquare = new Square(blue);
        blueSquare.draw();
    }
}

// Абстракція - фігура
abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Конкретна абстракція - Круг
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle in color: ");
        color.applyColor();
    }
}

// Конкретна абстракція - Квадрат
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Square in color: ");
        color.applyColor();
    }
}

// Реалізація - Колір
interface Color {
    void applyColor();
}

// Конкретна реалізація - Червоний колір
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red");
    }
}

// Конкретна реалізація - Синій колір
class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Blue");
    }
}
