public class AccountComposition {
    class Account {
        Customer customer;

        Account(Customer customer) {
            this.customer = customer;
        }

        void displayInfo() {
            System.out.println("Name: " + customer.name + " | Acct#: "
                    + customer.accountNumber + " | ");
        }
    }

    class Customer {
        String name;
        int accountNumber;
        Customer(String name, int accountNumber){
            this.name = name;
            this.accountNumber = accountNumber;

        }
    }

    void main(String[] args) {
        Account a1 = new Account(new Customer("David", 123456));
        a1.displayInfo();
    }
}
