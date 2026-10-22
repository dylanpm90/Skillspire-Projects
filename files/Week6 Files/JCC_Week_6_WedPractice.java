package week6.wed.practice;

import java.util.ArrayList;

// Week 6 Wednesday: in-class practice for abstract classes and interfaces.
// The file compiles and runs as given. Do each TODO when Sean says so.
// After each TODO: compile, read the error if there is one, fix it, run.

// ===== Exercise 1: an abstract class =====

abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void sound();
    // no body: every non-abstract child must write it

    void breathe() {                    // a normal method every child gets
        System.out.println(getName() + " is breathing...");
    }
}

class Dog extends Animal {              // a finished example
    Dog(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(getName() + ": Bark");
    }
}

// TODO 1: uncomment the two lines below and compile. Fix each error
//  the compiler reports until Bird compiles. A bird says "Tweet".
//         Then uncomment the TODO 1 line in main.
class Bird extends Animal {
    Bird(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(getName() + ": Tweet");
    }
}

// ===== Exercise 2: an interface =====

interface Payment {
    void process(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void process(double amount) {

        System.out.println("Processing credit card payment of $" + amount);
    }
}

// TODO 2: write  class CashPayment implements Payment.
//  Its process() prints
//         "Paid $<amount> in cash".
//         Then uncomment the TODO 2 line in main.

class CashPayment implements Payment {
    @Override
    public void process(double amount) {
        System.out.println("Paid $" + amount + " in cash");
    }
}

class Store {
    void checkout(Payment p, double amount) {      // takes ANY Payment
        p.process(amount);
    }
}

// ===== Exercise 3: one parent class, plus an interface =====

abstract class Vehicle {
    private String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    String getBrand() {
        return brand;
    }

    abstract void start();
}

interface Chargeable {
    void charge();
}

class Phone implements Chargeable {     // a finished example: it can charge, but it is not a Vehicle
    @Override
    public void charge() {
        System.out.println("Phone charging over USB-C");
    }
}

// TODO 3: write  class ElectricScooter  that IS A Vehicle and CAN charge.
//         start() prints "<brand> scooter started";
//         charge() prints "<brand> scooter charging".
//         Then uncomment the three TODO 3 lines in main.

class ElectricScooter extends Vehicle implements Chargeable {
    ElectricScooter(String brand){
        super(brand);

    }

    @Override
    void start() {
        System.out.println(getBrand() + " scooter started");
    }

    @Override
    public void charge() {
        System.out.println(getBrand() + " scooter charging");
    }
}


