package week5.lab.answers.partC;

// C3 answer. A Product with a guarded price and stock quantity
// (LMS Securing Data with Encapsulation, Part 12, exercise 4).
class Product {
    private String name;
    private double price;
    private int stock;

    Product(String name, double price) {
        this.name = name;
        setPrice(price);            // reuse the setter's check
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price for " + name);
        }
    }

    public int getStock() {
        return stock;
    }

    public void restock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        }
    }

    public boolean sell(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            return true;
        }
        System.out.println("Cannot sell " + quantity + " " + name + ", only " + stock + " in stock");
        return false;
    }
}

public class C3ProductStock {
    public static void main(String[] args) {
        Product mouse = new Product("Mouse", 25.0);
        mouse.restock(10);
        mouse.sell(3);
        mouse.sell(20);
        mouse.setPrice(-5);
        System.out.println("Stock: " + mouse.getStock() + ", price: " + mouse.getPrice());
    }
}
