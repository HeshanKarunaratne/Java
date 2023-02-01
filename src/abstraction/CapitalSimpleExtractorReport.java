package abstraction;

import java.util.regex.Pattern;

/**
 * @author Heshan Karunaratne
 */
public class CapitalSimpleExtractorReport extends ExtractorReport {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z]+$");

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public String getReportName() {
        return "CapitalAndSimple";
    }

    @Override
    public String clean(String input) {
        return input.toLowerCase();
    }

}
