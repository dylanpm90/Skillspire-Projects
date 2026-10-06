Week 2 Worksheet: Clean Code Best Practices in Java



* &#x20;   	Why does clean code matter in professional software development?

&#x09;	

&#x09;	Clean code is more readable to other developers, more maintainable and more scalable.		



* &#x20;   	What is the golden rule of naming conventions in Java?



&#x09;	Names should reveal intent.	



* &#x20;   	Which of the following is a better variable name and why: x or studentAge?



&#x09;	studentAge, because it reveals intent and describes the data. 'x' is vague.



* &#x20;   	Rewrite this messy code with better variable names:



&#x09;	int distanceToDestinationA = 5; 

&#x09;	int distanceToDestinationB = 10; 

&#x09;	int sumOfDistances = distanceToDestinationA + distanceToDestinationB; 			System.out.println(sumOfDistances);



* &#x20;   	What is the recommended indentation size in Java?



&#x09;	The convention in Java is to use 4 spaces for indentation.		



* &#x20;   	Reformat the following code to follow clean formatting standards:



&#x09;	if (age >= 18) {

&#x09;	    System.out.println("Eligible");

&#x09;	} else {

&#x09;	    System.out.println("Not eligible");

&#x09;	}



* &#x20;   	What should comments explain in code — the “what” or the “why”?



&#x09;	Comments in code should explain "why".



* &#x20;   	Write a JavaDoc comment for a method that calculates the area of a rectangle.



&#x09;	/\*\*

&#x09;	    \* Calculates the area of a rectangle.

&#x09;	    \* @param length, the length of the rectangle

&#x09;	    \* @param width, the width of a rectangle

&#x09;	    \* @return area of a rectangle

&#x09;	\*/



* &#x20;   	Why should methods be kept small and focused?



&#x09;	It would be burdensome to call methods like that, it would be better to just call small, focused methods.



* &#x20;   	What does the DRY principle stand for?



&#x09;	DRY means "don't repeat yourself".



* &#x20;   	What does the KISS principle stand for?



&#x09;	KISS means "Keep it simple, stupid."



* &#x20;   	Rewrite this messy code into a clean version:



&#x09;	if (user.equals("admin") \&\& password.equals("1234")) { 

&#x09;	    System.out.println("Access Granted"); 

&#x09;	} else { 

&#x09;	    System.out.println("Access Denied"); 

&#x09;	}



* &#x20;   	What is the Single Responsibility Principle (SRP) in your own words?



&#x09;	One method, one purpose.



* &#x20;   	In clean code, should classes depend on abstractions or concrete classes?



&#x09;	It should depend on abstractions.



* &#x20;   	What exception will occur if you divide a number by zero in Java?



&#x09;	An "ArithmeticException" occurs when trying to divide by zero.



* &#x20;   	Rewrite this code to handle division errors gracefully using try/catch:



&#x09;	try {

&#x09;	    int result = a / b;

&#x09;	} catch (ArithmetciException e) {

&#x09;	    System.out.println("Cannot divide by zero.");

&#x09;	}



* &#x20;   	What is wrong with the following class name? Suggest a better one:



&#x09;public class MyClass { }

&#x09;

&#x09;	The class name "MyClass" is nondescript and could have a name which details intent.



&#x09;public class DogBreed { }

&#x09;	

&#x09;	"DogBreed" describes the intent of the class.



* &#x20;   	Write a class Book with variables title, author, and price. Include getter and setter methods using clean code best practices.



&#x09;	see attachments



* &#x20;   	Refactor this messy code into clean code:



&#x09;	public class chemicalThresholdAllowance {

&#x20;		    int threshold; 

&#x09;	    void m(int volumeChemicalA, int volumeChemicalB) {

&#x09;	        threshold = volumeChemicalA + volumeChemicalB; 

&#x09;	        if (threshold > 10) { 

&#x09;	            System.out.println("ok"); 

&#x09;	        } else { 

&#x09;	            System.out.println("no"); 

&#x09;		} 

&#x09;	    } 

&#x09;	}



* &#x20; 	Why is code said to be “read 10x more often than it is written”?



&#x09;	Other developers read and analyze code, so more eyes are going to be on the code before alterations or additional code is written.



* &#x20;   	Which naming style is preferred in Java: camelCase or snake\_case?



&#x09;	camelCase is used in Java.



* &#x20;   	What is a common mistake beginners make with comments?



&#x09;	Code with very clear intent can be over explained and redundant by beginner comments.



* &#x20;   	What is the main benefit of meaningful names in methods and variables?



&#x09;	It details intent with the method and variable names, making it easier to track and parse the intent of the code.



* &#x20;   	Write a program to calculate the average of three numbers using clean code best practices.



&#x09;	int sampleFirstNumber = 1;

&#x09;	int sampleSecondNumber = 2;

&#x09;	int sampleThirdNumber = 3;



&#x09;	int divisorNumber = 3;



&#x09;	int sumOfSampleNumbers = sampleFirstNumber + sampleSecondNumber + sampleThirdNumber;

&#x09;	int average = sumOfSampleNumbers / divisorNumber;

&#x09;	System.out.println("Average: " + average + ".");

&#x09;	



* &#x20;   	Why is clean code considered a career skill and not just an academic skill?



&#x09;	Writing clean code is good practice in professional settings and invites collaboration and demonstrates experience and knowledge.







