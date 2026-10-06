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

//      Implement a program that checks if a 2D array is symmetric.
//      See SymmetryChecker.java


//      Use nested loops to generate a checkerboard pattern (X O X O).
        int num = 10;       // length of line.

        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {   // odd lines have an X first
                for (int j = 1; j <= num; j++) {
                    if (j % 2 != 0) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
            } else {            // even lines have an O first
                for (int j = 1; j <= num; j++) {
                    if (j % 2 != 0) {
                        System.out.print("O ");
                    } else {
                        System.out.print("X ");
                    }
                }
            }
            System.out.println();
        }

//      Create a seat reservation system for a cinema hall (10×10).


//      Perform matrix addition and multiplication with nested loops.


//      Print all possible pairs of numbers between 1 and 5.




    }
}
