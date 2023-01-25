package Abstraction;

import java.io.FileNotFoundException;

/**
 * @author Heshan Karunaratne
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ExtractorReport extractorReport = new NumberExtractorReport();
        extractorReport.prepareAndSendReport("C:\\Users\\hkarunaratne\\Desktop\\Coding\\Java\\src\\Abstraction\\data.txt");
    }
}
