import static java.lang.String.format;

public static void main(String[] args) {
    class Product {
        String name;
        double price;

        Product(String n, double p) {
            name = n;
            price = p;
        }
    }
    ArrayList<Product> inventory = new ArrayList<>();
    inventory.add(new Product("Laptop", 1200.00));
    inventory.add(new Product("Mouse", 25.00));

    for (Product item : inventory) {
        System.out.println(item.name + ", $" + format("%.2f", item.price) + ".");
    }

    ArrayList<Integer> intList = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i <= 10; i++) {
        intList.add(i);
        System.out.print(intList.get(i) + " ");
        sum += i;

    }
    System.out.println('\n' + "Sum: " + sum);
}
