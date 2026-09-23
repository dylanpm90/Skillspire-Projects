public class Ex06 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Store the three scores in three separate double variables.
//        Store the sum of the three scores in a variable named total.
//        Compute the average by dividing total by 3, and store it in a variable named average.
//        Print the total and the average on two labelled lines.

        // Variables
        double a = 90.0, b = 85.0, c = 95.0;
        double total = a + b + c;
        double average = (total / 3);

        // Execute
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}
