package lecture16.example15;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFabrics {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        Set<Integer> set = Set.of(1, 2, 3);
        Map<String, Integer> map = Map.of("A", 1, "B", 2);
    }
}
