package lecture16.example7;

import java.util.HashSet;

public class DuplicateDetectionExample {
    public static void main(String[] args) {
        HashSet<String> hashList = new HashSet<String>();
        String sArray[] = new String[6];
        sArray[0] = "John";
        sArray[1] = "Francis";
        sArray[2] = "Elliot";
        sArray[3] = "Francis";
        sArray[4] = "Mary";
        sArray[5] = "John";

        for (int i = 0; i < 6; i++) {
            if (hashList.add(sArray[i]) == false) {
                System.out.println("Duplicate found: " + sArray[i]);
            } else {
                System.out.println("Added: " + sArray[i]);
            }
        }
    }
}
