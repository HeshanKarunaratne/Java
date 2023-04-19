Try-Catch-Finally

~~~java
package theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * @author Heshan Karunaratne
 */
public class TryWithResources {
    private static final Logger LOGGER = Logger.getLogger(TryWithResources.class.getName());

    public static void main(String[] args) throws Exception {
        getOldWay();
        getNewWay();
    }

    private static void getOldWay() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            LOGGER.info(str);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } finally {
            br.close();
        }
    }

    private static void getNewWay() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            LOGGER.info(str);
        }
    }
}
~~~

# N-Tier Architecture

![Diagram](resources/images/N-Tier-Architecture1.PNG "Diagram")

Above is a 3-Layer diagram

- Deleting an item while looping: Use an iterator
~~~java
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
~~~