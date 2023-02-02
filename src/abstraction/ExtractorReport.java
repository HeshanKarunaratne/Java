package abstraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Heshan Karunaratne
 */
public abstract class ExtractorReport {
    private static final Logger LOGGER = Logger.getLogger(ExtractorReport.class.getName());

    public abstract Pattern getPattern();

    public abstract String getReportName();

    public abstract String clean(String input);

    public void prepareAndSendReport(String path) throws FileNotFoundException {
        LOGGER.info("started report " + getReportName() + "...\n");
        String report = parse(path);
        LOGGER.info(report);
        LOGGER.info("sent report " + getReportName() + "...\n");
    }

    private String parse(String path) throws FileNotFoundException {

        StringBuilder out = new StringBuilder("");
        File file = new File(path);

        try (Scanner scanner = new Scanner(file);) {
            
            if (scanner.hasNext()) {
                scanner.nextLine();
            } else {
                return "Empty file";
            }
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                Matcher matcher = getPattern().matcher(nextLine);

                boolean matches = matcher.matches();
                if (matches) {
                    out.append(clean(nextLine)).append("\n");
                }
            }
            return out.toString().isEmpty() ? "Empty File" : out.toString();
        }

    }

}
