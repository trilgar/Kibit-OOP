package lecture16.example5;

public class GenApp {
    private static <T> void printarray(T[] a) {
        for (Object o : a) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Integer[] iarr = new Integer[3];
        iarr[0] = 10;
        iarr[1] = 20;
        iarr[2] = 30;
        printarray(iarr);

        Float[] farr = new Float[3];
        farr[0] = 48.0f;
        farr[1] = 59.0f;
        farr[2] = 67.0f;
        printarray(farr);

        String[] sarr = new String[3];
        sarr[0] = "apple";
        sarr[1] = "banana";
        sarr[2] = "cherry";
        printarray(sarr);
    }
}

