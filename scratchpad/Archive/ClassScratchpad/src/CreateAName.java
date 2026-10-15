public class CreateAName {
    static void main(String[] args) {
        String firstNameSample = "David";
        StringBuilder myName = new StringBuilder(firstNameSample);
        // before using StringBuilder constructor
        System.out.println("Before: " + myName);
        updateName(myName);
        // after method
        System.out.println("After: " + myName);

    }

    static void updateName(StringBuilder name) {
        String lastName = "Blaine";
        name.append(" " + lastName);
    }
}
