public class daySwitcheroo {
    static void main(String[] args) {
        // vars
        int sampleNumber = 1; // I want this number to run through the switch statement in my method below
        int defaultTestNumber = 99; // I want this to run the default case.
        // run method
        String switchResult = daySwitchMethod(sampleNumber); // This var will contain the results of daySwitchMethod.
        String testDefaultResult = daySwitchMethod(defaultTestNumber); // Should show "Not applicable".

        // print result
        System.out.println("_____ SWITCH TEST _____");
        System.out.println("Day " + sampleNumber + " of the week is " + switchResult + "."); // should print "Monday"
        System.out.println("Day " + defaultTestNumber + " of the week is " + testDefaultResult + "."); // should print "Not applicable".
    }

    // create a method which returns the String result of a switch statement.
    // Capture and print the result in main above.
    public static String daySwitchMethod(int day) {
        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "not applicable";
        };
        return result;

    }
}
