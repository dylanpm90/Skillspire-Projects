import java.util.*;

public class FirstOccurence {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList with duplicates
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        System.out.println("Original List: " + fruits);
        // Output: [Apple, Banana, Apple, Orange, Banana]

        // Step 2: Convert ArrayList to LinkedHashSet to remove duplicates
        Set<String> uniqueFruitsSet = new LinkedHashSet<>(fruits);

        // Step 3: Convert LinkedHashSet back to ArrayList
        List<String> uniqueFruitsList = new ArrayList<>(uniqueFruitsSet);

        System.out.println("Duplicate-Free List (Order Preserved): " + uniqueFruitsList);
        // Output: [Apple, Banana, Orange]
    }


}
