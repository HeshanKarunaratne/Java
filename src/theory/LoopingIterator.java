package theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoopingIterator {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator<String> iterator = words.iterator();
        //Step1
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.equals("a")) {
                iterator.remove();
            }
        }
        //Step2
        words.removeIf(word -> word.equals("a"));
    }
}
