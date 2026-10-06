
public static void main(String[] args) {
    // nested loop

    for (int i = 1; i <= 3; i++) { // outer loop controls the "rows"
        for (int j = 1; j <= 3; j++) { // inner loop controls the "columns"
            System.out.print(i * j + " ");
        }
        System.out.println();
        /*  output:
            1 2 3 // this is printed first - three interations. New line is printed in the outer loop.
            2 4 6 // i = 2, and j is multiplied against i three times.
            3 6 9 // i = 3, i * j
        */
    }
}


