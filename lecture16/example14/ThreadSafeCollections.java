package lecture16.example14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeCollections {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>()); // Потокобезпечний список

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
                synchronized (list) { // Необхідно синхронізувати читання вручну
                    System.out.printf("Read: ");
                    for (Integer num : list) {
                        System.out.printf("%d ", num);
                        try {
                            Thread.sleep(100); // Затримка під час читання
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                }
            }
        });

        writer.setPriority(Thread.MAX_PRIORITY);
        reader.setPriority(Thread.MIN_PRIORITY);

        writer.start();
        reader.start();
    }
}
