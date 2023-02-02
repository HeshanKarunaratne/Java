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
        getNewWay();
    }

    private static void getNewWay() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            LOGGER.info(str);
        }
    }
}
