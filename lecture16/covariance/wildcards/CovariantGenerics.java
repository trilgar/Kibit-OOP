package lecture16.covariance.wildcards;

import java.util.ArrayList;
import java.util.List;

public class CovariantGenerics {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");

        List<? extends Object> objects = strings; // Дозволено

        // objects.add("New"); // Помилка компіляції: не можна додати елементи
        Object obj = objects.get(0); // Дозволено: отримуємо елемент як Object
        System.out.println(obj);
    }
}