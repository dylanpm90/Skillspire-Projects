public class ComputeAverageExercise {
    static void main(String[] args) {
        // write a program to calculate the average of the grades
        gradesAverage();
        int[] numbers = {90, 85, 78, 92};
        int[] minArr = {0, 6, 9};
        int minNum = findMin(minArr);
        System.out.println("min num: " + minNum);
        int numberOfEvens = countEvens(numbers);
        System.out.println("number of evens: " + numberOfEvens);
    }

    public static void gradesAverage() {
        int[] grades = {88, 90, 70, 65, 100};
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = (double) sum / grades.length;
        System.out.println("Average: " + average);
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int countEvens(int[] arr) {

        int count = 0;
        for (int i : arr)
            if (i % 2 == 0) {
                count++;
            }
        return count;
    }

}
