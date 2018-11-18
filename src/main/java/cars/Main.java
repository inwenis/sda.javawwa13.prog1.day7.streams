package cars;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(classLoader.getResource("cars/fuel.csv").getFile());
        Path path = Paths.get(file.getAbsolutePath());
        List<String> allLInes = Files.readAllLines(path);

        allLInes
                .stream()
                .limit(10)
                .forEach(System.out::println);
    }
}
