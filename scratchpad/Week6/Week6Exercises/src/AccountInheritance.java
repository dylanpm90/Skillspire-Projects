public class AccountInheritance {
    class Account {
        String name;
        int accountNumber;

        void displayInfo() {
            System.out.println("Name: " + name +
                    " | Acct#: " + accountNumber + " | ");
        }
    }

    class Customer extends Account {
        Customer(String name, int accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }
    }

    void main(String[] args) {
        Customer c1 = new Customer("David", 123456);
        c1.displayInfo();
    }
}
