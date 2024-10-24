package lecture10.solid.dip.badexample;

// Головний клас для демонстрації
public class MainDIPViolation {
    public static void main(String[] args) {
        Light light = new Light();
        Switch lightSwitch = new Switch(light);

        lightSwitch.toggle(true);  // Вмикаємо світло
        lightSwitch.toggle(false); // Вимикаємо світло
    }
}


class Light {
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

// Клас Switch напряму залежить від конкретної реалізації Light
class Switch {
    private Light light;

    public Switch(Light light) {
        this.light = light;
    }

    public void toggle(boolean on) {
        if (on) {
            light.turnOn();
        } else {
            light.turnOff();
        }
    }
}

