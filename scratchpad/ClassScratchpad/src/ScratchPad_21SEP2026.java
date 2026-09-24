public class ScratchPad_21SEP2026 {

    public static void main() {
        // variables
        int firstSampleNumber = 3;
        int secondSampleNumber = 10;
        int thirdSampleNumber = 18;
        int fourthSampleNumber = 32;
        String firstFruit = "Apple";
        String secondFruit = "Apple";
        String thirdFruit = "Orange";

        // store results of called methods
        boolean result = isEven(thirdSampleNumber);
        boolean fruitComparisonResult = isFruitSame(firstFruit, secondFruit);
        boolean secondFruitComparisonResult = isFruitSame(firstFruit, thirdFruit);
        int area = areaOfRectangle(secondSampleNumber, thirdSampleNumber);
        int integerSum = calculateIntegerSum(firstSampleNumber, secondSampleNumber);
        int integerDifference = calculateIntegerDifference(firstSampleNumber, secondSampleNumber);
        String adultOrMinor = determineAdultOrMinor(fourthSampleNumber);

        // print results
        System.out.println("Is " + thirdSampleNumber + " even? " + result);
        System.out.println(fruitComparisonResult);
        System.out.println(secondFruitComparisonResult);
        System.out.println(area);
        System.out.println(integerSum);
        System.out.println(integerDifference);
        System.out.println(adultOrMinor);
    }


    // method to tell whether a number is even or odd
    public static boolean isEven(int number) {
        // shorthand of if/else
        return (number % 2 == 0) ? true : false;
    }

    // calculate area of a rectangle
    public static int areaOfRectangle(int length, int width) {
        return length * width;
    }

    // compare fruit strings
    public static boolean isFruitSame(String fruit1, String fruit2) {
        return (fruit1.equals(fruit2)) ? true : false;
    }

    // calculate the sum of two integers
    public static int calculateIntegerSum(int firstInteger, int secondInteger) {
        return firstInteger + secondInteger;
    }

    // calculate difference of two integers
    public static int calculateIntegerDifference(int firstInteger, int secondInteger) {
        return firstInteger - secondInteger;
    }

    // tells you whether a number is the age of an adult or minor.
    public static String determineAdultOrMinor(int age) {
        return (age >= 18) ? "Adult" : "Minor";
    }

}

