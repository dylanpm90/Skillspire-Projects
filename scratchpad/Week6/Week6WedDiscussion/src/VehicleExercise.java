public class VehicleExercise {

    interface GPS {
        void navigate();
    }

    abstract class Vehicle{
        abstract void start();

        void info(){
            System.out.println("Display info.");
        }
    }
    class Car extends Vehicle implements GPS{
        @Override
        void start() {
            System.out.println("Car starting...");
        }

        @Override
        public void navigate(){
            System.out.println("Navigating to destination.");
        }

    }

    void main(String[] args){
        Car c = new Car();
        c.start();
        c.info();
        c.navigate();
    }

}
