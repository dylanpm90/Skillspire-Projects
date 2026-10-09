Week 4 Worksheet: The Importance of OOP 



* &#x20;   In one sentence: What is OOP? 



&#x09;Object-Orient Programming is a programming paradigm designed to model virtual entities as objects in physical reality.



* &#x20;   Match term → definition: 



Encapsulation - Encapsulation hides internal details and exposes only safe methods. 



Inheritance - Inheritance lets us create new classes from existing ones.

&#x20;

Polymorphism - Polymorphism allows flexibility and reduces duplication.

&#x20;

Abstraction - Abstraction hides complexity and provides simple interfaces.







* &#x20;   What benefit does encapsulation provide for security/maintenance? 



It enhances the security of the information by implementing access control.





* &#x20;   Identify the pillar illustrated: 



class Animal { 

&#x09;void sound(){ 

&#x09;	System.out.println("Some"); 

&#x09;} 

} 



class Dog extends Animal { 

&#x09;void sound(){ 

&#x09;	System.out.println("Bark"); 

&#x09;} 

} 



This demonstrates inheritance. Dog is a child class of the Animal class.





* &#x20;   What will this print and which pillar? 



Animal a = new Dog(); 



a.sound(); 



This demonstrates Polymorphism.





* &#x20;   Fill in: OOP models real systems using **OBJECTS** and **CLASSES**.







* &#x20;   Give one reason large systems benefit from OOP. 



OOP is beneficial because it is reusable, maintainable, scalable, encourages team collaboration, has security fields and access control, and has intuitive real-world modelling.





* &#x20;   ~~True~~/**False**: Static methods are the core of OOP. 



Static methods belong to the class, not objects; they’re more procedural.







* &#x20;   Why is composition often preferred over deep inheritance? (1 line) 



Deep inheritance is considered more inflexible than a composition scheme.





* &#x20;   What is a “God class,” and why avoid it? 



It's a class that has too many methods and purposes, like it's supposed to take care of anything. 





* &#x20;   Choose the best practice for class design (one): 

&#x20;   ~~a) Many responsibilities per class~~ 

&#x20;   **b) Single, focused responsibility** 







* &#x20;   Match pillar → one-sentence example in banking. 







* &#x20;   Briefly define the “S” in SOLID and give a tiny example name. 







* &#x20;   What is abstraction aiming to hide? 







* &#x20;   Which approach promotes reuse more naturally in OOP: classes or global helpers? Why? 







* &#x20;   Identify pillar: 



interface Payment { 

&#x09;void process(); 

} 



class CreditCard implements Payment { 

&#x09;public void process(){ 

&#x09;	System.out.println("CC"); 

&#x09;} 

} 



class Paypal implements Payment { 

&#x09;public void process(){ 

&#x09;	System.out.println("PP"); 

&#x09;} 

} 







* &#x20;   Fill in: Polymorphism allows the same interface to have \_\_\_\_\_\_ implementations. 







* &#x20;   Name one common OOP design pattern and its purpose (1 line). 







* &#x20;   Why does OOP help teams collaborate? 







* &#x20;   True/False: OOP guarantees simplicity for tiny scripts. 







* &#x20;   Which is more OOP: returning a Receipt object or printing text inside a calculator method? Why? 







* &#x20;   Briefly contrast OOP vs procedural for maintenance. 







* &#x20;   What is the danger of exposing fields as public in large systems? 







* &#x20;   Give a real-world domain and list 3 classes you’d model. 







* &#x20;   Short answer: How does OOP reduce bugs over time? 











