package inputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FoundFile {
    public static void main(String[] args) throws IOException {
        ArgFoundFileParam argFoundFileParam = new ArgFoundFileParam(args);
        argFoundFileParam.valid();
        List<Path> files = foundFiles(argFoundFileParam);
    }

    public static List<Path> foundFiles(ArgFoundFileParam argFoundFileParam) throws IOException {
        List<Path> paths = new ArrayList<>();
        if (argFoundFileParam.mask().startsWith("m")) {
            //искать по маске, *.txt
            SearchFiles searchFiles = new SearchFiles(p -> p.toFile().getName().endsWith(argFoundFileParam.selection().substring(argFoundFileParam.selection().indexOf("."))));
            fileTree(argFoundFileParam, searchFiles);
            paths = searchFiles.getPaths();
        } else if (argFoundFileParam.mask().startsWith("f")) {
            //имя файла целиком
            SearchFiles searchFiles = new SearchFiles(p -> p.toFile().getName().startsWith(argFoundFileParam.selection()));
            fileTree(argFoundFileParam, searchFiles);
            paths = searchFiles.getPaths();
        } else if (argFoundFileParam.mask().startsWith("r")) {
            //регулярное выражение
            SearchFiles searchFiles = new SearchFiles(p -> p.toFile().getName().startsWith(argFoundFileParam.selection()));
            fileTree(argFoundFileParam, searchFiles);
            paths = searchFiles.getPaths();
        }
        return paths;
    }

    private static void fileTree(ArgFoundFileParam argFoundFileParam, SearchFiles searchFiles) throws IOException {
        Files.walkFileTree(Path.of(argFoundFileParam.directiry()), searchFiles);
    }
}
