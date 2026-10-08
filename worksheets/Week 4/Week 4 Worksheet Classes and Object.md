Week 4 Worksheet: Classes and Objects in Java 



* &#x20;   In one line: What is a class? What is an object? 



A class defines properties and behaviors for an object, which is the actual thing with those defined properties and behaviors.





* &#x20;   Fill in class vs object: 



&#x20;   Car blueprint →  model, year and a drive() method



&#x20;   new Car() → Hyundai Sonata is driving.









* &#x20;   Complete the class and method call: 



class Car { 

&#x09;String model; 

&#x09;int year; 

&#x09;void drive(){ 

&#x09;	System.out.println(model + " driving"); 

&#x09;} 

} 





public class Main { 

&#x09;public static void main(String\[] args){ 

&#x09;	Car c = **new** Car(); 

&#x09;	c.model = "Civic"; 

&#x09;	c.year = 2022; 

&#x09;	c**.drive();** 

&#x09;} 

} 









* &#x20;   **True**/~~False~~: Fields are also called attributes or instance variables. 









* &#x20;   Add a parameterized constructor to set model and year. 









* &#x20;   What will this print? 



class Student { 

&#x09;String name; 

&#x09;void introduce(){ 

&#x09;	System.out.println("I am " + name); 

&#x09;} 

} 

Student s = new Student(); 

s.name = "Alex"; 

s.introduce(); 









* &#x20;   Why use private fields and public getters/setters? One sentence. 



It can help protect sensitive information with access control.





* &#x20;   Implement getters/setters for private double balance. 



class Account { 

&#x20;   private double balance; 

&#x20;

&#x20;   public void deposit(double amount) { 

&#x20;       balance += amount; 

&#x20;   } 

&#x20;   public double getBalance() { 

&#x20;       return balance; 

&#x20;   } 

}





* &#x20;   Fix the constructor using this: 



class Book { 

&#x09;String title; 

&#x09;Book(String title){ 

&#x09;	**this.**title = title; 	// refers to the title in 

&#x09;				// this constructor block.

&#x09;} 

} 









* &#x20;   What is the default value of an object field (e.g., String title) if not initialized? 



null





* &#x20;   Which access modifier allows use only within the same class? 



private





* &#x20;   Complete encapsulation: 



class Account { 

&#x09;private double balance; 

&#x09;public void deposit(double amt){ 

&#x09;	balance += amount; 

&#x09;} 

&#x09;public double getBalance(){ 

&#x09;	return balance; 

&#x09;} 

} 









* &#x20;   Create two Car objects and show they don’t share instance state. 









* &#x20;   True/False: You can call instance methods without creating an object. 









* &#x20;   When might a static method be appropriate in a class? (Give one example.) 









* &#x20;   What does this print and why? 



class Counter { 

&#x09;static int total = 0; 

&#x09;Counter(){ 

&#x09;	total++; 

&#x09;} 

} 

new Counter(); 

new Counter(); 

System.out.println(Counter.total); 



2





* &#x20;   Add a no-arg constructor that sets defaults and a second constructor that takes all fields. 









* &#x20;   Which line is correct to call display() on Product p? 

&#x20;  ~~a) Product.display();~~ **b) p.display();** 









* &#x20;   Complete: 



class Server { 

&#x09;String region; 

&#x09;void deploy(String app){ 

&#x09;	System.out.println("Deploy " + app + " in " + region); 

&#x09;} 

} 

Server s = new Server(); 

s.region = "eu-west"; 

s.**deploy**("api"); 









* &#x20;   Why should class names use PascalCase and methods use camelCase? 



It helps with readability when using this convention in collaboration with other programmers.





* &#x20;   One sentence: What is a constructor used for? 









* &#x20;   Write a toString() method for a Student(name, age). 











* &#x20;   What error do you get calling a method on a null reference? 



NullPointerException







* &#x20;   Show one advantage of modeling with classes vs using only functions \& arrays. 











* &#x20;   Small design prompt: Sketch fields and one method for a Product class. 









