import java.util.ArrayList;

public class CitySorter {
    static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Chicago");
        cities.add("dallas");
        cities.add("NEW YORK CITY");
        cities.add("LoS aNgElEs");

        // without sorting
        System.out.println("Unsorted: " + cities);
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case Insensitive Sorting: " + cities);

    }


}
