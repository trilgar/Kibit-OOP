package lecture4.example35;

public class Main {
}

interface Colourable {
    int RED = 1;
    int GREEN = 2;
    int BLUE = 3;
    void setColour(int c);
    int getColour();
}

// приклад абстрактного класу, який реалізує інтерфейс
abstract class ColourTest implements Colourable {
    int i;
    ColourTest() {}

    @Override
    public void setColour(int c) {
        i = c;
    }
}

// приклад абстрактного класу, який має абстрактний метод
abstract class Painter {
    int i;
    Painter() {}

    public void setColour(int c) {
        i = c;
    }

    public abstract int paintWalls();
}
