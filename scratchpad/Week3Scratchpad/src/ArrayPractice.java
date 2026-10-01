import java.util.Arrays;


public class ArrayPractice {
    public static void main(String[] args) {
        // log the names of adventurers in the party.
        String[] adventurerName = new String[3];
        adventurerName[0] = "Astrid";
        adventurerName[1] = "Bogdan";
        adventurerName[2] = "Constance";

        System.out.println("----= Adventurers =----");
        for (int i = 0; i < adventurerName.length; i++) {
            System.out.println("Adventurer Name: " + adventurerName[i]);
        }
        System.out.println("_______________________");

        // find the sum of every adventurer's carrying capacity
        System.out.println("----= Total carrying capacity =----");
        int[] carryingCapacity = {100, 90, 150};
        int totalCarryingCapacity = 0;
        for (int i : carryingCapacity) {
            totalCarryingCapacity += i;
        }
        System.out.println(totalCarryingCapacity);
        System.out.println("________________________");

        // sort hp for adventurers
        System.out.println("----= HP of Adventurers =----");
        int[] maxHP = {40, 60, 38};
        Arrays.sort(maxHP);
        System.out.println(Arrays.toString(maxHP));
        System.out.println("-----------------------------");
    }
}
