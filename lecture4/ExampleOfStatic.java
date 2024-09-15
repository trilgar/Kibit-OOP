package lecture4;

public class ExampleOfStatic {
    public static void main(String[] args) {
        Example obj1 = new Example();
        Example obj2 = new Example();
        System.out.println(Example.count); // Результат: 2
    }
}
class Example {
    static int count = 0; // Static змінна

    Example() {
        count++; // Збільшуємо значення для кожного нового екземпляра
    }
}