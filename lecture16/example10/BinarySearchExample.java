package lecture16.example10;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchExample {
    public static void main(String[] args) {
         ArrayList<String> nameList = new ArrayList<String>();
         nameList.add("One");
         nameList.add("Two");
         nameList.add("Three");
         nameList.add("Four");
         nameList.add("Five");
        System.out.println("Not Sorted List:");
        for (String s : nameList) {
            System.out.println(s);
        }

        int pos = Collections.binarySearch(nameList, "Four");
        System.out.println("Index of 'Four': " + pos); // -1 (not found because list is not sorted)


        nameList.sort(String::compareTo);
        System.out.println("Sorted List:");
        for (String s : nameList) {
            System.out.println(s);
        }

        pos = Collections.binarySearch(nameList, "Four");
        System.out.println("Index of 'Four': " + pos); // 1 (found on index 1)
    }
}
