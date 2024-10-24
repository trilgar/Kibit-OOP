package lecture10.solid.ocp.goodexample;


public class MainOCP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Обробка платежів через різні системи
        Payment creditCardPayment = new CreditCardPayment();
        Payment paypalPayment = new PayPalPayment();

        processor.processPayment(creditCardPayment);
        processor.processPayment(paypalPayment);
    }
}

// Інтерфейс для різних типів платежів
interface Payment {
    void process();
}

// Клас для оплати кредитною карткою
class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }
}

// Клас для оплати через PayPal
class PayPalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment...");
    }
}

// Клас для обробки платежів
class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.process();
    }
}
