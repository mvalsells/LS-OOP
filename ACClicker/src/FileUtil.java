import java.io.*;
import java.util.Scanner;

public class FileUtil {

    public static String readTextFile(String path) throws FileNotFoundException {
        FileReader read = new FileReader(path);
        StringBuilder fileContent = new StringBuilder();
        Scanner scanner = new Scanner(read);
        while (scanner.hasNextLine()) {
            fileContent.append(scanner.nextLine());
        }
        return fileContent.toString();
    }
}