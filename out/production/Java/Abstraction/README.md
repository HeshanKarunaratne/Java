Abstract Classes 
-   Cannot be instantiated
-   Abstract methods have no method body and need to be inside abstract class or interface
-   Avoid code duplication and increases reusability
-   Purpose of an abstract class is to function as a base for subclass
-   Encapsulate some common functionality in one place and let sub classes implement differences

Common Example
-   Open file
-   Read file
-   Abstract method(phone and email)
-   Send via email/slack

ExtractorReport.java
~~~java
public abstract class ExtractorReport {

    public abstract Pattern getPattern();

    public abstract String getReportName();

    public void prepareAndSendReport(String path) throws FileNotFoundException {
        System.out.println("started report " + getReportName() + "...\n");
        String report = parse(path);
        System.out.println(report);
        System.out.println("sent report " + getReportName() + "...\n");
    }

    private String parse(String path) throws FileNotFoundException {

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
            Matcher matcher = getPattern().matcher(nextLine);

            boolean matches = matcher.matches();
            if (matches) {
                out += nextLine + "\n";
            }
        }
        return out.isEmpty() ? "Empty File" : out;
    }

}
~~~

NumberExtractorReport.java
~~~java
public class NumberExtractorReport extends ExtractorReport {
    private static final Pattern PATTERN = Pattern.compile("^[0-9]*$");

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public String getReportName() {
        return "PhoneNumbers";
    }
}
~~~