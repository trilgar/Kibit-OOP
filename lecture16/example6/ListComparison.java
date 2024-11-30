package lecture16.example6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args) {
        // create array list and linked list. Compare how fast adding works.
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // add elements to the list
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1_000_000L; i++) {
            arrayList.add(i);
        }
        System.out.println("Time to add 1_000_000_000 elements to ArrayList: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 1_000_000L; i++) {
            linkedList.add(i);
        }
        System.out.println("Time to add 1_000_000_000 elements to LinkedList: " + (System.currentTimeMillis() - startTime) + " ms");


        // get element at the middle of the list
        startTime = System.nanoTime();
        arrayList.get(arrayList.size() / 2);
        System.out.println("Time to get element at the middle of ArrayList: " + (System.nanoTime() - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.get(linkedList.size() / 2);
        System.out.println("Time to get element at the middle of LinkedList: " + (System.nanoTime() - startTime) + " ns");

    }
}
