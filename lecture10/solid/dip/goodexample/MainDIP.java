package lecture10.solid.dip.goodexample;

// Головний клас для демонстрації
public class MainDIP {
    public static void main(String[] args) {
        Switchable light = new Light();
        Switchable fan = new Fan();

        Switch lightSwitch = new Switch(light);
        Switch fanSwitch = new Switch(fan);

        // Вмикаємо і вимикаємо світло
        lightSwitch.toggle(true);
        lightSwitch.toggle(false);

        // Вмикаємо і вимикаємо вентилятор
        fanSwitch.toggle(true);
        fanSwitch.toggle(false);
    }
}

// Інтерфейс для всіх типів приладів, які можна вмикати та вимикати
interface Switchable {
    void turnOn();
    void turnOff();
}

// Конкретна реалізація світла
class Light implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

// Інша реалізація — вентилятор
class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned off");
    }
}

// Клас Switch тепер залежить від абстракції, а не конкретної реалізації
class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void toggle(boolean on) {
        if (on) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}

