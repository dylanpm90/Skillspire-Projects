public class Ex10 {
    public static void main(String[] args) {
//        REQUIREMENTS
//
//        Declare String studentName and String programName.
//        Declare double tuition = 6500.00; and double deposit = 500.00; and int numberOfPayments = 5;
//        Calculate double balance as tuition minus deposit.
//        Calculate double monthlyPayment as balance divided by numberOfPayments.
//        Print the receipt exactly as shown in the expected output, including the lines of = and - characters.
//        Do not hard-code the values 6000 or 1200 anywhere in your program. These must be computed by your code.

        // Variables
        String studentName = "DD";
        String programName = "Java and Cloud Computing";
        double tuition = 6500.00, deposit = 500.00;
        int numberOfPayments = 5;

        //Calculate
        double balance = tuition - deposit;
        double monthlyPayment = balance / numberOfPayments;

        // Execute
        System.out.println("===== SKILLSPIRE PAYMENT PLAN =====");
        System.out.println("Student: " + studentName);
        System.out.println("Program: " + programName);
        System.out.println("-----------------------------------");
        System.out.println("Tuition: $" + tuition);
        System.out.println("Deposit paid: $" + deposit);
        System.out.println("Balance due: $" + balance);
        System.out.println("Payments: " + numberOfPayments);
        System.out.println("Monthly payment: $" + monthlyPayment);
        System.out.println("===================================");

    }
}
