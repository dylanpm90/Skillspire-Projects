// Store 5 names in an ArrayList and print them in reverse order.

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReverseNames {
    public static  void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Nadine");

        ArrayList<String> resultList = revArrayList(names);

        printElements(names);
        printElements(resultList);

    }

    // Takes an arraylist as a parameter and returns
    // a reversed arraylist
    public static ArrayList<String> revArrayList(ArrayList<String> names) {
        // Arraylist for storing reversed elements
        ArrayList<String> reversedList = new ArrayList<String>();
        // for loop which grabs the last index on the list
        for (int i = names.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            reversedList.add(names.get(i));
            // Return the
        }
        return reversedList;
    }


    // Iterate through all the elements and print
    public static void printElements(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
