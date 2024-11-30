package lecture16.example7;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsExample {
    public static void main(String[] args) {
        HashSet<String> firstSet = new HashSet<String>();
        HashSet<String> secondSet = new HashSet<String>();

        firstSet.add("John");
        firstSet.add("Elliot");
        firstSet.add("Mary");

        secondSet.add("John");
        secondSet.add("Elliot");

        if (firstSet.containsAll(secondSet)) {
            System.out.println("secondSet is a subset of firstSet");
        } else {
            System.out.println("secondSet is not a subset of firstSet");
        }


        secondSet.add("Tom");
        Set<String> unionSet = new HashSet<String>(firstSet);
        unionSet.addAll(secondSet);
        System.out.println("\nUnion set:");
        for (String s : unionSet) {
            System.out.println(s);
        }



        Set<String> intersectionSet = new HashSet<String>(firstSet);
        intersectionSet.retainAll(secondSet);
        System.out.println("\nIntersection set:");
        for (String s : intersectionSet) {
            System.out.println(s);
        }


        Set<String> differenceSet = new HashSet<String>(firstSet);
        differenceSet.removeAll(secondSet);
        System.out.println("\nDifference set:");
        for (String s : differenceSet) {
            System.out.println(s);
        }
    }
}
