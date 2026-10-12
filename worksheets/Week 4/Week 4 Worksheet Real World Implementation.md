Week 4 Worksheet: Implementing Real-World Entities in Java 



* &#x20;   Identify nouns and verbs in “A store sells products to customers using orders.” 



Nouns - store, products, customers, orders

Verbs - Sells, using





* &#x20;   Convert these to classes (names only): customer, product, order. 



class Customer{

}

class Product{

}

class Order{

}





* &#x20;   For Product, list two fields and one method (names only). 



class Product{

String name;

double price;

&#x09;void display(){

&#x09;	System.out.println("Product: " + name + ". Price: $" + price + ".");

}

}





* &#x20;   Implement a minimal Product: 



class Product { 

&#x09;String name; 

&#x09;double price; 

&#x09;

&#x09;void display(){ 

&#x09;	System.out.println(name + ": $" + price); 

&#x09;} 

} 

// ... main 

Product p1 = new Product();

p1.name = "Clorox Wipes";

p1.price = 5.99;

p1.display();

// ... /main







What will new Product().display() print if fields aren’t set? 



null, 0





1\) Add a constructor to set name and price. 



Product(String n, double p) {

&#x09;name = n;

&#x09;price = p;

}







2\) Implement Cart with Product\[] items and double total() (sum prices, ignore nulls). 



class Cart {

&#x09;String\[] contents = Product\[] items;

&#x09;public static double total(double\[] prices);





}





3\) Fill with encapsulation: 



class Account { 

&#x09;private double balance; 

&#x09;public void deposit(double amt){ 

&#x09;	balance += amount; 

&#x09;} 



&#x09;public boolean withdraw(double amt){ 

&#x09;	if(amt <= balance){ 

&#x09;		balance -= amount; 

&#x09;		return true; 

&#x09;	} 

&#x09;	return false; 

&#x09;} 



&#x09;public double getBalance(){ 

&#x09;return balance;  

&#x09;} 

} 



* &#x20;   Show one-to-one: 



class Passport { 

&#x09;String number; 

} 



class Person { 

&#x09;String name; 

&#x09;Passport passport; 

} 









* &#x20;   Show one-to-many with an array field in Course or Student. 



class Course { 

&#x20;   String title; 

} 

class Student { 

&#x20;   String name; 

&#x20;   Course\[] courses;  // one-to-many 

} 





* &#x20;   True/**False**: Every relationship should use inheritance. 









* &#x20;   Prefer composition: Give one example replacing inheritance with has-a. 



Instead of inheriting all of the Bird class, a duck has float(), fly(), and quack().





* &#x20;   Implement a simple Library: 



class Book { 

&#x09;String title; 

&#x09;boolean available = true; 

&#x09;void borrow(){ 

&#x09;	available=false; 

&#x09;} 

} 



class Library { 

&#x09;Book\[] books; 

&#x09;// Write a method findAvailable() that prints titles where available == true; 

&#x20;   	void findAvailable(Book\[] books){

&#x09;	for (book : books) {

&#x09;		if (available == true){

&#x09;			System.out.println("Title: " +title + " 				is available.");

&#x09;		}

&#x09;	} else {

&#x09;	System.out.println("Not available");

&#x09;	}		

&#x09;}

}

&#x20;



&#x20;   What will this print? 



class Patient { 

&#x09;double temperature; 

&#x09;boolean hasFever(){ 

&#x09;	return temperature > 100.4; 

&#x09;} 

} 



Patient p = new Patient(); 

p.temperature = 99.5; 

System.out.println(p.hasFever()); 



false





* &#x20;   Add getters/setters for private String name in Student. 



public class Student {

&#x09;private String name;

}



public String getName(){

&#x09;return name;

}



public void setName(String newName){

&#x09;this.name = newName;

}





* &#x20;   Implement Order with fields Product\[] items, String status, and method confirm() that sets status to "CONFIRMED". 



public class Order {

&#x09;Product\[] items;

&#x09;String status;

&#x09;public void confirm(){

&#x09;	status = "CONFIRMED";

&#x09;}

}





* &#x20;   Build a tiny model of a Server that deploys an app only if active == true. 



class Server { 

&#x20;   String region; 

&#x20;   boolean active; 

&#x20;

&#x20;   void deploy(String appName) { 

&#x20;       if (active) { 

&#x20;           System.out.println("Deploying " + appName + " in " + region); 

&#x20;       } 

&#x20;   } 

} 





* &#x20;   Where would you validate inputs: in constructors, setters, or both? (1–2 lines) 



It's common to do it in both depending on the whether the redundancy is useful.





* &#x20;   What anti-pattern is this? Why is it bad? 



class EverythingManager { 

&#x09;Product\[] products; 

&#x09;Account\[] accounts; 

&#x09;Patient\[] patients; 

&#x09;// and 50 more 

&#x09;void doAll(){ 

&#x09;	/\* hundreds of responsibilities \*/ 

&#x09;} 

} 



It's hard for other collaborators to assess and it is poor design, breaking the single purpose convention.



* &#x20;   Pick better names: Data, Thing, Stuff → (write 3 specific class names). 



Data - Receipt

Thing - Product

Stuff - Server





* &#x20;   Implement a Receipt class with double total, String id, and String toString() that formats both. 



public class Receipt {

&#x09;double total;

&#x09;String id;

&#x09;

&#x09;String toString(double total, String id){

&#x09;	return String result = "Total: $" + total + ". ID: " + id + ".";

&#x09;}

}





* &#x20;   Show object creation for two Students and a Course, and assign both students to the course (array or list pseudocode OK). 



Student s1 = new Student();

Student s2 = new Student();

Course math = new Course();



Student\[] newStudents.addNew(s1);

Student\[] newStudents.addNew(s2);



math.addToRoster(Student\[] newStudents);





* &#x20;   Design prompt: Sketch fields for a Transaction class (3–4 fields). 



class Transaction {

&#x09;String name;

&#x09;double price;

&#x09;int inventory;

&#x09;String productType;

}









* &#x20;   Add a method applyDiscount(double rate) to Product that updates price. 



class Product{

&#x09;double applyDiscount(double price, double discount){

&#x09;	return double newPrice = price - discount;

}

}





* &#x20;   Where would you use static in a retail system? Give one appropriate example. 



math methods would be appropriate, like applying a 20% discount to a certain product.





* &#x20;   One paragraph (3–4 lines): Explain how classes/objects make a system easier to extend (e.g., adding a new payment method).



You can invoke the constructor to create a new object with all the same attributes and functionality of the class and then modify it.





&#x20;

