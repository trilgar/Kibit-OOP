package genericexampletasks.arraylist;

public class Main {
    public static void main(String[] args) {
        // 2. Створення сховища для рядків
        FixedSizeStorage<String> taskStorage = new FixedSizeStorage<>(3);

        // 3. Заповнення
        taskStorage.set(0, "Написати код");
        taskStorage.set(1, "Випити кави");
        taskStorage.set(2, "Пояснити Generics");

        System.out.println("Завдання 1: " + taskStorage.get(0));

        // 5. Створення сховища для сенсорів
        FixedSizeStorage<SensorReading> sensorLog = new FixedSizeStorage<>(5);

        // 6. Заповнення
        sensorLog.set(0, new SensorReading("temp-01", 22.5));
        sensorLog.set(1, new SensorReading("humidity-01", 45.1));

        // 7. Отримання
        SensorReading reading = sensorLog.get(1);
        System.out.println("Показник сенсора: " + reading); // Викличе toString()

        // Демонстрація типобезпечності (помилка компіляції)
        // taskStorage.set(0, new SensorReading("id", 1.0)); // Не скомпілюється!

        // 4. Демонстрація винятку
        try {
            taskStorage.set(3, "Заховатись від студентів");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Спіймали очікуваний виняток: " + e.getMessage());
        }
    }
}
// 1. Допоміжний клас
class SensorReading {
    String sensorId;
    double value;

    SensorReading(String sensorId, double value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "sensorId='" + sensorId + '\'' +
                ", value=" + value +
                '}';
    }
}

// 1. Створення класу
class FixedSizeStorage<T> {

    // 2. Поле з масивом
    private T[] items;
    // 3. Поле ємності
    private int capacity;

    // 4. Конструктор
    @SuppressWarnings("unchecked") // Поясніть студентам, чому це потрібно
    public FixedSizeStorage(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Розмір має бути додатним");
        }
        this.capacity = capacity;
        // Ми не можемо написати: new T[capacity]
        // Це пов'язано зі стиранням типів (type erasure)
        // Тому ми створюємо масив Object[] і приводимо його до T[]
        this.items = (T[]) new Object[capacity];
    }

    // 5. Метод set
    public void set(int index, T item) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + capacity);
        }
        items[index] = item;
    }

    // 6. Метод get
    public T get(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + capacity);
        }
        return items[index];
    }

    // 7. Метод getCapacity
    public int getCapacity() {
        return capacity;
    }
}