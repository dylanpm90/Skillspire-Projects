import java.util.Scanner;

public class TipCalculator {
    static void main(String[] args) {
        // get name using scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        // todo 1: ask for bill total
        System.out.println("Enter bill: ");
        double billBeforeTip = scanner.nextDouble();
        System.out.printf("Bill total: $%.2f%n", billBeforeTip);

        // todo 2: ask for tip percentage
        System.out.println("What is the tip percentage?");
        int tipPercentage = scanner.nextInt();


        // todo 3: calculate tip and final total
        double tipConversion = tipPercentage * 0.01;
        double billTipCalculation = billBeforeTip * tipConversion;
        double totalBill = billBeforeTip + billTipCalculation;

        // todo 4: print results
        System.out.println("Name: " + name);
        System.out.printf("Bill: $%.2f%n", billBeforeTip);
        System.out.printf("Tip: $%.2f%n", billTipCalculation);
        System.out.println("Tip percentage: " + tipPercentage + "%.");
        System.out.printf("Total: $%.2f%n", totalBill);


        scanner.close();
    }


}

