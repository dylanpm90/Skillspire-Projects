package week5.lab.answers.partB;

import java.util.ArrayList;
import java.util.List;

// B3 answer. Average, count above a line, and the index of the smallest value.
// Finding the coldest day is a linear search: one pass, n steps for n days.
public class B3Temperatures {
    public static void main(String[] args) {
        ArrayList<Integer> temps = new ArrayList<>(List.of(68, 74, 81, 77, 65, 79, 83));

        int total = 0;
        int warmDays = 0;
        int coldestIndex = 0;
        for (int i = 0; i < temps.size(); i++) {
            int t = temps.get(i);
            total += t;
            if (t > 75) {
                warmDays++;
            }
            if (t < temps.get(coldestIndex)) {
                coldestIndex = i;
            }
        }
        double average = (double) total / temps.size();

        System.out.println("Average: " + average);
        System.out.println("Days above 75: " + warmDays);
        System.out.println("Coldest day: index " + coldestIndex + ", " + temps.get(coldestIndex) + " degrees");
    }
}
