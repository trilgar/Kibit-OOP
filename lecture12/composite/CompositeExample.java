package lecture12.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {
    public static void main(String[] args) {
        // Створюємо окремі продукти
        Product apple = new Product("Apple", 1.5);
        Product orange = new Product("Orange", 2.0);
        Product banana = new Product("Banana", 1.2);

        // Створюємо коробку з продуктами
        Box fruitBox = new Box();
        fruitBox.addItem(apple);
        fruitBox.addItem(orange);
        fruitBox.addItem(banana);

        // Створюємо ще одну коробку
        Product book = new Product("Book", 10.0);
        Box mixedBox = new Box();
        mixedBox.addItem(fruitBox);
        mixedBox.addItem(book);

        // Виводимо інформацію про коробки
        System.out.println(fruitBox);
        System.out.println(mixedBox);
    }
}

// Загальний інтерфейс для компонентів
interface Item {
    double getPrice();
}

// Продукт, який є "листом" в деревоподібній структурі
class Product implements Item {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}

// Коробка, яка є "контейнером" та може містити інші продукти або коробки
class Box implements Item {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Box containing:\n");
        for (Item item : items) {
            builder.append("  - ").append(item).append("\n");
        }
        builder.append("Total price: ").append(getPrice()).append("\n");
        return builder.toString();
    }
}

