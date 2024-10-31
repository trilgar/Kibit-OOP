package lecture11.abstractfabric;



public class AbstractFabricExample {
    public static void main(String[] args) {
        // Створення фабрики меблів стилю Модерн
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();
        CoffeeTable modernTable = modernFactory.createCoffeeTable();

        modernChair.sitOn();
        modernSofa.lieOn();
        modernTable.placeItems();

        // Створення фабрики меблів стилю Вікторіанський
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair victorianChair = victorianFactory.createChair();
        Sofa victorianSofa = victorianFactory.createSofa();
        CoffeeTable victorianTable = victorianFactory.createCoffeeTable();

        victorianChair.sitOn();
        victorianSofa.lieOn();
        victorianTable.placeItems();
    }
}

// Інтерфейс для Крісло
interface Chair {
    void sitOn();
}

// Інтерфейс для Диван
interface Sofa {
    void lieOn();
}

// Інтерфейс для Столик
interface CoffeeTable {
    void placeItems();
}

// Реалізації крісла для стилю Модерн
class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

// Реалізації крісла для стилю Вікторіанський
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

// Реалізації дивану для стилю Модерн
class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a modern sofa.");
    }
}

// Реалізації дивану для стилю Вікторіанський
class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Victorian sofa.");
    }
}

// Реалізації столика для стилю Модерн
class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a modern coffee table.");
    }
}

// Реалізації столика для стилю Вікторіанський
class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a Victorian coffee table.");
    }
}

// Абстрактна фабрика для створення меблів
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Конкретна фабрика для створення меблів стилю Модерн
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

// Конкретна фабрика для створення меблів стилю Вікторіанський
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

