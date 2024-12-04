package lecture16.example13;

import java.util.List;

public class UnboundedWildcard {
    public void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<String> strings = List.of("A", "B", "C");
        List<Integer> integers = List.of(1, 2, 3);

        UnboundedWildcard example = new UnboundedWildcard();
        example.printList(strings);  // A B C
        example.printList(integers); // 1 2 3
    }
}

