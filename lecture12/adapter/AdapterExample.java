package lecture12.adapter;

public class AdapterExample {
    public static void main(String[] args) {
        // Створення зарядного пристрою для розетки
        SocketCharger socketCharger = new SocketCharger();

        // Створення адаптера для зарядки через USB
        UsbCharger usbAdapter = new SocketToUsbAdapter(socketCharger);

        // Використання зарядки через адаптер
        usbAdapter.chargeWithUsb();
    }
}

// Інтерфейс для нового типу зарядного пристрою
interface UsbCharger {
    void chargeWithUsb();
}

// Сервіс, що надає зарядку через старий інтерфейс розетки
class SocketCharger {
    public void chargeWithSocket() {
        System.out.println("Charging using a socket charger.");
    }
}

// Адаптер, який дозволяє використовувати зарядку через USB з розеткою
class SocketToUsbAdapter implements UsbCharger {
    private SocketCharger socketCharger;

    public SocketToUsbAdapter(SocketCharger socketCharger) {
        this.socketCharger = socketCharger;
    }

    @Override
    public void chargeWithUsb() {
        System.out.println("Adapter converting USB charging to socket charging...");
        socketCharger.chargeWithSocket();
    }
}

