package lecture16.example13;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcard {
    public void addNumber(List<? super Integer> list, Integer number) {
        list.add(number);
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        LowerBoundedWildcard example = new LowerBoundedWildcard();
        example.addNumber(numbers, 1);
        example.addNumber(numbers, 2);
        System.out.println(numbers); // [1, 2]

        List<Object> objects = new ArrayList<>();
        example.addNumber(objects, 3);
        example.addNumber(objects, 4);
        System.out.println(objects); // [3, 4]

        List<Double> doubles = new ArrayList<>();
        // example.addNumber(doubles, 5); // compilation error
    }
}

