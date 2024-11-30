package lecture16.example7;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashList = new HashSet<String>();
        String s1 = "John";
        String s2 = "Elliot";
        System.out.println("Added = " + hashList.add(s1));
        System.out.println("Added = " + hashList.add(s2));
        System.out.println("Added = " + hashList.add(s2)); // дублікати не додаються
    }
}