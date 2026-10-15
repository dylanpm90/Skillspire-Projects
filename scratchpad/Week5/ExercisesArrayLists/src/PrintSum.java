import java.util.ArrayList;

public class PrintSum {
    static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        int sumCalcResult = SumCalc(numbers);
        System.out.println(sumCalcResult);

    }

    public static int SumCalc(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}