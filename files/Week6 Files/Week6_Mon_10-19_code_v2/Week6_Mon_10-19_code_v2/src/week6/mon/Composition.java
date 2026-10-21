package week6.mon;

// Point: composition = a class HAS another object as a field ("has a").
// Good practice: keep that field
// private and let the class hand work to it (delegation).
// The part can be swapped only because
// Car accepts an Engine from outside, through a constructor or a setter.
// Ask:   "Is a car an engine, or does a car have an engine?"

// LMS Composition and Inheritance P2 (composition), P6 (flexibility),
// P7 (mistakes), P9 (dependency injection)

class Engine {
    void start() {
        System.out.println("Engine starting...");
    }
}

// Section 2: an ElectricMotor IS AN Engine (Friday's extends),
// so a Car can hold one
class ElectricMotor extends Engine {
    @Override
    void start() {
        System.out.println("Electric motor humming...");
    }
}

class Car {
    private Engine engine;
    // a Car HAS AN Engine: a private field, not extends

    // LMS P2: the car builds its own engine. On its own,
    // this constructor gives no way to swap it.
    Car() {
        engine = new Engine();
        // SPOT THE BUG: comment out this line and run
    }

    // LMS P9: the engine is handed in from outside (dependency injection)
    Car(Engine engine) {
        this.engine = engine;
    }

    // Swap the part on a car that already exists
    void setEngine(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.start();                     // delegation: the car asks its engine to do the work
        System.out.println("Car is ready to drive.");
    }
}

public class Composition {
    public static void main(String[] args) {

        // ----- Section 1: a Car has an Engine (LMS P2) -----
        System.out.println("--- 1. A car has an engine ---");
        Car myCar = new Car();
        myCar.start();                      // PREDICT: how many lines, in what order?

        // SPOT THE BUG: uncomment. private stops outside code from reaching the car's part
        //               (the defense against LMS P7's "exposing internal composed objects").
        // myCar.engine.start();

        // ----- Section 2: swap the part (LMS P6 flexibility, P9 dependency injection) -----
        System.out.println("--- 2. Swap the engine ---");
        Car tesla = new Car(new ElectricMotor());   // hand the car a different engine
        tesla.start();                      // * PREDICT: Car's code did not change. What prints?

        myCar.setEngine(new ElectricMotor());       // the same car object, a new part
        myCar.start();

        // EXTRA WRITE: a class HybridMotor extends Engine with its own start(), then
        //              new Car(new HybridMotor()).start();   Which existing class had to change?
    }
}
