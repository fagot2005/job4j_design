package inputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get("E:\\Java\\Java_Project\\job4j_design");
        search(start, p -> p.toFile().getName().endsWith(".java")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> ext) throws IOException {
        SearchFiles searcher = new SearchFiles(ext);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
