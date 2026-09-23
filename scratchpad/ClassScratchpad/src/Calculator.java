public class Calculator {
    static void main() {
        // variables
        int firstSampleNumber = 3;
        int secondSampleNumber = 10;
        int thirdSampleNumber = 18;
        int fourthSampleNumber = 32;

        // store calculations in a variable
        int integerSum = calculateIntegerSum(firstSampleNumber, secondSampleNumber);
        int integerDifference = calculateIntegerDifference(firstSampleNumber, secondSampleNumber);
        int integerProduct = calculateIntegerProduct(thirdSampleNumber, fourthSampleNumber);
        int integerQuotient = calculateIntegerQuotient(thirdSampleNumber, firstSampleNumber);

        // print calculations
        System.out.println("++++++++++++++++ CALCULATOR ++++++++++++++++");
        System.out.println("The sum of " + firstSampleNumber + " and " + secondSampleNumber + " is " + integerSum);
        System.out.println("The difference of " + firstSampleNumber + " and " + secondSampleNumber + " is " + integerDifference);
        System.out.println("The product of " + thirdSampleNumber + " and " + fourthSampleNumber + " is " + integerProduct);
        System.out.println("The quotient of " + thirdSampleNumber + " and " + firstSampleNumber + " is " + integerQuotient);
    }

    public static int calculateIntegerSum(int firstInteger, int secondInteger) {
        return firstInteger + secondInteger;
    }

    // calculate difference of two integers
    public static int calculateIntegerDifference(int firstInteger, int secondInteger) {
        return firstInteger - secondInteger;
    }

    // calculate product of two integers
    public static int calculateIntegerProduct(int firstInteger, int secondInteger){
        return firstInteger * secondInteger;
    }

    // calculate quotient of two integers
    public static int calculateIntegerQuotient(int firstInteger, int secondInteger){
        return firstInteger / secondInteger;
    }
}
