public class AbstractShapes {
    abstract class Shape {
        abstract double area();
        void describe(){
            System.out.println("This is a shape");
        }
    }

    class Circle extends Shape{
        double r;

        @Override
        double area() {
            return Math.PI * r * r;
        }
    }

    void main(String[] args) {
        Circle circle = new Circle();
        circle.r = 3;
        double circleArea = circle.area();

        System.out.println(circleArea);
    }
}
