import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;

public class ProductChallenge {
    void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Laptop", 1200.00));
        inventory.add(new Product("Mouse", 100.00));
        inventory.add(new Product("Portable Hard Drive", 150.00));
        inventory.add(new Product("HDMI Cable", 9.99));

        double sum = 0f;

        for (int i = 0; i < inventory.size(); i++) {
            sum += inventory.get(i).price;
        }

        System.out.println("Sum: $" + sum);
        double average = sum / inventory.size();
        System.out.println("Average: $" + average);

        Iterator<Product> it = inventory.iterator();
        while (it.hasNext()){
            Product product = it.next();
            if (product.price < 10){
                it.remove();
            };
        }
        inventory.sort((o1, o2) -> Double.compare(o2.price, o1.price));
        System.out.println(inventory);


    }

    class Product {
        String name;
        double price;


        Product(String name, double price){
            this.name = name;
            this.price =price;
        }
        @Override
        public String toString() {
            return "Price: " + name + " Price: (" + price + ")";
        }
    }
}

