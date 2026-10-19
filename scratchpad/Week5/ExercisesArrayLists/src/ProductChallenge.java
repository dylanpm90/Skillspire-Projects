import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ProductChallenge {
    void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Laptop", 1200.00));
        inventory.add(new Product("Mouse", 100.00));
        inventory.add(new Product("Portable Hard Drive", 150.00));
        inventory.add(new Product("HDMI Cable", 20.00));

        double sum = 0f;

        for (int i = 0; i < inventory.size(); i++) {
            sum += inventory.get(i).price;
        }

        System.out.println("Sum: $" + sum);
        double average = sum / inventory.size();
        System.out.println("Average: $" + average);

    }

    class Product {
        String name;
        double price;


        Product(String name, double price){
            this.name = name;
            this.price =price;
        }
    }
}

