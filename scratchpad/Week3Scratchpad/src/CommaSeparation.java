public class CommaSeparation {

    public static void main(String[] args) {
        int[] intArray = {234, 808, 342};
        String[] results = toString(intArray);
    }
    public static String toString(int[] arr) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0, n = arr.length; i < n; i++) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(arr[i]);
        }
        return buf.toString();
    }
}
