**Week 3 – Worksheet B: Parameters \& Return Values**



* Define “parameter” vs “argument” in one line each.



&#x09;Parameter is the placeholder, the argument replaces the parameter when the method is called.



* Label the parameter and argument:



public static void greet(String name) { ... } greet("Alice");



&#x09;String name is the parameter, Alice is the argument.



* Write a method add(int a, int b) that returns the sum.



&#x09;public static int add(int a, int b) {

&#x09;	return a + b;

}



* What will this print?



public static int add(int a, int b){ return a + b; } public static void main(String\[] args){ System.out.println(add(10, 20)); }



&#x09;This should return 30.



* What keyword is required to send a value back from a method?



&#x09;The keyword return should be used to return a value from a method.



* Complete the return statement:



public static double half(int x){ return x / 2.0; }



* Java does not support default parameter values. What common technique is used instead?



&#x09;Method overloading is used instead of parameter values.



* Overload greet() so that one version takes no parameters and prints “Hello, Guest” and another takes a String name.



&#x09;public static void greet(){ System.out.println("Hello, Guest"); }

&#x09;public static void greet(String name){ System.out.println("Hello, " + name); }



&#x20;   Primitive parameters are passed by copy value in Java (copy value or copy reference?).



* What will this print?



public static void inc(int x){

&#x09;x = x + 1;

&#x09;System.out.println("Inside: " + x);

}

public static void main(String\[] args){

&#x20;	int n = 5;

&#x09;inc(n);

&#x09;System.out.println("Outside: " + n);

}



&#x09;Inside: 6

&#x09;Outside: 5



&#x20;   Objects are passed by copying the reference (value or reference?).



* What will this print?



public static void tag(StringBuilder s){

&#x09;s.append("!");

}

public static void main(String\[] args){

&#x09;StringBuilder sb = new StringBuilder("Hi");

&#x09;tag(sb);

&#x09;System.out.println(sb);

}



&#x09;This should print "Hi!".



* Write divide(int a, int b) that returns a double and returns 0.0 if b == 0.



&#x09;public static double divide(int a, int b) {

&#x09;	if (b == 0) {

&#x09;		return 0.0

&#x09;	}

&#x09;	return (double) a / b;

&#x09;}

* Convert this to a method that returns a String instead of printing:



System.out.println("Welcome " + name);



&#x09;public static String greet(String name){ return "Hello, " + name; }



* What is wrong?



public static int getName(){ return "Alice"; }



&#x09;The computer expects an integer but a String is returned.



* Fill in a method that returns both sum and product using an int\[]:



public static int\[] calc(int a, int b){ // return new int\[]{sum, product}; }



&#x09;public static int\[] calc(int a, int b) {

&#x09;	int sum = a + b;

&#x09;	int product = a \* b;

&#x09;	return new int\[]{sum, product};

&#x09;}



* Write grade(int score) that returns "A", "B", "C", or "F".



&#x09;public static String grade(int score) {

&#x09;	if (score >= 90) {

&#x09;		return "A";

&#x09;	} else if (score >= 80) {

&#x09;		return "B";

&#x09;	} else if (score >= 70) {

&#x09;		return "C";

&#x09;	} else if (score >= 60) {

&#x09;		return "F";

&#x09;	} else {

&#x09;		return "Not applicable";

&#x09;	}

&#x09;}



* Change this method to return a boolean value instead of printing:



public static boolean isEven(int n){

&#x09;if(n % 2 == 0){

&#x09;	return true;

&#x09;} else {

&#x09;	return false;

&#x09;}

&#x09;



* What is “unreachable code after return”? Give a 1-line example.



&#x09;If a method is exited before a line of code is executed, it is unreachable code.



* Complete the method header for a method that returns a Student and takes String name, int age.



&#x09;public static Student studentInformation(String name, int age) {// code block}



* What does Optional<String> represent in Java? One sentence.



&#x09;It is a placeholder in the circumstance that there might not be a String value.



* Method overloading: write two sum methods—one for int, int and one for double, double.



&#x09;public static int add(int a, int b){

&#x09;	return a + b;

&#x09;}



&#x09;public static double add(double a, double b){

&#x09;	return a + b;

&#x09;}



* Why is it generally better to return values than to System.out.println inside business logic?



&#x09;The value can be stored and used in other situations when returned from a method.



* Write max(int\[] a) that returns the largest element (assume length ≥ 1).

&#x09;

&#x09;public static int max(int\[] a) {

&#x09;	int max a = \[0];

&#x09;	for (int n : a) {

&#x09;		if (n > max) {

&#x09;			max = n;

&#x09;		}

&#x09;	return max;

&#x09;	}

&#x09;

&#x09;}



* What happens if a non-void method reaches its end without a return statement?



&#x09;It will send a compiler error. Non-void methods must return a value.

