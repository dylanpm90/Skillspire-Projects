public class Ex08 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Declare int points = 100; and print it with the label "Starting points: "
//        Add 50 using += and print the result.
//        Subtract 20 using -= and print the result.
//        Double it using *= and print the result.
//        Add one more using ++ and print the result,

        // Variables
        int points = 100;

        // Execute
        System.out.println("Starting points: " + points);
        System.out.println("After += 50: " + (points += 50));
        System.out.println("After -= 20: " + (points -= 20));
        System.out.println("After *= 2: " + (points *= 2));
        System.out.println("After ++: " + (++points));

    }
}
