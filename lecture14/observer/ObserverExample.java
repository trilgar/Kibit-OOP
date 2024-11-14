package lecture14.observer;

import java.util.ArrayList;
import java.util.List;

class Store {
    private List<Observer> customers = new ArrayList<>();
    private String sale;

    public void subscribe(Observer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Observer customer) {
        customers.remove(customer);
    }

    public void notifyCustomers() {
        for (Observer customer : customers) {
            customer.update(sale);
        }
    }

    public void newSale(String sale) {
        this.sale = sale;
        System.out.println("[Store] Announcing new sale: " + sale);
        notifyCustomers();
    }
}

// Підписник (Observer)
interface Observer {
    void update(String sale);
}

// Конкретний підписник
class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String sale) {
        System.out.println("[Customer - " + name + "] Received notification: " + sale);
    }
}

public class ObserverExample {
    public static void main(String[] args) {
        Store store = new Store();

        // Створення підписників
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Alice");
        Customer customer3 = new Customer("Bob");

        // Підписка на магазин
        store.subscribe(customer1);
        store.subscribe(customer2);
        store.subscribe(customer3);

        // Оголошення розпродажу
        store.newSale("Autumn SALE - up to 50% off!");

        // Відписка клієнта
        store.removeCustomer(customer2);

        // Оголошення нового розпродажу
        store.newSale("Winter SALE - up to 30% off!");
    }
}
