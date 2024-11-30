package lecture16.example9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DescendComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());

        // Порівнюємо символи по одному
        for (int i = 0; i < minLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                return c2 - c1; // Зворотний порядок: c2 - c1 для спадання
            }
        }

        // Якщо всі символи однакові, порівнюємо довжину рядків
        return s2.length() - s1.length(); // Зворотний порядок: довший рядок більший
    }
}
public class CustomComparatorExample {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<String>();
        DescendComparator sComp = new DescendComparator();

        nameList.add("One");
        nameList.add("Two");
        nameList.add("Three");

        System.out.println("Before Sorting");
        for (String s : nameList) System.out.println(s);

        Collections.sort(nameList, sComp);

        System.out.println("\nAfter Sorting");
        for (String s : nameList) System.out.println(s);
    }
}
