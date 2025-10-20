package genericexampletasks.linkedlist;

public class Main2 {

    // Головний метод для демонстрації
    public static void main(String[] args) {
        // 1. Створюємо список рядків
        MiniLinkedList<String> studentList = new MiniLinkedList<>();

        // 2. Додаємо студентів
        studentList.add("Олена");
        studentList.add("Максим");
        studentList.add("Ірина");

        // 3. Отримуємо елемент
        System.out.println("Студент за індексом 1: " + studentList.get(1)); // Максим

        // 4. Виводимо розмір
        System.out.println("Загальна кількість студентів: " + studentList.size()); // 3

        System.out.println("--------------------");

        // 5. Створюємо список чисел
        MiniLinkedList<Integer> numberList = new MiniLinkedList<>();
        numberList.add(100);
        numberList.add(200);

        System.out.println("Число за індексом 0: " + numberList.get(0)); // 100
        System.out.println("Розмір списку чисел: " + numberList.size()); // 2
    }
}

class MiniLinkedList<T> {

    // 1. Внутрішній статичний клас Node
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // 2. Поля MiniLinkedList
    private Node<T> head; // Голова (перший елемент)
    private int size;

    // 2. Конструктор
    public MiniLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 3. Метод add (додає в кінець)
    public void add(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            // Випадок 1: Список порожній
            head = newNode;
        } else {
            // Випадок 2: Список не порожній
            // Потрібно знайти останній елемент
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            // current тепер - це останній вузол
            current.next = newNode;
        }
        size++;
    }

    // 4. Метод get
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс: " + index + ", Розмір: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // 5. Метод size
    public int size() {
        return size;
    }
}