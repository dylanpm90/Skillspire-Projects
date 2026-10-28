package week5.lab.answers.partB;

import java.util.ArrayList;
import java.util.List;

// B2 answer. Remove by index or by value? The comments show what each println prints.
public class B2RemoveTrap {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(5, 1, 4, 1));
        nums.remove(1);                     // an int argument is an INDEX: removes the 1 at index 1
        System.out.println(nums);           // [5, 4, 1]
        nums.remove(Integer.valueOf(1));    // an Integer argument is a VALUE: removes the first 1
        System.out.println(nums);           // [5, 4]
    }
}
