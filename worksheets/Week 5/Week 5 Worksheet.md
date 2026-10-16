Week 5 Worksheet 



**ArrayList Data Structures in Java** 



* &#x20;   In one sentence, what is an ArrayList in Java and where does it live (which package)? 



An ArrayList is a resizable array implementation provided by the Java Collections Framework.





* &#x20;   Fill in the import and declaration to create an empty ArrayList<String> named names. 



**import** java.util.ArrayList;

**ArrayList**<String> names = new **ArrayList<>()**;







* &#x20;   **True**/~~False~~: ArrayList can grow and shrink automatically at runtime. 









* &#x20;   Which is valid for ArrayList<Integer>? (Circle one) 

&#x20;   ~~a) add(42) b) add(0, 42)~~ **c) both** 



&#x20;



**Creating \& Adding** 



* &#x20;   Write code to create ArrayList<Integer> nums and add 10, 15 at index 0, then 20. 

ArrayList<Integer> nums = new ArrayList<>();

nums.add(10);

nums.add(0, 15);

nums.add(20);

System.out.println(nums);







* &#x20;   What will this print? 



ArrayList<String> cities = new ArrayList<>(); 

cities.add("Paris"); 

cities.add("Prague"); 

cities.add(1, "Berlin"); 

System.out.println(cities); 



\[Paris, Berlin, Prague]



* &#x20;   Fill in to add three names, then print the list: 



ArrayList<String> names = new ArrayList<>(); 

// add "Alice", "Bob", "Charlie" 

names.add("Alice");

names.add("Bob");

names.add("Charlie");

System.out.println(names); 



&#x20;



Accessing \& Updating 



* &#x20;   How do you get the first element of names? (Write the exact statement.) 



names.get(0);





* &#x20;   Replace the element at index 1 with "David": 



ArrayList<String> names = new ArrayList<>(List.of("Alice","Bob","Charlie")); 

names.add(1, "David");



* &#x20;   What exception could be thrown by names.get(5) if names.size() is 3? 

Out of Bounds exception

&#x20;



**Removing** 



* &#x20;   Remove by value the string "Alice" from names. 



names.remove("Alice");







* &#x20;   Remove by index the first element from names. 

names.remove(0);







* &#x20;   Given: 



ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3)); 

nums.remove(1); 

System.out.println(nums); 





* What is printed and why? (Value vs index?) 



\[1, 3], it removes by index, not by value.







**Size \& Contains** 



* &#x20;   Complete: 



ArrayList<String> items = new ArrayList<>(List.of("pen","pad"));

System.out.println(items**.size());** 

// number of elements 

System.out.println(items**.contains("**pad")); 

// check membership 



* &#x20;   **True**/~~False~~: ArrayList preserves insertion order. 





* &#x20;   **True**/~~False~~: ArrayList allows duplicate values. 



&#x20;



**Iteration** 



* &#x20;   Write a for-index loop to print each element of names on its own line. 



for (i = 0; i < names.size(); i++){

&#x09;System.out.println(names.get(i));

}





* &#x20;   Write an enhanced for-each loop to do the same. 



for (String name : names) {

&#x09;System.out.println(name);

}







* &#x20;   Using an Iterator<String> it = names.iterator();, write a while loop to print all elements. 



ArrayList<String> names = new ArrayList<>(List.of("Alice", "Bob", "Jane"));



&#x20;   Iterator<String> it = names.iterator();

&#x20;   while (it.hasNext()) {

&#x20;       System.out.println(it.next());

&#x20;   }







* &#x20;   Why should you prefer enhanced for-each over repeated get(i) calls in large lists? 



&#x20;Excessive get() calls take a lot of compute resources and it is more efficient to use the enhanced for-each.









**ArrayList vs Array** 



* &#x20;   Fill in the table (write Array or ArrayList): 







* &#x20;   Fixed size: **ARRAY** 







* &#x20;   Stores primitives directly: **ARRAY**







* &#x20;   Has methods like add/remove/contains: **ARRAYLIST** 







* &#x20;   Better when size changes a lot**: ARRAYLIST** 







* &#x20;   Convert an array to an ArrayList (any valid approach): 



&#x20;   String\[] arr = {"A","B","C"};

&#x20;   ArrayList<String> arrList = new ArrayList<>();



&#x20;   for (String element : arr){

&#x20;       arrList.add(element);

&#x20;   }

&#x20;   System.out.println(arrList);





**Sorting \& Utilities** 



* &#x20;   Import and call sort to alphabetically sort names. 



**import** java.util.**Collections**; Collections**.sort(**names); 







* &#x20;   After names.clear();, what will names.isEmpty() return? 



true





* &#x20;   Write a line that finds the first index of "Bob" and the last index of "Bob" in names. 



indexOf("Bob");

lastIndexOf("Bob);

&#x20;



**Real-World Scenarios** 



* &#x20;   Shopping cart: Create ArrayList<String> cart, add "Laptop", "Mouse", remove "Mouse", print the cart. 



&#x20;   ArrayList<String> cart = new ArrayList<>();

&#x20;   cart.add("Laptop");

&#x20;   cart.add("Mouse");

&#x20;   cart.remove("Mouse");





&#x20;   System.out.println(cart);





* &#x20;   Student management: Create ArrayList<Student> students and add two Student objects (constructor Student(String, int) assumed). 



public class StudentRoster {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<Student> students = new ArrayList<>();

&#x20;       students.add(new Student("Alice", 20));

&#x20;       students.add(new Student("Bob", 19));



&#x20;       for (int i = 0; i < students.size(); i++) {

&#x20;           System.out.println(students.get(i));

&#x20;       }

&#x20;   }

}

class Student {

&#x20;   String name;

&#x20;   int age;



&#x20;   Student(String n, int a) {

&#x20;       this.name = n;

&#x20;       this.age = a;

&#x20;   }



&#x20;   @Override

&#x20;   public String toString() {

&#x20;       return "Student { name = '" + name + "', age = " + age + " }";

&#x20;   }



}





* &#x20;   Playlist: Add three songs to ArrayList<String> playlist and print them one per line (choose any loop). 



public class Playlist {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<String> playlist = new ArrayList<>();

&#x20;       playlist.add("Since You've Been Gone");

&#x20;       playlist.add("Break Stuff");

&#x20;       playlist.add("In the Hall of the Mountain King");



&#x20;       for (String song : playlist){

&#x20;           System.out.println(song);

&#x20;       }

&#x20;   }

}







**Common Mistakes** 



* &#x20;   What is wrong here? Fix it. 



ArrayList<**Integer**> list = new ArrayList<>(); 



* &#x20;   Explain why this throws an error and how to prevent it: 



ArrayList<String> names = new ArrayList<>(List.of("A","B")); System.out.println(names.get(2)); 



Out of Bounds exception, the size of the arraylist is smaller than what is being called in the get method



* &#x20;   What is the difference between these two removes? 



nums.remove(1); nums.remove(Integer.valueOf(1)); 



&#x20;



**Best Practices** 



* &#x20;   **Rewrite this declaration to program to the interface:** 



ArrayList<String> logs = new ArrayList<>(); 



This declaration, as is, is using generics, encouraging type safety.







* &#x20;   Why should you check isEmpty() (or size() > 0) before calling get(0)? 



To prevent a divide by zero error





* &#x20;   Which loop style is safest when removing items during iteration: for-each or Iterator + remove()? (Explain briefly.) 



Using for-each instead of Iterator + remove can lead to ConcurrentModificationException. 



The Iterator + remove() approach "ensures the iterator’s internal state remains synchronized with the collection." - [Kloudly Academy](https://nkamphoa.com/using-iterators-and-for-each-loop-safely/)



&#x20;



**Applied / Mini-Tasks** 



* &#x20;   Sum of list: Given ArrayList<Integer> scores, write code to compute and print the sum. 



ArrayList<Integer> scores = new ArrayList<>(List.of(1, 2, 3, 4, 5));

&#x20;   int sum = 0;

&#x20;   for (int i : scores){

&#x20;       sum += i;

&#x20;   }

&#x20;   System.out.println(sum);





* &#x20;   Max value: Write a method static int max(ArrayList<Integer> a) that returns the largest element (assume non-empty). 



void main() {



&#x20;   ArrayList<Integer> scores = new ArrayList<>(List.of(6, 2, 22, 4, 5));

&#x20;   int maxResult = max(scores);

&#x20;   System.out.println(maxResult);

}



static int max(ArrayList<Integer> a) {

&#x20;   int max = 0;

&#x20;   for (int i : a) {

&#x20;       if (i > max) {

&#x20;           max = i;

&#x20;       }

&#x20;   }

&#x20;   return max;

}





* &#x20;   Reverse print: Print names in reverse order without modifying the list. 



public class ReverseNameWorksheetEx {

&#x20;   public static void main(String\[] args) {

&#x20;       ArrayList<String> names = new ArrayList<>();

&#x20;       names.add("John");

&#x20;       names.add("Mary");

&#x20;       names.add("Nadine");



&#x20;       for (int i = names.size() - 1; i >= 0; i--) {

&#x20;           System.out.println(names.get(i));



&#x20;       }

&#x20;   }

}





* &#x20;   **Unique filter: Using an auxiliary HashSet<String> seen, write code to build a new ArrayList<String> unique that keeps first occurrences only (preserve order).** 

&#x09;

&#x09;public static void main(String\[] args) {

&#x20;       // Step 1: Create an ArrayList with duplicates

&#x20;       List<String> fruits = new ArrayList<>();

&#x20;       fruits.add("Apple");

&#x20;       fruits.add("Banana");

&#x20;       fruits.add("Apple");

&#x20;       fruits.add("Orange");

&#x20;       fruits.add("Banana");



&#x20;       System.out.println("Original List: " + fruits);

&#x20;       // Output: \[Apple, Banana, Apple, Orange, Banana]



&#x20;       // Step 2: Convert ArrayList to LinkedHashSet to remove duplicates

&#x20;       Set<String> uniqueFruitsSet = new LinkedHashSet<>(fruits);



&#x20;       // Step 3: Convert LinkedHashSet back to ArrayList

&#x20;       List<String> uniqueFruitsList = new ArrayList<>(uniqueFruitsSet);



&#x20;       System.out.println("Duplicate-Free List (Order Preserved): " + uniqueFruitsList);

&#x20;       // Output: \[Apple, Banana, Orange]

&#x20;   }







* &#x20;   Cities sort: Create ArrayList<String> cities with at least five names (mixed case) and print them sorted case-insensitively (hint: sort(String.CASE\_INSENSITIVE\_ORDER)). 



static void main(String\[] args) {

&#x20;       ArrayList<String> cities = new ArrayList<>();

&#x20;       cities.add("Chicago");

&#x20;       cities.add("dallas");

&#x20;       cities.add("NEW YORK CITY");

&#x20;       cities.add("LoS aNgElEs");



&#x20;       // without sorting

&#x20;       System.out.println("Unsorted: " + cities);

&#x20;       cities.sort(String.CASE\_INSENSITIVE\_ORDER);

&#x20;       System.out.println("Case Insensitive Sorting: " + cities);



&#x20;   }





* &#x20;   Roster with objects: 



public class StudentRoster {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<Student> students = new ArrayList<>();

&#x20;       students.add(new Student("Alice", 20));

&#x20;       students.add(new Student("Bob", 19));



&#x20;       for (int i = 0; i < students.size(); i++) {

&#x20;           System.out.println(students.get(i));

&#x20;       }

&#x20;   }

}

class Student {

&#x20;   String name;

&#x20;   int age;



&#x20;   Student(String n, int a) {

&#x20;       this.name = n;

&#x20;       this.age = a;

&#x20;   }



&#x20;   @Override

&#x20;   public String toString() {

&#x20;       return "Student { name = '" + name + "', age = " + age + " }";

&#x20;   }



}





* &#x20;   Define a simple Student class with fields name and age and a constructor. 



public class StudentRoster {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<Student> students = new ArrayList<>();

&#x20;       students.add(new Student("Alice", 20));

&#x20;       students.add(new Student("Bob", 19));



&#x20;       for (int i = 0; i < students.size(); i++) {

&#x20;           System.out.println(students.get(i));

&#x20;       }

&#x20;   }

}

class Student {

&#x20;   String name;

&#x20;   int age;



&#x20;   Student(String n, int a) {

&#x20;       this.name = n;

&#x20;       this.age = a;

&#x20;   }



&#x20;   @Override

&#x20;   public String toString() {

&#x20;       return "Student { name = '" + name + "', age = " + age + " }";

&#x20;   }



}





* &#x20;   Create ArrayList<Student> roster and add three students. 



public class StudentRoster {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<Student> students = new ArrayList<>();

&#x20;       students.add(new Student("Alice", 20));

&#x20;       students.add(new Student("Bob", 19));

&#x20;       students.add(new Student("Beatrice", 21));



&#x20;       for (int i = 0; i < students.size(); i++) {

&#x20;           System.out.println(students.get(i));

&#x20;       }

&#x20;   }

}

class Student {

&#x20;   String name;

&#x20;   int age;



&#x20;   Student(String n, int a) {

&#x20;       this.name = n;

&#x20;       this.age = a;

&#x20;   }



&#x20;   @Override

&#x20;   public String toString() {

&#x20;       return "Student { name = '" + name + "', age = " + age + " }";

&#x20;   }



}







* &#x20;   Loop and print each as name (age). 



&#x20;public class StudentRoster {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<Student> students = new ArrayList<>();

&#x20;       students.add(new Student("Alice", 20));

&#x20;       students.add(new Student("Bob", 19));

&#x20;       students.add(new Student("Beatrice", 21));



&#x20;       for (int i = 0; i < students.size(); i++) {

&#x20;           System.out.println(students.get(i));

&#x20;       }

&#x20;   }

}

class Student {

&#x20;   String name;

&#x20;   int age;



&#x20;   Student(String n, int a) {

&#x20;       this.name = n;

&#x20;       this.age = a;

&#x20;   }



&#x20;   @Override

&#x20;   public String toString() {

&#x20;       return "Student: " + name + " (" + age + ")";

&#x20;   }



}







**Bonus: Iterator Removal Safety** 



* &#x20;   Fix the bug (concurrent modification) by using the iterator’s remove(): 



public class IteratorRemoval {

&#x20;   static void main(String\[] args) {

&#x20;       ArrayList<String> list = new ArrayList<>(List.of("keep", "drop", "keep"));

&#x20;       Iterator<String> it = list.iterator();

&#x20;       while (it.hasNext()) {

&#x20;           if (it.next().equals("drop")) {

&#x20;               it.remove();

&#x20;           }

&#x20;       }

&#x20;       System.out.println(list);

&#x20;   }

} 



&#x20;



**Challenge** 



* &#x20;   Inventory system: 
1. Define a Product(String name, double price). 
2. Create ArrayList<Product> inventory. 
3. Add at least four products. 
4. Print the average price. 
5. Remove any product with price < 10. 
6. Sort remaining by price ascending (you may use a lambda with Comparator.comparing(p -> p.price) or write a comparator class). 
7. Print the final list. 













**Reflection (1–2 lines each)** 



* &#x20;   When would you choose an array over an ArrayList? 









* &#x20;   What’s one bug you’ve seen today that ArrayList’s API helps you avoid? 









* &#x20;   Name one Collections utility (other than sort) that you’d try next and why. 











