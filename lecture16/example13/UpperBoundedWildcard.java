package lecture16.example13;

import java.util.List;

public class UpperBoundedWildcard {
    public void sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5, 3.5);

        UpperBoundedWildcard example = new UpperBoundedWildcard();
        example.sumNumbers(integers); // Sum: 6.0
        example.sumNumbers(doubles);  // Sum: 7.5
    }
}
