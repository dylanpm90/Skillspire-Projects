Week 4 Worksheet: Scope in Java 



* &#x20;   In one sentence, define “scope.” 







* &#x20;   True/False: A variable declared inside a method is accessible outside that method. 







* &#x20;   What’s wrong here? 







public static void main(String\[] args){ int x = 10; } System.out.println(x); 







* &#x20;   Fill in: Variables declared inside { } have \_\_\_\_\_\_ scope. 







* &#x20;   Mark which has local scope: 

&#x20;   a) method parameter b) class field c) static field 







* &#x20;   What will this print and why? 



int x = 5; if (x > 0) { int y = 10; System.out.println(x + y); } // System.out.println(y); 







* &#x20;   True/False: Loop variables declared in a for header are visible after the loop ends. 







* &#x20;   Fix the error by moving/declaring appropriately: 



for (int i = 0; i < 3; i++) {} System.out.println(i); 







* &#x20;   Fill in the blanks: 

Instance scope belongs to the \_\_\_\_\_\_. 

Class (static) scope belongs to the \_\_\_\_\_\_. 







* &#x20;   What is the lifetime of a local variable? 







* &#x20;   What is the lifetime of a static field? 







* &#x20;   Identify the shadowing and fix with this: 



class Student { String name = "Default"; void setName(String name) { name = name; // fix } } 







* &#x20;   What error occurs if you use an uninitialized local variable? 







* &#x20;   Why is keeping the “smallest possible scope” a best practice? 







* &#x20;   Which line is illegal and why? 



if (true) { int z = 7; } int z = z + 1; 







* &#x20;   True/False: Method parameters are accessible from other methods in the same class. 







* &#x20;   Convert this to avoid shadowing without renaming the parameter: 



class Box { int size; void setSize(int size) { /\* set field \*/ } } 







* &#x20;   Which has wider visibility: private field or public field? 







* &#x20;   Choose the correct line to access an instance field count: 

&#x20;   a) count 

&#x20;   b) ClassName.count 

&#x20;   c) this.count (inside instance method) 







* &#x20;   What will this print? 



class C { static int s = 1; int i = 2; static void f(){ /\* can we use i here? \*/ } } 







* &#x20;   Why can’t a static method directly access instance fields? 







* &#x20;   Where is temp visible? 



for (int k = 0; k < 2; k++) { int temp = 100; } // here? 







* &#x20;   Complete to demonstrate block scope in a loop that prints 0,1,2. 







* &#x20;   Give one real example where narrowing scope reduces bugs. 







* &#x20;   Briefly explain “variable shadowing.” 







