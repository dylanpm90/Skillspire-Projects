public class CarComposition {
    class Vehicle {
        Engine engine = new Engine();
        void move(){
            System.out.println("moving");
        }
    }

    class Car extends Vehicle {
        void drive(){
            System.out.println("driving");
        }
    }

    class Engine{
        void start(){
            System.out.println("engine started");
        }
    }

    void main(String[] args) {
        Car c = new Car();
        c.move();
        c.drive();
        c.engine.start();
    }
}
