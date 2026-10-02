**Week 3 – Worksheet C: Static vs Instance Methods**



* Define “static method” in one sentence.



&#x09;A method which is defined in the class.



* Define “instance method” in one sentence.



&#x09;A method which has been instantiated.



* Which line correctly calls a static method from another class?



public class Utils {

&#x09;public static void sayHi() {

&#x09;	 System.out.println("Hi");

&#x09;}

}



public class Main {

&#x09;public static void main(String\[] args) {

&#x09;// A) sayHi();

&#x09;// B) Utils.sayHi();

&#x09;// C) new Utils().sayHi();

&#x09;}

}



&#x09;Choice "B" calls the sayHi method from Utils.



* Which line correctly calls an instance method?



public class Car {

&#x09;public void drive(){

&#x09;	System.out.println("Driving");

&#x09;}

}

public class Main {

&#x09;public static void main(String\[] args){

&#x09;	// A) Car.drive();

&#x09;	// B) new Car().drive();

&#x09;	// C) drive();

&#x09;}

}



&#x09;"B" instances the drive method from class Car.



* What will this print?



public class MathUtil {

&#x09;public static int square(int n){

&#x09;	return n \* n;

&#x09;}

}



System.out.println(MathUtil.square(5));



&#x09;It should print 25.



* Fill in the blanks: Static methods belong to the \_\_\_\_\_\_; instance methods belong to the \_\_\_\_\_\_.



&#x09;1. class

&#x09;2. object



* True/False: You must create an object to call a static method.



&#x09;False. You only need to create an object for instance methods.



* True/False: Static methods can be called from main without creating an object.



&#x09;True.



* Convert this instance method to static (assume no instance fields used):



public int doubleIt(int x){

&#x09;return x \* 2;

}



&#x09;public static int doubleIt(int x) {...}



* Why might a utility class (e.g., Math) use static methods?



&#x09;Utility classes are stateless and an object does not have to be created.

&#x09;Note: This question's material was not adequately explained in the module material.



* What error occurs if you try to call an instance method without an object?



&#x09;Compiler error.



* Write a tiny class Counter with an instance field count and an instance method inc() that adds 1.



&#x09;public class Counter {

&#x09;	int x = 0;

&#x09;	public static return int inc(int x) {

&#x09;		return x++;

&#x09;	}

&#x09;

&#x09;}



* Can a static method directly access instance fields? Why/why not?



&#x09;No, static methods run without an object.



* How do you call length() on a specific String object?



&#x09;Add .length() at the end of the String variable.



* Provide one example where an instance method is more appropriate than a static method.



&#x09;Having an AccountBalance instance object for each account.



* Provide one example where a static method is more appropriate than an instance method.



&#x09;If something relies on an input, it may be a better idea to have a static.



* Complete the object creation and call:



public class Lamp {

&#x09;public void on(){

&#x09;	System.out.println("On"); 

&#x09;} 

} 



public static void main(String\[] args){ 

&#x09;bigLamp = new Lamp(); 

&#x09;bigLamp.on(); 

}



* Fill in: Use ClassName.method() for Static methods; use object.method() for Instance methods.



* Static or instance? Arrays.sort(...)



&#x09;Static



* Static or instance? "hello".toUpperCase()



&#x09;Instance



* True/False: A static method can be called via an object reference (though discouraged).



&#x09;It can be done but the compiler will give you a warning.



* What access modifier is used most commonly for utility method libraries?



&#x09;Public.



* **Should stateful behavior typically be static or instance? Why?**



&#x09;Stateful implies there is session data being stored and objects being instanced, so I believe it would typically be instance.



&#x09;Discussion of stateful or stateless architecture was not present in the course material we have in our modules.



* **What is a potential downside of overusing statics in large systems?**



&#x09;Again, not really discussed in this week's material so far.

&#x09;According to [dantweb.dev](https://dantweb.dev/2025/02/static-methods-in-complex-software-sytems-pitfalls-logical-principles-and-cost-efficiency/), they can be harder to test, be less flexible in evolving systems and can present maintenance challenges.	



* **When designing an API, how do you decide between static vs. instance?**



&#x09;Also, not in this weeks course material so far.



