package week5.lab.answers.partB;

import java.util.ArrayList;
import java.util.List;

// B6 answer. Merge two lists into a new list with every name once, in the order first seen.
// contains() is a linear search, so this does up to (size of A + size of B) checks per name.
public class B6MergeMembers {
    public static void main(String[] args) {
        ArrayList<String> chess = new ArrayList<>(List.of("Ana", "Ben", "Cy"));
        ArrayList<String> hiking = new ArrayList<>(List.of("Cy", "Dee", "Ana", "Eve"));

        ArrayList<String> everyone = new ArrayList<>();
        for (String name : chess) {
            if (!everyone.contains(name)) {
                everyone.add(name);
            }
        }
        for (String name : hiking) {
            if (!everyone.contains(name)) {
                everyone.add(name);
            }
        }
        System.out.println(everyone);
        System.out.println("Members: " + everyone.size());
        System.out.println("Original lists unchanged: " + chess + " " + hiking);
    }
}
