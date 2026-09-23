public class Ex07 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Declare double exactScore = 87.9; then create int wholeScore by casting it with (int). Print both.
//        Declare int studentCount = 24; then assign it to a double variable. Print it.
//        Declare char grade = 'A'; then assign it to an int variable. Print both in one sentence.
//        In a comment, answer the following: when 87.9 was cast to an int, was the value rounded or cut off?

        // Variables
        double exactScore = 87.9;
        int wholeScore = (int)exactScore;
        int studentCount = 24;
        char grade = 'A';

        // Execute
        System.out.println("Exact score: " + exactScore);
        System.out.println("After casting to int: " + wholeScore);
        System.out.println("Student count as a double: " + (double)studentCount);
        System.out.println("The character " + grade + " is " + (int)grade);
    }
}
// Casting a double like 87.9 to an integer results in the number being truncated to 87, and it is not rounded down.