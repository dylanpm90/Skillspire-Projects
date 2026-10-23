interface Payment {
    void process();
    default void receipt() {
        System.out.println("Thank you!");

    }
}

class CreditCardPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
    }

}

class PayPalPayment implements Payment {
    @Override
    public void process() {
        System.out.println("Processing PayPal payment...");
    }

}

public class Main {
    public static void main(String[] args) {
        Payment p = new PayPalPayment();
        p.process();
        p.receipt();
    }
}