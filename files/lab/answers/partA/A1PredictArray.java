package week5.lab.answers.partA;

// A1 answer. It prints:
//   315 95 4
//   60
// total is 72 + 95 + 88 + 60 = 315. best starts at 72 and changes once, to 95.
// The array has 4 elements, and the last one, at index scores.length - 1, is 60.
public class A1PredictArray {
    public static void main(String[] args) {
        int[] scores = {72, 95, 88, 60};
        int best = scores[0];
        int total = 0;
        for (int s : scores) {
            total += s;
            if (s > best) {
                best = s;
            }
        }
        System.out.println(total + " " + best + " " + scores.length);
        System.out.println(scores[scores.length - 1]);
    }
}
