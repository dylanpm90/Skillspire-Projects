
public class ScratchPad18SEP {
    static void main() {

        drinkingAgeTest();
//        calculateRectangleArea();

    }

    private static void drinkingAgeTest() {

        // variables
        int patronAge = 23;
        int legalDrinkingAge = 21;

        // determine boolean
        boolean canDrink = (patronAge >= legalDrinkingAge);

        // print result if the patron can legally drink.
        if (canDrink) {
            System.out.println("You can drink because you are " + patronAge + " years old.");
        }
    }

    private static void calculateRectangleArea() {
        // variables
        int length = 5;
        int width = 10;

        // calculate area
        int area = length * width;

        // print result
        System.out.println("The area of the rectangle is " + area + ".");
    }
}

