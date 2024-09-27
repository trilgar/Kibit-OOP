package lecture7;

public class Example711 {
    public static void main(String[] args) {

        try (TransmissionChannel channel = new TransmissionChannel()) {
            // Виконання основної передачі даних
            channel.transmitData("Hello, World!");
            // Симуляція помилки передачі
            channel.transmitData(null); // Викине TransmissionError
        } catch (TransmissionError e) {
            // Обробка виключення TransmissionError
            System.out.println("Error occurred: " + e.getMessage());
        }
        // Закриття каналу, яке виконається в будь-якому випадку
    }
}

class TransmissionChannel implements AutoCloseable {

    public TransmissionChannel() {
        this.open();
    }

    void open() {
        System.out.println("Transmission channel opened.");
    }

    void transmitData(String data) throws TransmissionError {
        if (data == null) {
            throw new TransmissionError("Data cannot be null.");
        }
        System.out.println("Data transmitted: " + data);
    }

    public void close() {
        System.out.println("Transmission channel closed.");
    }
}

class TransmissionError extends Exception {
    TransmissionError(String message) {
        super(message);
    }
}