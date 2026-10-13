import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Paris");
        cities.add("Prague");
        cities.add(1, "Berlin");
        System.out.println(cities);

    }
}
