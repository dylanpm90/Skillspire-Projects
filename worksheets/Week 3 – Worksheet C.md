**Week 3 – Worksheet C: Static vs Instance Methods** 



* Define “static method” in one sentence. 



* Define “instance method” in one sentence. 



* Which line correctly calls a static method from another class? 



public class Utils { public static void sayHi(){ System.out.println("Hi"); } } public class Main { public static void main(String\[] args){ // A) sayHi(); // B) Utils.sayHi(); // C) new Utils().sayHi(); } } 



* Which line correctly calls an instance method? 



public class Car { public void drive(){ System.out.println("Driving"); } } public class Main { public static void main(String\[] args){ // A) Car.drive(); // B) new Car().drive(); // C) drive(); } } 



* What will this print? 



public class MathUtil { public static int square(int n){ return n \* n; } } System.out.println(MathUtil.square(5)); 



* Fill in the blanks: Static methods belong to the \_\_\_\_\_\_; instance methods belong to the \_\_\_\_\_\_. 



* True/False: You must create an object to call a static method. 



* True/False: Static methods can be called from main without creating an object. 



* Convert this instance method to static (assume no instance fields used): 



public int doubleIt(int x){ return x \* 2; } 



* Why might a utility class (e.g., Math) use static methods? 



* What error occurs if you try to call an instance method without an object? 



* Write a tiny class Counter with an instance field count and an instance method inc() that adds 1. 



* Can a static method directly access instance fields? Why/why not? 



* How do you call length() on a specific String object? 



* Provide one example where an instance method is more appropriate than a static method. 



* Provide one example where a static method is more appropriate than an instance method. 



* Complete the object creation and call: 



public class Lamp { public void on(){ System.out.println("On"); } } public static void main(String\[] args){ \_\_\_\_\_\_ = new Lamp(); \_\_\_\_\_\_.on(); } 



* Fill in: Use ClassName.method() for \_\_\_\_\_\_ methods; use object.method() for \_\_\_\_\_\_ methods. 



* Static or instance? Arrays.sort(...) 



* Static or instance? "hello".toUpperCase() 



* True/False: A static method can be called via an object reference (though discouraged). 



* What access modifier is used most commonly for utility method libraries? 



* Should stateful behavior typically be static or instance? Why? 



* What is a potential downside of overusing statics in large systems? 



* When designing an API, how do you decide between static vs. instance? 

