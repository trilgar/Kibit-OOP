package lecture4;

public class ExampleOfFinal {
    final int constantValue = 100; // Значення ініціалізується і не може бути змінено

    public void changeValue() {
        // constantValue = 200; // Це викличе помилку компіляції
    }
}
