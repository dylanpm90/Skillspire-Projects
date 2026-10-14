package week5.lab.answers.partA;

// A3 answer. Fixed version of the scope quiz. The three errors in the original were:
//   1. println(i):     i only exists inside the for loop       -> cannot find symbol
//   2. println(bonus): bonus only exists inside the loop body  -> cannot find symbol
//   3. println(total): a local variable has no default value   -> variable total might not have been initialized
// count is a static field, so it starts at 0 and is visible everywhere in the class.
public class A3ScopeQuiz {
    static int count;

    public static void main(String[] args) {
        int total = 0;                  // fix 3: give the local a starting value
        int i;                          // fix 1: declare i before the loop
        int bonus = 0;                  // fix 2: declare bonus before the loop
        for (i = 0; i < 3; i++) {
            bonus = 10;
            total += bonus;
            count++;
        }
        System.out.println(i);
        System.out.println(bonus);
        System.out.println(total);
        System.out.println(count);
    }
}
