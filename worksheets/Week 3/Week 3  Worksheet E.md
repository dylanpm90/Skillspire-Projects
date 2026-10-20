Week 3 – Worksheet E: Arrays (Declaring, Initializing, Accessing)



What is an array? One sentence.

An array is a collection of elements of the same type, stored in contiguous memory locations, and accessed using an index.





Write the preferred declaration for an array of int.

int\[]





Declare and initialize an array of three Strings: "A", "B", "C".

String\[] arr = {"A", "B", "C"};





What is the index of the first element in a Java array?

0





How do you get the length of array arr?

arr\[arr.length-1]





What will this print?

&#x20;

int\[] a = {10, 20, 30};

System.out.println(a\[1]);



20



Fill in to create an array of size 5:



int\[] scores = new int\[ 1, 2, 3, 4, 5 ];







After new int\[4], what are the default values of the elements?



If I'm understanding the question correctly, the default int value should be 0.





What exception occurs when accessing arr\[arr.length]?

ArrayIndexOutOfBoundsException 





Initialize a 2D array int\[2]\[3] with any values and print the element at row 1, col 2.



public static void main(String\[] args) {

&#x20;       int\[]\[] arr = {

&#x20;               {1, 2, 3, 4},

&#x20;               {5, 6, 7, 8}

&#x20;       };



&#x20;       System.out.println(arr\[1]\[2]);



}





Fill in the for-loop to print all elements of nums:

for (int i = 0; i < num; i++) {

&#x09;System.out.println(nums\[i]);

}







Write an enhanced for-each loop to print all elements of String\[] names.



&#x20;       String\[] cars = {"Volvo", "BMW", "Ford", "Mazda"};



&#x20;       for (String car : cars) {

&#x20;           System.out.println(car);

&#x20;       }









Difference between declaration and initialization (one line each).



&#x09;A declaration tells us the type of variable being introduced. 

&#x09;Initialization provides an initial value for the variable.



Create an int\[] grades with values {85, 92, 78, 90} and print the average (integer division acceptable).

&#x20;   

public static void main(String\[] args) {

&#x20;       int\[] grades = {85, 92, 78, 90};

&#x20;       int sum = 0;

&#x20;       for (int num : grades) {

&#x20;           sum += num;

&#x20;       }

&#x20;       int average = sum / grades.length;

&#x20;       System.out.println("# of grades: " + grades.length);

&#x20;       System.out.println("Average: " + average);

&#x20;   }



What will this print?



String\[] s = new String\[2];

System.out.println(s\[1]);



null



Why is type\[] name preferred over type name\[] in professional code?

&#x20;

Both are valid, but the first style is preferred in professional coding because it clearly associates the brackets with the type.





Fill: Arrays are of FIXED size after creation (fixed/dynamic).







Create a 2D array for tic-tac-toe and print the center cell.



char\[]\[] board = {

&#x20;               {'X', 'O', 'X'},

&#x20;               {' ', 'X', ' '},

&#x20;               {'X', 'O', 'O'}

&#x20;       };

&#x20;       System.out.println(board\[1]\[1]);



Which utility method prints arrays as a string: Arrays.\_\_\_\_\_\_\_\_?



Arrays.toString(arr)







Convert this array to an ArrayList<Integer> (pseudocode acceptable):



&#x09;// Initialize an int array

&#x20;       int\[] a = {1,2,3,4};



&#x20;       // Create an empty ArrayList

&#x20;       List<Integer> integerList = new ArrayList<>();



&#x20;       // Loop through the int array and add elements to the ArrayList

&#x20;       for (int num : a) {

&#x20;           integerList.add(num);

&#x20;       }



&#x20;       // Print the ArrayList

&#x20;       System.out.println(integerList); 







When should you consider ArrayList over arrays? One reason.



Array lists have dynamic sizes and arrays are fixed.





Write a loop to copy int\[] src into int\[] dest (assume same length).



&#x20;       int\[] a = {1, 8, 3};



&#x20;       // Create a new array of the same size

&#x20;       int\[] b = new int\[a.length];



&#x20;       // Copy elements from a\[] to b\[]

&#x20;       for (int i = 0; i < a.length; i++) {

&#x20;           b\[i] = a\[i];

&#x20;       }





&#x20;       System.out.println("Original Array: " + Arrays.toString(a));

&#x20;       System.out.println("Copied Array: " + Arrays.toString(b));







What’s wrong?



int\[] x; x\[0] = 10;



The array is declared incorrectly.



What is the default value for boolean\[] flags = new boolean\[3];?



The default boolean value is false.



Why is zero-based indexing important to remember in loops?



So you don't get the Array out of bounds exception and keep track of your values.





