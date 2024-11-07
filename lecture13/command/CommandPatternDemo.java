package lecture13.command;

import java.util.HashMap;
import java.util.Map;

// Client class
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        // Set commands
        remote.setCommand("turnOn", turnOn);
        remote.setCommand("turnOff", turnOff);

        // Turn the light on
        remote.pressButton("turnOn");

        // Turn the light off
        remote.pressButton("turnOff");
    }
}


// Command interface
interface Command {
    void execute();
}

// Receiver class
class Light {
    void turnOn() {
        System.out.println("The light is on");
    }

    void turnOff() {
        System.out.println("The light is off");
    }
}

// Concrete Command classes
class TurnOnLightCommand implements Command {
    private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}


class RemoteControl {
    private final Map<String, Command> commands = new HashMap<>();

    public void setCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void pressButton(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Command not found");
        }
    }
}
