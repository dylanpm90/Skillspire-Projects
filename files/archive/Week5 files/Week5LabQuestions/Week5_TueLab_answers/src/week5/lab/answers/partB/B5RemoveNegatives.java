package week5.lab.answers.partB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// B5 answer. Remove every negative number while looping. Use the Iterator's own remove().
public class B5RemoveNegatives {
    public static void main(String[] args) {
        ArrayList<Integer> readings = new ArrayList<>(List.of(12, -3, 7, -1, -8, 20));

        Iterator<Integer> it = readings.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) {
                it.remove();        // safe: the iterator knows an element is gone
            }
        }
        System.out.println(readings);

        // The wrong way: calling the list's own remove() inside a for-each loop.
        // Uncomment it to see java.util.ConcurrentModificationException.
        // (It uses a new list, again, because readings has no negatives left to remove.)
        // With int r instead of Integer r, again.remove(r) removes by INDEX (B2's trap):
        // IndexOutOfBoundsException: Index -3 out of bounds for length 6.
        // ArrayList<Integer> again = new ArrayList<>(List.of(12, -3, 7, -1, -8, 20));
        // for (Integer r : again) {
        //     if (r < 0) {
        //         again.remove(r);
        //     }
        // }
    }
}
