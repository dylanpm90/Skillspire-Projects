import java.lang.reflect.Array;
import java.util.ArrayList;

public class Playlist {
    static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Since You've Been Gone");
        playlist.add("Break Stuff");
        playlist.add("In the Hall of the Mountain King");

        for (String song : playlist){
            System.out.println(song);
        }
    }
}
