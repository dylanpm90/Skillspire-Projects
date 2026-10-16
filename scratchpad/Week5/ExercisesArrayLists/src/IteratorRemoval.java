import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorRemoval {
    static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("keep", "drop", "keep"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("drop")) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}
