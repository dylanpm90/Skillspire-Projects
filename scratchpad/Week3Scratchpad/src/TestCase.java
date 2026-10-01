public class TestCase {
    public static void main() {
        // array declaration and assignment
        // type[] arrayName = new type[size];
        int[] intArrayName = new int[5]; // 5 integers in this arrazy
        intArrayName[0] =   10;
        intArrayName[1] =   20;
        intArrayName[2] =   30;
        intArrayName[3] =   40;
        intArrayName[4] =   50;

        // alternatively, the shorthand
        //type[] arrayName = {90, 85, 70, 40}
        String[] names = {"Joe", "Andy", "Ellie"};

        // print stuff
        System.out.println(intArrayName[2]);
        System.out.println(names[0]);

        //print the last element of the array.
        System.out.println(intArrayName[intArrayName.length - 1]);
    }
}


