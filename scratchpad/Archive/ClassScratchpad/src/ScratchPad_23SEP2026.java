public class ScratchPad_23SEP2026 {

    public static void main(String[] args) {
        // sample vars
        int firstSampleNumber = 12;
        int secondSampleNumber = 2;

        // run method
        int additionResult = add(firstSampleNumber, secondSampleNumber);
//        String result = dayDeterminer(secondSampleNumber);
//        String switchCaseResult = stringDeterminer(secondSampleNumber);
        // print result
        System.out.println("The sum of " + firstSampleNumber + " and " + secondSampleNumber + " is " + additionResult + ".");
//        System.out.println(switchCaseResult);

//        switch (secondSampleNumber) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("Invalid day");
//        }


    }

    public static int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

//    public static String stringDeterminer(int number){
//        String result;
//
//        result = switch(number){
//            case 1 -> "one";
//            case 2 -> "two";
//            default -> "N/A";
//        }
//        return result;
//    public static String dayDeterminer(int day){
//        switch (day)
//        {
//            case 1:
//                 "Monday";
//                break;
//            case 2:
//                return "Tuesday";
//                break;
//            default:
//                return "nothin";
//        }
//    }
}
