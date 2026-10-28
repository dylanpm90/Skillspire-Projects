package week5.lab.answers.partA;

// A2 answer. Print a 4 x 4 checkerboard with nested loops (LMS Nested Loops, Part 11, exercise 4).
// The cell is X when row + col is even, O when it is odd.
public class A2Checkerboard {
    public static void main(String[] args) {
        int size = 4;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();   // end of the row
        }
    }
}
