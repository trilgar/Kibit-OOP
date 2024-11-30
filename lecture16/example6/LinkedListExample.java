package lecture16.example6;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> strList = new LinkedList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        strList.add(s1);
        strList.add(s2);
        strList.add(s3);

        LinkedList<String> strList2 = new LinkedList<String>();
        strList2.addAll(strList);
    }
}
