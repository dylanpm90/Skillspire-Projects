Week 3 – Worksheet A: Creating \& Calling Methods in Java 



* In one sentence, what is a method in Java? 



&#x09;A method is a reusable block of code meant to perform a specific task.



* Write the method header for a public static method named greet that takes no parameters and returns nothing. 



&#x09;public static void greet(){ //code block }



* Where is a method called in this example, and where is it defined? 



public class HelloWorld { public static void greet() { System.out.println("Hello, World!"); } public static void main(String\[] args) { greet(); } } 



* What will this program print? 



&#x09;public class Printer { 

&#x09;	public static void printWelcome() { 

&#x09;		System.out.println("Welcome to Skillspire Academy!"); 

&#x09;	} 

&#x09;	public static void main(String\[] args) { 

&#x09;		printWelcome(); 

&#x09;		printWelcome(); 

&#x09;	} 

&#x09;} 

&#x09;

&#x09;The printWelcome method was called twice, so "Welcome to Skillspire Academy!" twice on separate lines.



* What is the difference between a method definition and a method call? 



&#x09;When a method is defined, the modifier, return type, method name, parameters are written and then the code block is written inside the curly brackets. 



&#x09;When a method is called, just the name and parameters are written. If the method is called correctly, the method will be executed.



* True/False: A method must always return a value. 



&#x09;False, a void method does not return a value.



* Fill in the blanks: 

&#x09;	public static void methodName(int argName) {

&#x20;			int sampleNumber = argName;  

&#x09;		System.out.println(sampleNumber);

&#x09;	} 



&#x09;



* Complete the method so it compiles: 



public class Demo { public static void sayHi() { System.out.println("Hi!"); } } 



* Which identifier is a better method name and why: doStuff() or printReceipt()? 



&#x09;printReceipt() is better because it describes the intent of the method.



* Write a method printLine() that prints 30 dashes ------------------------------. 



&#x09;public static void printLine() {

&#x09;	System.out.println("------------------------------");

&#x09;}





* What keyword indicates that a method does not return any value? 



&#x09;The keyword "void" in the return type of a method definition means that the method will return nothing.



* Where should methods be placed relative to main(String\[] args) in a class file? 



&#x09;Called methods should be placed within the main method. Method descriptions can be developed outside the main method.



* What does the compiler error “method not found” usually indicate when calling a method?



&#x09;It probably means that the method was not defined or a typo.	 



* Convert this single-line method to a multi-line formatted method: 



&#x09;public static void yes(){System.out.println("Yes");} 



* Write a method printTitle(String title) that prints the title surrounded by === on both sides. Example: === Java ===. 



&#x09;public static void printTitle(String title){

&#x09;	System.out.println("=== " + title + " ===");

&#x09;}



* Why is it cleaner to call a method multiple times than to copy-paste the same print statement? 



&#x09;Utilizes the DRY principle. Code happens in one place, in the method which was called.



* Fill in the blank: Methods help us achieve modularity, readability, and reusability. 



* Add a second call so this prints the message twice: 



public static void show(){ System.out.println("Ready"); } public static void main(String\[] args){ show(); show();} 



* What will the following print? 



public static void beep(){ System.out.println("Beep"); } public static void main(String\[] args){ for (int i = 0; i < 3; i++) { beep(); } } 



&#x09;Should print three beeps.



* Write a method line(int n) that prints n asterisks on one line. No return value. 



&#x09;public static void line(int n) {

&#x09;System.out.println(n);

&#x09;}



* What is wrong here? 



public class X { 

&#x09;public static void hello() { 

&#x09;	return "Hello"; 

&#x09;} 

} 



&#x09;This method is has a void return type and should not return anything, however, it is written to return the string "Hello".



* True/False: Methods can be defined inside other methods in Java. 



&#x09;False, methods are defined inside a class, not a method.



* Fill in the blanks to match Java naming conventions: methods use camelCase (e.g., calculateTax). 



* Write a short method greetUser() that prints your name on one line. 



&#x09;public static void greetUser(String name) {

&#x09;	System.out.println(name);

&#x09;}



* Why should a method “do one thing well”? 

&#x09;It's easier to maintain and test and call if the method has one specific functionality

