import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // receive assignment scores
        System.out.print("Enter first assignment score (0-100): ");
        int firstScore = scanner.nextInt();
        System.out.print("Enter second assignment score (0-100): ");
        int secondScore = scanner.nextInt();
        System.out.print("Enter third assignment score (0-100): ");
        int thirdScore = scanner.nextInt();

        // TODO: Validate the range and assign A/B/C/D/F using if/else if.
        // calculate average and call methods using the average score.
        int averageScore = (firstScore + secondScore + thirdScore) / 3;
        String gradeResult = gradeCalculator(averageScore);
        boolean passFailResult = passFailEvaluator(averageScore);

        System.out.println("Your average is " + averageScore + " and your grade is " + gradeResult + ".");
        if (passFailResult) {
            System.out.println("Course: Pass");
        } else {
            System.out.println("Course: Fail.");
        }


        scanner.close();
    }

    public static String gradeCalculator(int gradeInt) {
        // grades less than 0 or greater than 100 are invalid
        // everthing within that range has regular grade letter assignments.
        if (gradeInt < 0 || gradeInt > 100) {
            return "Invalid";
        } else if (gradeInt >= 90) {
            return "A";
        } else if (gradeInt >= 80) {
            return "B";
        } else if (gradeInt >= 70) {
            return "C";
        } else if (gradeInt >= 60) {
            return "D";
        } else if (gradeInt >= 0) {
            return "F";
        } else {
            return "Invalid grade";
        }
    }
    // if it's less than a 60, it is a failing grade.
    public static boolean passFailEvaluator(int gradeInt) {
        if (gradeInt > 59 && gradeInt <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
