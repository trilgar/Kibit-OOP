package lecture16.example14;

import java.util.ArrayList;
import java.util.List;

public class NotThreadSafeCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Звичайний список.

        // Потік для додавання елементів
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Added: " + i);
                try {
                    Thread.sleep(100); // Затримка для симуляції багатопоточності
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Потік для ітерації по списку
        Thread reader = new Thread(() -> {
            while (true) {
                for (Integer num : list) {
                    System.out.println("Read: " + num);
                    try {
                        Thread.sleep(50); // Затримка під час читання
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writer.start();
        reader.start();

        // виникає ConcurrentModificationException через те, що один потік змінює список, а інший читає його
        // для вирішення цієї проблеми можна використати Collections.synchronizedList
    }
}

