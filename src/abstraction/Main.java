package abstraction;

import java.io.FileNotFoundException;

/**
 * @author Heshan Karunaratne
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = Constants.PATH;

        new NumberExtractorReport().prepareAndSendReport(path);
        new CapitalSimpleExtractorReport().prepareAndSendReport(path);

    }
}
