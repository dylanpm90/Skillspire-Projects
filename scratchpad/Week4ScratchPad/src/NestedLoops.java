public class NestedLoops {
    public static void main() {
        // nested loop
        System.out.println("1. Multiplication table");
//    for (int i = 1; i <= 3; i++) { // outer loop controls the "rows"
//        for (int j = 1; j <= 3; j++) { // inner loop controls the "columns"
//            System.out.print(i * j + " ");
//        }
//        System.out.println();
//        /*  output:
//            1 2 3 // this is printed first - three interations. New line is printed in the outer loop.
//            2 4 6 // i = 2, and j is multiplied against i three times.
//            3 6 9 // i = 3, i * j
//        */
//    }


        // while nested loop
        System.out.println("2. While loop");
//    int i = 1;
//    while (i <= 3) {
//        int j = 1;
//        while (j <= 3) {
//            System.out.print(i + "," + j + " ");
//            j++;
//        }
//        System.out.println();
//        i++;
//        /*    output
//            1,1 1,2 1,3
//            2,1 2,2 2,3
//            3,1 3,2 3,3
//
//        */
//    }


        //Nested Loop with Arrays
        System.out.println("3. Nested Loop with Arrays");
//    int[][] matrix = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//    };
//
//    for (int i = 0; i < matrix.length; i++) {
//        for (int j = 0; j < matrix[i].length; j++) {
//            System.out.print(matrix[i][j] + " ");
//        }
//        System.out.println();
//    }


        System.out.println("4. right triangle");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) { // the bigger the value of i gets, the more asterisks
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("5. inverted triangle");
        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= i; j++) { // the smaller the value of i gets, the fewer asterisks
                System.out.print("* ");
            }
            System.out.println();
        }

    }


}
