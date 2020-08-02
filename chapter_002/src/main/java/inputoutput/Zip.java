package inputoutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void pasckFiles(List<File> sourses, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File sours : sourses
            ) {
                zip.putNextEntry(new ZipEntry(sours.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sours))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> foundFiles(ArgZip argZip) throws IOException {
        SearchFiles searchFiles = new SearchFiles(p -> !p.toFile().getName().startsWith(argZip.exclude()));
        Files.walkFileTree(Path.of(argZip.directiry()), searchFiles);
        return searchFiles.getPaths();
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.valid();
        List<Path> files = foundFiles(argZip);
        Zip zip = new Zip();
        Stream<Path> stream = files.stream();
        Stream<File> fileStream = stream.map(Path::toFile);
        zip.pasckFiles(fileStream.collect(Collectors.toList()), new File(argZip.output()));
    }
}
