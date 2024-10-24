package lecture10.solid.ocp.badexample;

public class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("creditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal payment...");
        }
    }
}

