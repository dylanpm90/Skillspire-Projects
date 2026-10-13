Week 5 Worksheet: ArrayList Data Structures in Java 



* &#x20;   In one sentence, what is an ArrayList in Java and where does it live (which package)? 



An ArrayList is a resizable array implementation provided by the Java Collections Framework in java.util.







* &#x20;   Fill in the import and declaration to create an empty ArrayList<String> named names. 



**import** java.util.**ArrayList;**

**ArrayList**<String> names = new **ArrayList**<>(); 











* &#x20;   **True**/~~False~~: ArrayList can grow and shrink automatically at runtime. 











* &#x20;   Which is valid for ArrayList<Integer>? (Circle one) 

&#x20;   ~~a) add(42) b) add(0, 42)~~ **c) both** 



&#x20;







Creating \& Adding 



* &#x20;   Write code to create ArrayList<Integer> nums and add 10, 15 at index 0, then 20. 



ArrayList<Integer> numbers = new ArrayList<>(); 

numbers.add(10); 

numbers.add(0, 15);

numbers.add(20); 

&#x20;

System.out.println(numbers);







* &#x20;   What will this print? 



ArrayList<String> cities = new ArrayList<>(); 

cities.add("Paris"); 

cities.add("Prague"); 

cities.add(1, "Berlin"); 

System.out.println(cities); 



\[Paris, Berlin, Prague]





* &#x20;   Fill in to add three names, then print the list: 



ArrayList<String> names = new ArrayList<>(); 

names.add("Alice"); 

names.add("Bob"); 

names.add("Charlie"); 



// add "Alice", "Bob", "Charlie" 

System.out.println(names); 









&#x20;



Accessing \& Updating 



* &#x20;   How do you get the first element of names? (Write the exact statement.) 



System.out.println(names.get(0));







* &#x20;   Replace the element at index 1 with "David": 



ArrayList<String> names = new ArrayList<>(List.of("Alice","Bob","Charlie")); // write one line here 



names.set(1, "David");  





* &#x20;   What exception could be thrown by names.get(5) if names.size() is 3? 



Index out of bounds error





&#x20;



Removing 



* &#x20;   Remove by value the string "Alice" from names. 



names.remove("Alice");





* &#x20;   Remove by index the first element from names. 



names.remove(0);



* &#x20;   Given: 



ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3)); nums.remove(1); System.out.println(nums); 



* What is printed and why? (Value vs index?) 

\[1,3] is printed because the value at index 1 is removed.

&#x20;









Size \& Contains 



* &#x20;   Complete: 



ArrayList<String> items = new ArrayList<>(List.of("pen","pad")); System.out.println(items.\_\_\_\_()); // number of elements System.out.println(items.\_\_\_\_\_\_\_\_("pad")); // check membership 



* &#x20;   **True**/~~False:~~ ArrayList preserves insertion order. 









* &#x20;   **True**/~~False~~: ArrayList allows duplicate values. 









&#x20;



Iteration 



* &#x20;   Write a for-index loop to print each element of names on its own line. 











* &#x20;   Write an enhanced for-each loop to do the same. 











* &#x20;   Using an Iterator<String> it = names.iterator();, write a while loop to print all elements. 











* &#x20;   Why should you prefer enhanced for-each over repeated get(i) calls in large lists? 



&#x20;









ArrayList vs Array 



* &#x20;   Fill in the table (write Array or ArrayList): 











* &#x20;   Fixed size: \_\_\_\_\_\_ 











* &#x20;   Stores primitives directly: \_\_\_\_\_\_ 









* &#x20;   Has methods like add/remove/contains: \_\_\_\_\_\_ 









* &#x20;   Better when size changes a lot: \_\_\_\_\_\_ 









* &#x20;   Convert an array to an ArrayList (any valid approach): 



String\[] arr = {"A","B","C"}; // make ArrayList<String> list from arr 



&#x20;



Sorting \& Utilities 



* &#x20;   Import and call sort to alphabetically sort names. 



\_\_\_\_\_\_ java.util.\_\_\_\_\_\_\_\_\_\_\_\_; Collections.\_\_\_\_(names); 







* &#x20;   After names.clear();, what will names.isEmpty() return? 









* &#x20;   Write a line that finds the first index of "Bob" and the last index of "Bob" in names. 



&#x20;





Real-World Scenarios 



* &#x20;   Shopping cart: Create ArrayList<String> cart, add "Laptop", "Mouse", remove "Mouse", print the cart. 









* &#x20;   Student management: Create ArrayList<Student> students and add two Student objects (constructor Student(String, int) assumed). 









* &#x20;   Playlist: Add three songs to ArrayList<String> playlist and print them one per line (choose any loop). 



&#x20;









Common Mistakes 



* &#x20;   What is wrong here? Fix it. 



ArrayList<int> list = new ArrayList<>(); 









* &#x20;   Explain why this throws an error and how to prevent it: 



ArrayList<String> names = new ArrayList<>(List.of("A","B")); System.out.println(names.get(2)); 









* &#x20;   What is the difference between these two removes? 



nums.remove(1); nums.remove(Integer.valueOf(1)); 



&#x20;









Best Practices 



* &#x20;   Rewrite this declaration to program to the interface: 



ArrayList<String> logs = new ArrayList<>(); 









* &#x20;   Why should you check isEmpty() (or size() > 0) before calling get(0)? 











* &#x20;   Which loop style is safest when removing items during iteration: for-each or Iterator + remove()? (Explain briefly.) 



&#x20;



Applied / Mini-Tasks 



* &#x20;   Sum of list: Given ArrayList<Integer> scores, write code to compute and print the sum. 









* &#x20;   Max value: Write a method static int max(ArrayList<Integer> a) that returns the largest element (assume non-empty). 









* &#x20;   Reverse print: Print names in reverse order without modifying the list. 











* &#x20;   Unique filter: Using an auxiliary HashSet<String> seen, write code to build a new ArrayList<String> unique that keeps first occurrences only (preserve order). 









* &#x20;   Cities sort: Create ArrayList<String> cities with at least five names (mixed case) and print them sorted case-insensitively (hint: sort(String.CASE\_INSENSITIVE\_ORDER)). 











&#x20;   Roster with objects: 



* &#x20;   Define a simple Student class with fields name and age and a constructor. 











* &#x20;   Create ArrayList<Student> roster and add three students. 











* &#x20;   Loop and print each as name (age). 



&#x20;



Bonus: Iterator Removal Safety 



* &#x20;   Fix the bug (concurrent modification) by using the iterator’s remove(): 



ArrayList<String> list = new ArrayList<>(List.of("keep","drop","keep")); for (String s : list) { if (s.equals("drop")) list.remove(s); // BUG: fix this loop } 



&#x20;









Challenge 



* &#x20;   Inventory system: 

&#x20;   Define a Product(String name, double price). 

&#x20;   Create ArrayList<Product> inventory. 

&#x20;   Add at least four products. 









* &#x20;   Print the average price. 







* &#x20;   Remove any product with price < 10. 



&#x20;   Sort remaining by price ascending (you may use a lambda with Comparator.comparing(p -> p.price) or write a comparator class). 



* &#x20;   Print the final list. 



&#x20;



Reflection (1–2 lines each) 



* &#x20;   When would you choose an array over an ArrayList? 









* &#x20;   What’s one bug you’ve seen today that ArrayList’s API helps you avoid? 









* &#x20;   Name one Collections utility (other than sort) that you’d try next and why. 









