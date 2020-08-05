package inputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FoundFile {
    public static void main(String[] args) throws IOException {
        ArgFoundFileParam argFoundFileParam = new ArgFoundFileParam(args);
        argFoundFileParam.valid();
        Predicate<Path> condition = ConditionFactory.newConditions(argFoundFileParam);
        FoundFile foundFile = new FoundFile();
        List<Path> files = FoundFile.foundFiles(argFoundFileParam, condition);
        foundFile.writeLog(argFoundFileParam, files);
    }

    private void writeLog(ArgFoundFileParam argFoundFileParam, List<Path> files) throws IOException {
        Files.write(
                Path.of(argFoundFileParam.output()),
                files.stream().map(Path :: toString)
                        .collect(Collectors.toList()));
    }

    public static List<Path> foundFiles(ArgFoundFileParam argFoundFileParam, Predicate<Path> conditions) throws IOException {
        SearchFiles sf = new SearchFiles(conditions);
        Files.walkFileTree(Path.of(argFoundFileParam.directiry()), sf);
        return sf.getPaths();
    }
}
