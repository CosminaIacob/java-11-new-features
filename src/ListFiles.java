import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get(args[0]))
                .forEach(System.out::println);
    }
}