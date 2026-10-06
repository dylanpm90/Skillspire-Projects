Week 4 Worksheet: Scope in Java



* &#x20;   In one sentence, define “scope.”



Scope defines where a variable or method can be used.





* &#x20;   ~~True~~/**False**: A variable declared inside a method is accessible outside that method.



Variables declared inside a method or inside a block { } exist only there.





* &#x20;   What’s wrong here?



public static void main(String\[] args){

&#x09;int x = 10;

}

System.out.println(x);



x is being referenced outside the scope of the method in which it was declared.



* &#x20;   Fill in: Variables declared inside { } have **LOCAL** scope.







* &#x20;   Mark which has local scope:

&#x20;   **a) method parameter** ~~b) class field c) static field~~







* &#x20;   What will this print and why?



int x = 5; 

if (x > 0) { 

&#x09;int y = 10; 

&#x09;System.out.println(x + y); 

} 

// System.out.println(y);



It will print 15. Attempting to print the last line will cause an error.



* &#x20;   True/False: Loop variables declared in a for header are visible after the loop ends.



False.





* &#x20;   Fix the error by moving/declaring appropriately:



for (int i = 0; i < 3; i++) {

&#x09;**System.out.println(i);**

} 





* &#x20;   Fill in the blanks:

Instance scope belongs to the **OBJECT**.

Class (static) scope belongs to the **CLASS**.







* &#x20;   What is the lifetime of a local variable?



Local variables → created when method runs, destroyed when method ends.





* &#x20;   What is the lifetime of a static field?



Static variables → exist as long as the program runs. 





* &#x20;   ~~Identify the shadowing and fix with this:~~



class Student { 

&#x09;String name = "Default"; 

&#x09;void setName(String name) { 

&#x09;	**this.**name = name;	

&#x09;} 

}







* &#x20;   What error occurs if you use an uninitialized local variable?



java: variable x might not have been initialized





* &#x20;   Why is keeping the “smallest possible scope” a best practice?



It helps with maintenance if there isn't a cumbersome and confusing amount of global scope variables.





* &#x20;   Which line is illegal and why?



if (true) { 

&#x09;**int z = 7;** 

} 

int z = z + 1;



int z belongs to the if statement, not outside the scope of that if statement.







* &#x20;   ~~True~~/**False**: Method parameters are accessible from other methods in the same class.



Method parameters only belong to their particular method.





* &#x20;   Convert this to avoid shadowing without renaming the parameter:



class Box { int size; void setSize(int size) { /\* set field \*/ } }







* &#x20;   Which has wider visibility: private field or public field?



Public







* &#x20;   Choose the correct line to access an instance field count:

&#x20;   ~~a) count~~

&#x20;   **b) ClassName.count**

&#x20;   ~~c) this.count (inside instance method)~~







* &#x20;   What will this print?



class C { 

&#x09;static int s = 1; int i = 2; 

&#x09;static void f(){ 

&#x09;/\* can we use i here? \*/ 

&#x09;} 

}



It won't print anything, but i can be referenced here.





* &#x20;   Why can’t a static method directly access instance fields?



Instance fields require the instance object to be created.







* &#x20;   Where is temp visible?



for (int k = 0; k < 2; k++) { 

&#x09;int temp = 100; 

} // here?



temp is only visible within the for loop



* &#x20;   Complete to demonstrate block scope in a loop that prints 0,1,2.



for (int i = 0; i < 3; i++){

&#x09;System.out.print(i + ",");

}







* &#x20;   Give one real example where narrowing scope reduces bugs.



Narrowing the scope of discounts for a particular vendor, so that it doesn't bleed over into other vendors, who may not be running the discount.





* &#x20;   Briefly explain “variable shadowing.”



Variable shadowing happens when a local variable has the same name as an instance variable.









