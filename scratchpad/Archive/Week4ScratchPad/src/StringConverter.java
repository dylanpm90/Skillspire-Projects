public class StringConverter {
    static void main(String[] args) {
        // make these integers in this array become Strings
        int[] arrayOfIntegers = {1, 3, 4, 13};

        // store the returned array of strings in a variable
        String[] storageStringArray = toString(arrayOfIntegers);

        // print
        for (int i = 0; i <= storageStringArray.length - 1; i++){
            System.out.print(storageStringArray[i]);
        }
    }


    // method to convert int array into string array
    public static String[] toString(int[] arr) {
        // the integers, once converted to strings
        // will be stored in this array "becomesString"
        String[] becomesString = new String[arr.length];
        // iterate through the array and use concatenation
        // to convert the integer to a string.
        for (int i = 0; i <= arr.length - 1; i++) {
            if (i == arr.length - 1) {
                // the last integer in the array gets a period
                becomesString[i] = arr[i] + ". ";
            } else {
                // everything else is separated by a comma
                becomesString[i] = arr[i] + ", ";
            }
        }
        // return the String array
        return becomesString;
    }

}
