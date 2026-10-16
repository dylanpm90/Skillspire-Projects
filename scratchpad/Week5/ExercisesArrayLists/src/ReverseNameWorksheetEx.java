import java.util.ArrayList;

public class ReverseNameWorksheetEx {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Nadine");

        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));

        }
    }
}
