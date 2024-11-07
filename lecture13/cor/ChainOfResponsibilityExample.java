package lecture13.cor;


public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Створення обробників
        Handler authHandler = new AuthHandler();
        Handler adminRightsHandler = new AdminRightsHandler();
        Handler inputValidationHandler = new InputValidationHandler();

        // Побудова ланцюжка обробників
        authHandler.setNext(adminRightsHandler);
        adminRightsHandler.setNext(inputValidationHandler);

        // Створення запиту
        Request request = new Request("JohnDoe", "admin", true);

        // Запуск обробки запиту
        authHandler.handleRequest(request);
    }
}

// Інтерфейс для обробників
interface Handler {
    void setNext(Handler handler);

    void handleRequest(Request request);
}

// Клас запиту
class Request {
    private String user;
    private String role;
    private boolean validData;

    public Request(String user, String role, boolean validData) {
        this.user = user;
        this.role = role;
        this.validData = validData;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public boolean isValidData() {
        return validData;
    }
}

// Базовий клас для обробників, що забезпечує зв'язок ланцюжка
abstract class BaseHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    protected void handleNext(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }
}

// Конкретний обробник для авторизації
class AuthHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getUser() != null && !request.getUser().isEmpty()) {
            System.out.println("AuthHandler: Користувач авторизований.");
            handleNext(request);
        } else {
            System.out.println("AuthHandler: Користувач не авторизований. Доступ заборонено.");
        }
    }
}

// Конкретний обробник для перевірки прав адміністратора
class AdminRightsHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if ("admin".equalsIgnoreCase(request.getRole())) {
            System.out.println("AdminRightsHandler: Користувач має права адміністратора.");
            handleNext(request);
        } else {
            System.out.println("AdminRightsHandler: Користувач не має прав адміністратора. Перевірка завершена.");
        }
    }
}

// Конкретний обробник для валідації введених даних
class InputValidationHandler extends BaseHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.isValidData()) {
            System.out.println("InputValidationHandler: Дані валідні.");
            handleNext(request);
        } else {
            System.out.println("InputValidationHandler: Дані невалідні. Доступ заборонено.");
        }
    }
}
