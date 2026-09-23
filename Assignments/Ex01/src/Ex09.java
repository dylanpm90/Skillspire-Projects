public class Ex09 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Declare int studentsEnrolled = 24; and int classCapacity = 30;
//        along with a boolean variable,
//        then print the answers to five true/false questions.
//        Also declare boolean hasLaptop = true;
//        Print whether the class is full, using ==
//        Print whether there are open seats, using <
//        Print whether enrollment is different from capacity, using !=
//        Print whether enrollment is at least 30, using >=
//        Print the value of hasLaptop
//        Each line must be written as a question (e.g., Is the class full? false).

        // Variables
        int studentsEnrolled = 24;
        int classCapacity = 30;
        boolean hasLaptop = true;

        // Execute
        System.out.println("Is class full? " + (studentsEnrolled == classCapacity));
        System.out.println("Are there open seats? " + (studentsEnrolled < classCapacity));
        System.out.println("Is enrollment different than capacity? " + (studentsEnrolled != classCapacity));
        System.out.println("Is enrollment at least 30? " + (studentsEnrolled >= classCapacity));
        System.out.println("Do I have a laptop? " + hasLaptop);

    }
}
