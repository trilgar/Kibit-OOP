package lecture16.covariance;

public class ArraysExample {
    public static void main(String[] args) {
        // Масив типу Object може містити елементи String
        Object[] array = new String[5];

        // Додаємо String - дозволено
        array[0] = "Hello";

        // Спроба додати Integer - компілятор дозволить, але буде помилка виконання
        array[1] = 123; // ArrayStoreException під час виконання
    }
}
