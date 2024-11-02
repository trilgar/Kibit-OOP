package lecture12.decorator;

/**
 * Абстрактний клас, що представляє інтерфейс для всіх сповіщень.
 */
interface Notifier {
    void send(String message);
}

/**
 * Конкретний компонент - EmailNotifier. Реалізує надсилання повідомлень через Email.
 */
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

/**
 * Базовий декоратор, що зберігає посилання на інший об'єкт Notifier і делегує йому виклик методу send().
 */
abstract class BaseDecorator implements Notifier {
    protected Notifier wrappee;

    public BaseDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

/**
 * Конкретний декоратор для надсилання SMS.
 */
class SMSDecorator extends BaseDecorator {
    public SMSDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

/**
 * Конкретний декоратор для надсилання повідомлень у Facebook.
 */
class FacebookDecorator extends BaseDecorator {
    public FacebookDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Facebook message: " + message);
    }
}

/**
 * Конкретний декоратор для надсилання повідомлень у Slack.
 */
class SlackDecorator extends BaseDecorator {
    public SlackDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}

/**
 * Основний клас для демонстрації роботи патерна Декоратор.
 */
public class DecoratorExample {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SMSDecorator(notifier);
        notifier = new FacebookDecorator(notifier);
        notifier = new SlackDecorator(notifier);

        notifier.send("Important Update!");
    }
}
