package Abstraction;

import java.io.FileNotFoundException;

/**
 * @author Heshan Karunaratne
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\hkarunaratne\\Desktop\\Coding\\Java\\src\\Abstraction\\data.txt";

        new NumberExtractorReport().prepareAndSendReport(path);
        new CapitalSimpleExtractorReport().prepareAndSendReport(path);



    }
}
