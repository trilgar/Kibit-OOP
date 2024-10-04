package lecture7.example11;

public class Example711 {
    public static void main(String[] args) {
        TransmissionChannel channel = new TransmissionChannel();

        try {
            channel.open();
            // Виконання основної передачі даних
            channel.transmitData("Hello, World!");
            // Симуляція помилки передачі
            channel.transmitData(null); // Викине TransmissionError
        } catch (TransmissionError e) {
            // Обробка виключення TransmissionError
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Закриття каналу, яке виконається в будь-якому випадку
            channel.close();
        }
    }
}

class TransmissionChannel {
    void open() {
        System.out.println("Transmission channel opened.");
    }

    void transmitData(String data) throws TransmissionError {
        if (data == null) {
            throw new TransmissionError("Data cannot be null.");
        }
        System.out.println("Data transmitted: " + data);
    }

    void close() {
        System.out.println("Transmission channel closed.");
    }
}

class TransmissionError extends Exception {
    TransmissionError(String message) {
        super(message);
    }
}