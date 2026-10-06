import java.util.*;

public class PracticeExercises {
    //    Part 11: Practice Exercises
//    Print a 10×10 multiplication table using nested loops.
    static void main(String[] args) {
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                System.out.print(i * j + " ");
//            }
//            System.out.println();
//        }


//    Write a program that prints a pyramid pattern of *.
        // pyramid-ish
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

//          Implement a program that checks if a 2D array is symmetric.

            // Taking input from the user
            Scanner sc = new Scanner(System.in);

            // Declaring variables and setting flag to 1
            int i, j, row, col, flag = 1;

            // Taking input from the user
            System.out.print("Enter the number of rows:");
            row = sc.nextInt();

            // Display message
            System.out.print("Enter the number of columns:");

            // Reading matrix elements individually using
            // nextInt() method
            col = sc.nextInt();

            // Declaring a 2D array(matrix)
            int[][] mat = new int[row][col];


            // Display message
            System.out.println("Enter the matrix elements:");

            // Nested for loop for traversing matrix
            // Outer loop for rows
            for (i = 0; i < row; i++) {

                // Inner loop for columns
                for (j = 0; j < col; j++) {

                    // Print matrix element
                    System.out.println("Row: " + i + ", Col: " + j + ".");
                    mat[i][j] = sc.nextInt();
                }
            }

            // calling function made above to check
            // whether matrix is symmetric or not
            SymmetryChecker.checkSymmetric(mat, row, col);
        }


//      Use nested loops to generate a checkerboard pattern (X O X O).
//        int num = 10;       // length of line.
//
//        for (int i = 1; i <= num; i++) {
//            if (i % 2 != 0) {   // odd lines have an X first
//                for (int j = 1; j <= num; j++) {
//                    if (j % 2 != 0) {
//                        System.out.print("X ");
//                    } else {
//                        System.out.print("O ");
//                    }
//                }
//            } else {            // even lines have an O first
//                for (int j = 1; j <= num; j++) {
//                    if (j % 2 != 0) {
//                        System.out.print("O ");
//                    } else {
//                        System.out.print("X ");
//                    }
//                }
//            }
//            System.out.println();
//        }

//      Create a seat reservation system for a cinema hall (10×10).


//      Perform matrix addition and multiplication with nested loops.


//      Print all possible pairs of numbers between 1 and 5.




    }

