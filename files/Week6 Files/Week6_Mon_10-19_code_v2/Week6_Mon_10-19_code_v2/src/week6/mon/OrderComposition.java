package week6.mon;

import java.util.ArrayList;

// Point: real designs use both. An Electronics IS A Product (extends); an Order HAS products (a private list).
//        A Product variable can hold an Electronics. The object's type picks which overridden method runs;
//        the variable's declared type decides which methods you may call. That is polymorphism.
// Ask:   "Friday's cart lived in main. Which class should own the list of products?"

// LMS Composition and Inheritance P5 Example 2 (e-commerce), P6 (inheritance allows polymorphism), P9 (combining)

// Friday's Product and Electronics (Week5Wrap), unchanged except one new getter
class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Invalid price: " + price);
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }
}

class Electronics extends Product {         // inheritance: an Electronics IS A Product
    private int warrantyYears;

    Electronics(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    Electronics(String name, double price) {
        this(name, price, 1);
    }

    public int getWarrantyYears() {         // new today
        return warrantyYears;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + warrantyYears + "-year warranty";
    }
}

// TRY IT FIRST: before scrolling here, students write the products field and addProduct (run sheet, 6:12)
class Order {
    private String customer;
    private ArrayList<Product> products = new ArrayList<>();   // composition: an Order HAS products

    Order(String customer) {
        this.customer = customer;
    }

    void addProduct(Product p) {            // takes a Product, so any child of Product fits
        products.add(p);
    }

    double getTotal() {
        double total = 0;
        for (Product p : products) {        // Friday's total loop, now inside the Order
            total += p.getPrice();
        }
        return total;
    }

    void printReceipt() {
        System.out.println("Order for " + customer);
        for (Product p : products) {
            System.out.println("  " + p);   // each object's own toString()
        }
        System.out.println("Total: " + getTotal());
    }

    // EXTRA: uncomment this getter and the two EXTRA lines at the end of main
    // ArrayList<Product> getProducts() {
    //     return products;
    // }
}

public class OrderComposition {
    public static void main(String[] args) {

        // ----- Section 1: an Order has products (LMS P5 Example 2, P9 combining) -----
        System.out.println("--- 1. An order has products ---");
        Order order = new Order("Alice");
        order.addProduct(new Product("Notebook", 3.5));
        order.addProduct(new Electronics("Laptop", 1200.0, 2));
        order.addProduct(new Electronics("Mouse", 25.0));
        order.printReceipt();               // PREDICT: the lines and the total (Friday's numbers)

        // ----- Section 2: one variable type, two kinds of object (LMS P6) -----
        System.out.println("--- 2. A Product variable ---");
        Product p = new Electronics("Keyboard", 75.0, 3);  // the variable says Product; the object is Electronics
        System.out.println(p);              // * PREDICT: Product's toString() or Electronics'?

        // SPOT THE BUG: uncomment. The variable type decides what you may call.
        // System.out.println(p.getWarrantyYears());

        // EXTRA: uncomment with getProducts() above. Who emptied Alice's order?
        // order.getProducts().clear();
        // order.printReceipt();
    }
}
