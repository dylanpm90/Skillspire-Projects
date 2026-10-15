public class VarArgs {
    static int sum(int... nums){
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }
    

    static void main(String[] args) {
        int result = sum(1, 2, 3, 4);
        System.out.println(result);
    }
}
