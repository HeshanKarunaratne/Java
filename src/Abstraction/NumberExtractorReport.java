package Abstraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Heshan Karunaratne
 */
public class NumberExtractorReport {

    public String parse(String path) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        String out = "";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        if (scanner.hasNext()) {
            scanner.nextLine();
        } else {
            return "Empty file";
        }
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            Matcher matcher = pattern.matcher(nextLine);

            boolean matches = matcher.matches();
            if (matches) {
                out += nextLine + "\n";
            }
        }
        return out.isEmpty() ? "Empty File" : out;
    }

    public void prepareAndSendReport(String path) throws FileNotFoundException {
        System.out.println("started process\n");
        String report = parse(path);
        System.out.println(report);
        System.out.println("sent report");
    }
}
