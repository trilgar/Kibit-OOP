package lecture11.prototype;

import java.util.HashMap;
import java.util.Map;
public class PrototypeExample {
    public static void main(String[] args) {
        ShapeRegistry registry = new ShapeRegistry();

        // Додаємо оригінальні форми до реєстру
        registry.addShape("circle", new Shape("Circle"));
        registry.addShape("square", new Shape("Square"));

        // Створюємо копії форм
        Shape clonedCircle = (Shape) registry.getShape("circle");
        Shape clonedSquare = (Shape) registry.getShape("square");

        // Використовуємо копії
        clonedCircle.draw();
        clonedSquare.draw();
    }
}

// Інтерфейс Prototype
// Цей інтерфейс доданий для демонстрації. Насправді метод clone() вже є в класі Object тому його не потрібно додавати в інтерфейс
interface Prototype extends Cloneable {
    Prototype clone();
}

// Конкретний клас, що реалізує інтерфейс Prototype
class Shape implements Prototype {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public Shape(Shape shape) {
        this.type = shape.type;
    }

    @Override
    public Shape clone() {
        return new Shape(this);
    }

    public void draw() {
        System.out.println("Drawing a " + type);
    }
}

// Клас для зберігання та створення прототипів
class ShapeRegistry {
    private Map<String, Prototype> shapes = new HashMap<>();

    public void addShape(String key, Prototype shape) {
        shapes.put(key, shape);
    }

    public Prototype getShape(String key) {
        return shapes.get(key).clone();
    }
}
