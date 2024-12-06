package lecture16.covariance;

import java.util.ArrayList;
import java.util.List;

public class InvariantCollectionExample {
    public static void main(String[] args) {
        // List<String> не є підтипом List<Object>
        // List<Object> list = new ArrayList<String>(); // Помилка компіляції

        List<String> strings = new ArrayList<>();
        strings.add("Hello");


    }
}
