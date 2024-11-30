package lecture16.example9;

import java.util.ArrayList;
import java.util.Collections;

public class SortExample {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("One");
        nameList.add("Two");
        nameList.add("Three");

        System.out.println("Before Sorting");
        for (String s : nameList) System.out.println(s);

        Collections.sort(nameList);

        System.out.println("\nAfter Sorting");
        for (String s : nameList) System.out.println(s);
    }
}
