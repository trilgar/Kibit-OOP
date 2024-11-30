package lecture16.example10;

import java.util.ArrayList;

public class SearchExample {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("One");
        nameList.add("Two");
        nameList.add("Three");
        nameList.add("Four");
        nameList.add("Five");

        int pos = nameList.indexOf("Two");
        System.out.println("Index of 'Two': " + pos);

        boolean doesExist = nameList.contains("Two");
        System.out.println("'Two' exists: " + doesExist);
    }
}
