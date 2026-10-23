// 22. Add a static method to an interface Util named
// join(List<String>) that returns a single joined string with commas;
// call it without an instance.

import java.util.ArrayList;
import java.util.List;

public class StringJoinerUtilExercise {

    interface Util{
        static String join(List<String> sInput){
            return sInput + ",";
        }
    }

    void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("Example");
        String result = Util.join(stringList);
        System.out.println(result);
    }
}
