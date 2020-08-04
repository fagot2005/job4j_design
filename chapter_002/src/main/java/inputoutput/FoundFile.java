package inputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FoundFile {
    public static void main(String[] args) throws IOException {
        ArgFoundFileParam argFoundFileParam = new ArgFoundFileParam(args);
        argFoundFileParam.valid();
        List<Path> files = foundFiles(argFoundFileParam);
    }

    public static List<Path> foundFiles(ArgFoundFileParam argFoundFileParam) throws IOException {
        List<Path> paths = new ArrayList<>();
        SearchFiles searchFiles = (SearchFiles) ConditionFactory.newConditions(argFoundFileParam);
        fileTree(argFoundFileParam,  searchFiles);
        return paths;
    }

    private static void fileTree(ArgFoundFileParam argFoundFileParam, SearchFiles searchFiles) throws IOException {
        Files.walkFileTree(Path.of(argFoundFileParam.directiry()), searchFiles);
    }
}
