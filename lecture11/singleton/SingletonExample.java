package lecture11.singleton;


public class SingletonExample {
    public static void main(String[] args) {
        // Отримання екземпляра Singleton і виклик методу
        AnySingletonClass anySingletonClass = AnySingletonClass.getInstance();
        anySingletonClass.showMessage();
    }
}

class AnySingletonClass {
    // Приватна статична змінна для зберігання єдиного екземпляра класу
    private static AnySingletonClass instance;

    // Приватний конструктор, щоб запобігти створенню об'єктів ззовні
    private AnySingletonClass() {
        // Ініціалізація, якщо потрібно
    }

    // Публічний метод для отримання єдиного екземпляра класу
    public static AnySingletonClass getInstance() {
        if (instance == null) {
            // блок synchronized потрібен щоб при паралельному зверненні створення нового об'єкта викликалося лише раз
            synchronized (AnySingletonClass.class) {
                if (instance == null) {
                    instance = new AnySingletonClass();
                }
            }
        }
        return instance;
    }

    // Метод, який демонструє роботу Singleton
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}