package lecture12.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlyweightExample {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Садимо дерева з використанням легковаговиків
        forest.plantTree(10, 20, "Oak", "Green", "Thick bark");
        forest.plantTree(15, 25, "Pine", "Dark Green", "Rough bark");
        forest.plantTree(10, 20, "Oak", "Green", "Thick bark");
        forest.plantTree(50, 80, "Pine", "Dark Green", "Rough bark");
        forest.plantTree(70, 90, "Birch", "Light Green", "Smooth bark");

        // Малюємо всі дерева
        forest.draw();
    }
}

// Клас-легковаговик, що містить спільний стан
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing a " + name + " tree of color " + color + " at (" + x + ", " + y + ")");
    }
}

// Фабрика для управління легковаговиками
class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        TreeType type = treeTypes.get(key);
        if (type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.put(key, type);
        }
        return type;
    }
}

// Контекстний клас, що зберігає унікальний стан кожного дерева
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

// Ліс, що містить багато дерев
class Forest {
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

