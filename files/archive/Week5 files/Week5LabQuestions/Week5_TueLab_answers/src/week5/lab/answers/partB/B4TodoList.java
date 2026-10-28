package week5.lab.answers.partB;

import java.util.ArrayList;

// B4 answer. A to-do list: add, insert at the front, remove by value, replace the last item,
// then print with numbers that start at 1.
public class B4TodoList {
    public static void main(String[] args) {
        ArrayList<String> todo = new ArrayList<>();
        todo.add("Buy milk");
        todo.add("Wash car");
        todo.add("Study Java");

        todo.add(0, "Pay rent");                        // insert at the front
        todo.remove("Buy milk");                        // done: remove by value
        todo.set(todo.size() - 1, "Study ArrayList");   // replace the last item

        for (int i = 0; i < todo.size(); i++) {
            System.out.println((i + 1) + ". " + todo.get(i));
        }
        System.out.println("Tasks left: " + todo.size());
    }
}
