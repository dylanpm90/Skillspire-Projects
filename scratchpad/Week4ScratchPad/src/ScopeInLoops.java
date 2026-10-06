import java.util.Arrays;

public class ScopeInLoops {
    static void main(String[] args) {
        if (true) {
            int z = 7;
        }
        int z = z + 1;

    }


}
