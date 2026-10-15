package week5.lab.answers.partB;

import java.util.ArrayList;

// B1 answer. The comments show the list after each line. It prints:
//   [Cy, Ben, Eve]
//   3 true 2
public class B1TraceList {
    public static void main(String[] args) {
        ArrayList<String> q = new ArrayList<>();
        q.add("Ana");           // [Ana]
        q.add("Ben");           // [Ana, Ben]
        q.add(0, "Cy");         // [Cy, Ana, Ben]
        q.add("Dee");           // [Cy, Ana, Ben, Dee]
        q.remove(1);            // [Cy, Ben, Dee]     index 1 held Ana
        q.set(2, "Eve");        // [Cy, Ben, Eve]     replaces Dee
        System.out.println(q);
        System.out.println(q.size() + " " + q.contains("Ben") + " " + q.indexOf("Eve"));
    }
}
