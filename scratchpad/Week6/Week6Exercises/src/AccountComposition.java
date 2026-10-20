public class AccountComposition {
    class Customer{
        String customerName;
        int accountNumber;
        double accountBalance;
        Account account = new Account(accountBalance);


        Customer(String customerName, int accountNumber, double accountBalance){
            this.accountBalance = accountBalance;
            this.customerName = customerName;
            this.accountNumber = accountNumber;

        }

        void displayInfo(){
            System.out.println("Name: " + customerName + " | AcctNumber: " +  accountNumber + " | AcctBalance: $" + accountBalance);
        }

    }

    class Account{
        double accountBalance;

        Account(double accountBalance){
        }

        void newAccountAlert(){
            System.out.println("New account created!");
        }
    }


    void main(String[] args) {
        Customer c1 = new Customer("David", 123435, 1332.22);
        c1.account.newAccountAlert();
        c1.displayInfo();
    }
}
