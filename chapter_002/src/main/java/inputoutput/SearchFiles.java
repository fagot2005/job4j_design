package inputoutput;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles {
    private Predicate<File> predicate;
    private List<Path> paths = new LinkedList();

    public SearchFiles(Predicate<File> predicate) {
        this.predicate = predicate;
    }


}
