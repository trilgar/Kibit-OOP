package lecture16.example6;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        String s1 = "first";
        String s2 = "second";
        String s3 = "third";
        strList.add(s1);
        strList.add(s2);
        strList.add(s3);

        ArrayList<String> strList2 = new ArrayList<String>();
        strList2.addAll(strList);


        for (String s : strList) {
            System.out.println(s);
        }

        Iterator<String> iter = strList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
