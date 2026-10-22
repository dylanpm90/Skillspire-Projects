package week6.wed.practice;

import java.util.ArrayList;

public class Week6WedPractice {
    public static void main(String[] args) {

        System.out.println("--- 1. Animals ---");
        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(new Dog("Rex"));
        zoo.add(new Bird("Tweety"));                            // TODO 1
        for (Animal a : zoo) {
            a.sound();
        }

        System.out.println("--- 2. Payments ---");
        Store store = new Store();
        store.checkout(new CreditCardPayment(), 20.0);
         store.checkout(new CashPayment(), 20.0);                // TODO 2

        System.out.println("--- 3. Things that charge ---");
        ArrayList<Chargeable> plugs = new ArrayList<>();
        plugs.add(new Phone());
         ElectricScooter scooter = new ElectricScooter("Metro"); // TODO 3
         scooter.start();                                        // TODO 3
         plugs.add(scooter);                                     // TODO 3

        // TODO 4, only if there is time: add a lamp to plugs with a lambda, no class.
        //         Chargeable lamp = () -> ...

        for (Chargeable c : plugs) {
            c.charge();
        }
    }
}
