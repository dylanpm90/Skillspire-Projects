public class Ex05 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Declare int totalSlices = 7; and int people = 2;
//        Print totalSlices / people with the label "Integer division: "
//        Print totalSlices % people with the label "Remainder: "
//        Print totalSlices / 2.0 with the label "Decimal division: "
//        Print (double) totalSlices / people with the label "Decimal division with a cast: "
//        At the bottom of your file, add a comment (one sentence)
//        explaining why the first and third lines give different results.

        // Variables
        int totalSlices = 7;
        int people = 2;

        // Execute
        System.out.println("Integer division: " + (totalSlices / people));
        System.out.println("Remainder: " + (totalSlices % people));
        System.out.println("Decimal division: " + (totalSlices / 2.0));
        System.out.println("Decimal division with a cast: " + ((double)totalSlices / people));

    }
}
// The first line does integer division results in whole numbers,
// but the third line divides by decimal division, which results in a number with a decimal.
