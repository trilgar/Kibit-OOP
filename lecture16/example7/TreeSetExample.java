package lecture16.example7;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("TreeSet: " + numbers);

        // Найменший елемент
        System.out.println("Lowest: " + numbers.first());

        // Найбільший елемент
        System.out.println("Highest: " + numbers.last());

        // Елемент, менший за 25
        System.out.println("Lower than 25: " + numbers.lower(25));

        // Елемент, більший за 25
        System.out.println("Higher than 25: " + numbers.higher(25));
    }
}
