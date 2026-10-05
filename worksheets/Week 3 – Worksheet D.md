Week 3 – Worksheet D: Loops in Java



* What are the three parts of a for loop header (in order)?



&#x09;Initialization, Condition, and Iteration.



* Write a for loop that prints numbers 1 to 5 inclusive.



&#x09;for (int i = 1; i <= 5; i++) {

&#x09;	System.out.println("Count: " + i);

&#x09;}



* Convert this for loop to a while loop:



for (int i = 0; i < 3; i++) {

&#x09;System.out.println(i);

}





int i = 0;

while (	i < 3 ){

&#x09;System.out.println("Count: " + i);

&#x09;i++;

}



* What type of loop guarantees the body runs at least once?



Do while loops run at least once.



* Fill in:



int i = 1;

do {

&#x09;System.out.println(i);

&#x09;i++;

&#x09;}

while ( i <= 5 );



* Write an enhanced for-each loop to print all elements of int\[] a.



&#x09;int\[] a = {10, 20, 30};

&#x09;for (int num : a) {

&#x09;	System.out.println(num);

&#x09;}



* What will this print?



for (int i = 2; i <= 8; i += 2) {

&#x09;System.out.print(i + " ");

}



It should print out:

2 4 6 8



* What is an “off-by-one” error? One sentence.



It's when the code doesn't account for the array length by one.



* Add a break to stop when i == 5:



for (int i = 1; i <= 10; i++) {

&#x09;if (i == 5) break;

&#x09;System.out.println(i);

}



&#x09;



* What does continue do in a loop?



&#x09;It skips the current iteration.



* Print all odd numbers from 1 to 9 using a loop.



&#x09;for (int i = 1; i <= 9; i++){

&#x09;	if (i % 2 == 0) {

&#x09;		continue;

&#x09;	} else {

&#x09;		System.out.println(i + " ");

&#x09;	}

&#x09;}



* What is wrong here?



while (true) {

&#x09;System.out.println("Go");

}



It's an infinite loop.



* Write a loop that sums the numbers in int\[] nums into total.

&#x09;

&#x09;int\[] nums = {1, 2, 3};

&#x09;int total = 0;

&#x09;for (int i : nums) {

&#x09;	total += i;

&#x09;}



* Turn this nested loop into formatted output of a 3×3 multiplication table:



&#x09;for (int i = 1; i <= 3; i++) {

&#x20;           for (int j = 1; j <= 3; j++) {

&#x20;               System.out.print(i \* j + " ");

&#x20;           }

&#x20;           System.out.println();

&#x20;       }

&#x09;



* Which loop is best when you don’t know the number of iterations ahead of time?



&#x09;A while loop.



* Which loop is best for iterating arrays when you don’t need the index?



&#x09;Enhanced For loop.



* Write a loop to find whether target exists in int\[] a. Print “Found” or “Not Found”.



&#x20;   public static void main(String\[] args) {

&#x20;       int\[] arr = {10, 9, 20};

&#x20;       int target = 15;

&#x20;       boolean found = false;

&#x20;       for (int num : arr) {

&#x20;           if (num == target) {

&#x20;               found = true;

&#x20;               break;

&#x20;           }

&#x20;       }



&#x20;       if (found) {

&#x20;           System.out.println("Found");

&#x20;       } else {

&#x20;           System.out.println("Not found");

&#x20;       }



&#x20;   }



* Convert this infinite while into a finite loop that runs 5 times:



int i = 1;

while (i <= 5) {

&#x09;i++;

&#x09;System.out.println("Hello");

}



&#x09;



* What will this print?



for (int i = 1; i <= 5; i++) {

&#x09;if (i == 3) continue;

&#x09;System.out.print(i + " ");

}



1 2 4 5



* Why should extremely deep nested loops be avoided?



&#x09;They decrease readability and can be inefficient.



* Write a loop to reverse-print an array int\[] a from last to first index.



public static void reverse(int\[] arr) { 

&#x20;   int start = 0, end = arr.length - 1; 

&#x20;   while (start < end) { 

&#x20;       int temp = arr\[start]; 

&#x20;       arr\[start] = arr\[end]; 

&#x20;       arr\[end] = temp; 

&#x20;       start++; 

&#x20;       end--; 

&#x20;   } 

} 





* Fill in the blanks: Initialization → Condition → Iteration.



&#x09;



* Create a loop to compute factorial of n = 5.



&#x09;int n = 5; 

int fact = 1; 

for (int i = 1; i <= n; i++) { 

&#x20;   fact \*= i; 

}



* Write a while loop that keeps asking for input until the user enters 0 (pseudocode acceptable).



Scanner scanner = new Scanner(System.in);



int targetNumber = 0;



int userNumber = scanner.nextLine;



while the userNumber != target number prompt user for new number.



if userNumber == target number, break.	



* One sentence: how do loops + arrays + methods work together in real programs?



The take information, like items and balance numbers and stats, and perform computations and store and return the adjusted values to the user.	

