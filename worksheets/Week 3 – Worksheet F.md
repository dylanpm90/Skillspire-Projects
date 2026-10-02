**Week 3 – Worksheet F: Array Manipulation with Methods** 



&#x20;   Write printArray(int\[] arr) that prints elements on one line separated by spaces. 







&#x20;   Write sum(int\[] arr) that returns the total of all elements. 







&#x20;   Write max(int\[] arr) that returns the largest value (assume length ≥ 1). 







&#x20;   What will this print? 



int\[] a = {5, 3, 9, 1}; System.out.println(max(a)); 







&#x20;   Write contains(int\[] arr, int target) returning true/false. 







&#x20;   Write reverse(int\[] arr) that reverses in place. 







&#x20;   Fill in bubble sort inner condition and swap: 



for (int i = 0; i < arr.length - 1; i++) { for (int j = 0; j < arr.length - i - 1; j++) { if ( \_\_\_\_\_\_ ) { // swap arr\[j], arr\[j+1] } } } 







&#x20;   Sort using utilities: 



int\[] a = {9,4,7,1}; \_\_\_\_\_\_\_\_\_\_.sort(a); 







&#x20;   Write average(int\[] arr) returning a double. 







&#x20;   Write findIndex(int\[] arr, int target) returning index or -1. 







&#x20;   Write copy(int\[] src) that returns a new array with the same elements. 







&#x20;   Fill in to return both sum and product: 



public static int\[] calc(int a, int b){ return new int\[]{ \_\_\_\_\_\_ , \_\_\_\_\_\_ }; } 







&#x20;   Write countEvens(int\[] arr) that returns how many even numbers are in the array. 







&#x20;   Given int\[]\[] m = {{1,2,3},{4,5,6}}; write sumMatrix(int\[]\[] m). 







&#x20;   What will this print? 



int\[]\[] m = {{1,2},{3,4}}; System.out.println(m\[1]\[0]); 







&#x20;   Write merge(int\[] a, int\[] b) returning a new array with all elements of a then b. 







&#x20;   Write minMax(int\[] arr) that returns a two-element array {min, max}. 







&#x20;   Write dedupe(int\[] arr) that returns a new array with duplicates removed (high-level/pseudocode OK). 







&#x20;   Why should you validate inputs like null or empty arrays at the top of methods? 







&#x20;   Add a guard clause: 



public static double avg(int\[] a){ // if a is null or length == 0, throw IllegalArgumentException // else compute average } 







&#x20;   When is it better to return a new array vs. mutate the existing array? One example. 







&#x20;   Provide one real-world example of using arrays + methods (banking, e-commerce, education, etc.). 







&#x20;   Explain, in one sentence each, what these do: Arrays.sort, Arrays.copyOf, Arrays.equals. 







&#x20;   Write toString(int\[] arr) that returns a comma-separated string (no Arrays.toString). 







&#x20;   What’s the big-picture benefit of using methods to manipulate arrays rather than writing loops inline everywhere? 







