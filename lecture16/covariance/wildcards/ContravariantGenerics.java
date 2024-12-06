package lecture16.covariance.wildcards;

import java.util.ArrayList;
import java.util.List;

public class ContravariantGenerics {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add("Hello");

        List<? super String> superStrings = objects; // Дозволено

        superStrings.add("New String"); // Дозволено: можна додати String
        // Object obj = superStrings.get(0); // Помилка компіляції: тип невідомий
    }
}
