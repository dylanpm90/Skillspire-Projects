**Week 3 – Worksheet F: Array Manipulation with Methods**



&#x20;   Write printArray(int\[] arr) that prints elements on one line separated by spaces.

public static void printArray(int\[] arr) { 

&#x20;       for (int num : arr) { 

&#x20;           System.out.print(num + " "); 

&#x20;       } 

&#x20;       System.out.println(); 

}





&#x20;   Write sum(int\[] arr) that returns the total of all elements.



public static int sumArray(int\[] arr) { 

&#x20;   int sum = 0; 

&#x20;   for (int num : arr) { 

&#x20;       sum += num; 

&#x20;   } 

&#x20;   return sum; 

}



&#x20;   Write max(int\[] arr) that returns the largest value (assume length ≥ 1).



&#x20;   public static void main(String\[] args) {

&#x20;       int\[] findMaxArray = {1, 7, 2, 6};



&#x20;       int maxIntResult = max(findMaxArray);



&#x20;       System.out.println(maxIntResult);

&#x20;   }



&#x20;   public static int max(int\[] arr) {

&#x20;       int m = arr\[0];

&#x20;       for (int num : arr) {

&#x20;           if (num > m) m = num;

&#x20;       }

&#x20;       return m;

&#x20;   }







&#x20;   What will this print?



int\[] a = {5, 3, 9, 1}; System.out.println(max(a));



Technically, an error, because the method isn't recognized if I drop it into the IDE like that. Not sure if there was supposed to be some sort of imported method. If I put it into the method I made in the previous exercise, it would print 9, like below.



public static void main(String\[] args) {

&#x20;       int\[] findMaxArray = {1, 7, 2, 6};

&#x20;       int\[] a = {5, 3, 9, 1};

&#x20;       int maxIntResult = max(a);



&#x20;       System.out.println(maxIntResult);

&#x20;   }



&#x20;   public static int max(int\[] arr) {

&#x20;       int m = arr\[0];

&#x20;       for (int num : arr) {

&#x20;           if (num > m) m = num;

&#x20;       }

&#x20;       return m;

&#x20;   }







&#x20;   Write contains(int\[] arr, int target) returning true/false.



&#x20;   public static void main(String\[] args) {

&#x20;       int\[] findTargetArray = {1, 7, 2, 6};

&#x20;       int target = 7;

&#x20;       boolean targetFound = findIndex(findTargetArray, target);



&#x20;       System.out.println("Was the target, " + target + " found in the array?");

&#x20;       System.out.println("Answer: " + targetFound + ".");

&#x20;   }



&#x20;   public static boolean findIndex(int\[] arr, int target) {

&#x20;       for (int i = 0; i < arr.length; i++) {

&#x20;           if (arr\[i] == target) return true;

&#x20;       }

&#x20;       return false; // not found

&#x20;   }







&#x20;   Write reverse(int\[] arr) that reverses in place.



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







&#x20;   Fill in bubble sort inner condition and swap:



for (int i = 0; i < arr.length - 1; i++) { 

&#x09;for (int j = 0; j < arr.length - i - 1; j++) { 

&#x09;	if (arr\[j] > arr\[j + 1]) { 

&#x09;		int temp = arr\[j];

&#x20;                   	arr\[j] = arr\[j + 1];

&#x20;                   	arr\[j + 1] = temp; 

&#x09;	} 

&#x09;} 

}







&#x20;   Sort using utilities:



int\[] a = {9,4,7,1}; Arrays.sort(a);







&#x20;   Write average(int\[] arr) returning a double.



&#x20;   public static double average(int\[] grades) {

&#x20;       int total = 0;

&#x20;       for (int g : grades) {

&#x20;           total += g;

&#x20;       }

&#x20;       return (double) total / grades.length;

&#x20;   }



&#x20;   Write findIndex(int\[] arr, int target) returning index or -1.



public static int findIndex(int\[] arr, int target) { 

&#x20;   for (int i = 0; i < arr.length; i++) { 

&#x20;       if (arr\[i] == target) return i; 

&#x20;   } 

&#x20;   return -1; // not found 

}





&#x20;   Write copy(int\[] src) that returns a new array with the same elements.



import java.util.Arrays;



public class WorksheetScratch {

&#x20;   public static void main(String\[] args) {



&#x20;       int\[] src = {0, 17, 35};



&#x20;       int\[] newlyCopiedArray = copy(src);



&#x20;       System.out.println("Copied Array: " + Arrays.toString(newlyCopiedArray));



&#x20;   }



&#x20;   public static int\[] copy(int\[] copyThis) {



&#x20;       // Create a new array of the same size

&#x20;       int\[] copyOfArray = new int\[copyThis.length];



&#x20;       // Copy elements from a\[] to b\[]

&#x20;       for (int i = 0; i < copyThis.length; i++) {

&#x20;           copyOfArray\[i] = copyThis\[i];

&#x20;       }





&#x20;       System.out.println("Original Array: " + Arrays.toString(copyThis));





&#x20;       return copyOfArray;

&#x20;   }



}







&#x20;   Fill in to return both sum and product:



public class WorksheetScratch {

&#x20;   public static void main(String\[] args) {

&#x20;       int a = 1;

&#x20;       int b = 5;





&#x20;       int\[] results = calc(a, b);



&#x20;       System.out.println("results: " + Arrays.toString(results));

&#x20;   }



&#x20;   public static int\[] calc(int a, int b) {

&#x20;       int sum = a + b;

&#x20;       int product = a \* b;



&#x20;       return new int\[]{sum, product};

&#x20;   }



}







&#x20;   Write countEvens(int\[] arr) that returns how many even numbers are in the array.



public class WorksheetScratch {

&#x20;   public static void main(String\[] args) {



&#x20;       int\[] hasEvens = {0, 2, 5, 6, 7, 11}; // expect 3



&#x20;       int sumOfEvens = countEvens(hasEvens);



&#x20;       System.out.println("Sum of even numbers: " + sumOfEvens);



&#x20;   }



&#x20;   public static int countEvens(int\[] arr) {

&#x20;       int evenSum = 0;

&#x20;       for (int i = 0; i < arr.length; i++) {

&#x20;           if (arr\[i] % 2 == 0) {

&#x20;               // Calculate the even sum

&#x20;               evenSum ++;

&#x20;           }

&#x20;       }

&#x20;       return evenSum;

&#x20;   }

}







&#x20;   Given int\[]\[] m = {{1,2,3},{4,5,6}}; write sumMatrix(int\[]\[] m).



&#x20;   public static void main(String\[] args) {

&#x20;       int\[]\[] m = {{1, 2, 3}, {4, 5, 6}};



&#x20;       int sum = sumMatrix(m);



&#x20;       System.out.println("Sum of Matrix: " + sum);

&#x20;   }

&#x20;   public static int sumMatrix ( int\[]\[] matrix){

&#x20;       int sum = 0;

&#x20;       for (int\[] row : matrix) {

&#x20;           for (int num : row) {

&#x20;               sum += num;

&#x20;           }

&#x20;       }

&#x20;       return sum;

&#x20;   }







&#x20;   What will this print?



int\[]\[] m = {{1,2},{3,4}}; System.out.println(m\[1]\[0]);



1\.



&#x20;   Write merge(int\[] a, int\[] b) returning a new array with all elements of a then b.



import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



public class WorksheetScratch {

&#x20;   public static void main(String\[] args) {

&#x20;       int\[] arr1 = {10, 20, 30, 40};

&#x20;       int\[] arr2 = {50, 60, 70, 80};



&#x20;       int\[] mergedArray = merge(arr1, arr2);



&#x20;       System.out.println("results: " + Arrays.toString(mergedArray));



&#x20;   }



&#x20;   public static int\[] merge(int\[] a, int\[] b) {



&#x20;       // Create an array to store the merged result

&#x20;       int\[] result = new int\[a.length + b.length];



&#x20;       // Copy elements of arr1

&#x20;       System.arraycopy(a, 0, result, 0, a.length);



&#x20;       // Copy elements of arr2

&#x20;       System.arraycopy(b, 0, result, a.length, b.length);



&#x20;       return result;

&#x20;   }



}







&#x20;   Write minMax(int\[] arr) that returns a two-element array {min, max}.



public class WorksheetScratch {

&#x20;   public static void main(String\[] args) {

&#x20;       int\[] findMinMax = {45, 12, 98, 33, 27};



&#x20;       int\[] foundMinMax = minMax(findMinMax);





&#x20;       System.out.println("Min: " + foundMinMax\[0]);

&#x20;       System.out.println("Max: " + foundMinMax\[1]);



&#x20;   }



&#x20;   public static int\[] minMax(int\[] arr) {

&#x20;       int max = arr\[0];

&#x20;       int min = arr\[0];



&#x20;       for (int n : arr) {

&#x20;           if (n > max) {

&#x20;               max = n;

&#x20;           }

&#x20;           if (n < min) {

&#x20;               min = n;

&#x20;           }

&#x20;       }



&#x20;       int\[] minMaxArrayResults = {min, max};



&#x20;       return minMaxArrayResults;

&#x20;   }



}







&#x20;   Write dedupe(int\[] arr) that returns a new array with duplicates removed (high-level/pseudocode OK).



public static ArrayList<Integer> dedupe(int\[] arr) {



&#x20;       // Put all elements in a sorted set

&#x20;       Set<Integer> st = new TreeSet<Integer>();

&#x20;       for (int num : arr) {

&#x20;           st.add(num);

&#x20;       }



&#x20;       // Put set elements into a result ArrayList

&#x20;       ArrayList<Integer> result = new ArrayList<Integer>(st);

&#x20;       return result;

&#x20;   }



&#x20;   public static void main(String\[] args) {

&#x20;       int\[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};

&#x20;       ArrayList<Integer> uniqueArr = dedupe(arr);

&#x20;       for (int i = 0; i < uniqueArr.size(); i++) {

&#x20;           System.out.print(uniqueArr.get(i) + " ");

&#x20;       }

&#x20;   }



&#x20;   Why should you validate inputs like null or empty arrays at the top of methods?



It can help prevent errors and provide some feedback.



&#x20;   Add a guard clause:



public static double avg(int\[] a){

&#x09;if (a == null || a.length == 0) throw new IllegalArgumentException();

&#x09;// else compute average

}





public static double avg(int\[] a) {

&#x20;       if (a == null || a.length == 0) throw new IllegalArgumentException();



&#x20;       double total = 0;

&#x20;       double average;

&#x20;       for (int i : a) total += i;



&#x20;       return average = total / a.length;

&#x20;   }



&#x20;   public static void main(String\[] args) {

&#x20;       int\[] arr = {46, 76, 86};

&#x20;       double result = avg(arr);

&#x20;       System.out.println("Average: " + result);

&#x20;   }







&#x20;   When is it better to return a new array vs. mutate the existing array? One example.



It is better to return a new array when you don't have to store the existing array in memory.

For a video game character, you can create a new array for the current hp, mp and stamina when they level up.



&#x20;   Provide one real-world example of using arrays + methods (banking, e-commerce, education, etc.).



Arrays and methods affect one's bank account after transactions, debit and credit.



&#x20;   Explain, in one sentence each, what these do: Arrays.sort, Arrays.copyOf, Arrays.equals.



Arrays.sort() is used to sort arrays in ascending order.



The Arrays.copyOf() creates a new array by copying elements from an existing array, with the option to change the size of the new array.



Arrays.equals is used to check whether two arrays, whether single-dimensional or multi-dimensional array are equal or not.



&#x20;   Write toString(int\[] arr) that returns a comma-separated string (no Arrays.toString).



I don't understand the question.





&#x20;   What’s the big-picture benefit of using methods to manipulate arrays rather than writing loops inline everywhere?



It makes your code more readable and it looks cleaner and more professional.







