//5. Class Scope (Static Variables)
//
//Declared with static. Shared by all objects of the class.

public class Counter {
    static int count = 0;

    public Counter() {
        count++;
    }


    static void main(String[] args) {
        new Counter();
        new Counter();
        System.out.println(Counter.count); // 2
    }
}

