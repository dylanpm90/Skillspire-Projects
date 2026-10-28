package week5.lab.answers.partB;

import java.util.ArrayList;
import java.util.List;

// B7 answer (Stretch). Reverse a list in place with get and set, without Collections.reverse.
// Same two-pointer swap as Week 3's array reverse: front and back move toward the middle.
public class B7ReverseList {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        int front = 0;
        int back = nums.size() - 1;
        while (front < back) {
            int temp = nums.get(front);
            nums.set(front, nums.get(back));
            nums.set(back, temp);
            front++;
            back--;
        }
        System.out.println(nums);
    }
}
