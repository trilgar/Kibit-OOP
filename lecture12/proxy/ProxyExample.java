package lecture12.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        RealService proxy = new ServiceProxy();
        System.out.println("First request:");
        proxy.request();

        System.out.println("\nSecond request:");
        proxy.request();
    }
}

interface RealService {
    void request();
}

class ExpensiveService implements RealService {
    public ExpensiveService() {
        heavyInitialization();
    }

    private void heavyInitialization() {
        System.out.println("Performing heavy initialization...");
    }

    @Override
    public void request() {
        System.out.println("Processing request by ExpensiveService.");
    }
}

class ServiceProxy implements RealService {
    private ExpensiveService service;

    @Override
    public void request() {
        if (service == null) {
            service = new ExpensiveService();
        }
        System.out.println("ServiceProxy: Delegating request to ExpensiveService.");
        service.request();
    }
}



