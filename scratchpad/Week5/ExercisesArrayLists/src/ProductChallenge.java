import java.util.ArrayList;

public class ProductChallenge {
    static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Laptop", 1200.00));



    }
    static class Product{
        String name;
        double price;

        Product(String n, double p){
            this.name = n;
            this.price = p;
        }
    }
}

