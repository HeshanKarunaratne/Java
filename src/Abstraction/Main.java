package Abstraction;

import java.io.FileNotFoundException;

/**
 * @author Heshan Karunaratne
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        NumberExtractorReport numberExtractorReport = new NumberExtractorReport();
        numberExtractorReport.prepareAndSendReport("C:\\Users\\hkarunaratne\\Desktop\\Coding\\Java\\src\\Abstraction\\data.txt");
    }
}
