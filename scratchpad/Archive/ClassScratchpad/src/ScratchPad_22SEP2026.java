public class ScratchPad_22SEP2026 {
    public double longerNumber = 79.9;
    private int shorterNumber = 10;


    public void main() {
        typeCastingExample(longerNumber, shorterNumber);
    }

    private static void typeCastingExample(double longNumber, int shortNumber) {
        System.out.println("Typecasting example: ");
        System.out.println("Typecast a double, " + longNumber + ", into an int, " + (int) longNumber + ".");
        System.out.println("This results in some information loss.");
        System.out.println("Typecast an int, " + shortNumber + ", into a double, " + (double) shortNumber + ".");
    }

    class Animal {
        void sound() {
            System.out.println("Grunt");
        }
    }

    class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Bark");
        }
    }

}
