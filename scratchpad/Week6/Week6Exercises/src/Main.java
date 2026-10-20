
class Horn {
    void honk() {
        System.out.println("Car honks");
    }
}

class Engine {
    void start() {
        System.out.println("Car is ready to drive");
    }
}

class Vehicle {
}

class Car extends Vehicle {
    private Engine engine;
    Horn horn;

    Car() {
        this.engine = new Engine();
        this.horn = new Horn();
    }

    void start(){
        engine.start();

    }
    void honk(){
        horn.honk();
    }
}


public class Main {
    static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.honk();
    }
}
