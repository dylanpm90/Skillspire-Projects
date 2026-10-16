import java.util.ArrayList;

void main() {

    ArrayList<Integer> scores = new ArrayList<>(List.of(6, 2, 22, 4, 5));
    int maxResult = max(scores);
    System.out.println(maxResult);
}

static int max(ArrayList<Integer> a) {
    int max = 0;
    for (int i : a) {
        if (i > max) {
            max = i;
        }
    }
    return max;
}




