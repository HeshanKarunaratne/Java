package theory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Heshan Karunaratne
 */
public class DeleteDirectories {

    public static void deleteDirectory(File file) throws IOException {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        deleteDirectory(f);
                    }
                }
            }
            Files.delete(file.toPath());
        }
    }

    public static void main(String[] args) throws IOException {
        deleteDirectory(new File("C:\\Users\\hkarunaratne\\Downloads\\delete\\here"));
        deleteDirectory(new File("C:\\Users\\hkarunaratne\\Downloads\\delete\\here2"));
    }
}
