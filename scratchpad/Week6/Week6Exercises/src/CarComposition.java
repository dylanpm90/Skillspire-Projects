public class CarComposition {
    class Vehicle {

    }

    class Car extends Vehicle {
        private Engine engine = new Engine();
        void drive(){
            System.out.println("driving");
        }

        public Engine getEngine() {
            return engine;
        }

        void start(){
            engine.start();
        }
    }

    class Engine{
        void start(){
            System.out.println("vroom");
        }
    }

    void main(String[] args) {
        Car c = new Car();
        c.start();
        c.drive();

    }
}
