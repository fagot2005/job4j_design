package qache;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cache implements Cach<String, String> {
    private String dir;
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    public Cache(String name) {
        this.dir = dir;
    }

    @Override
    public String get(String key) throws IOException {
        String content = "";
        if (cache.containsKey(key)) {
            content = cache.get(key).get();
            if (content == null) {
                content = readFile(key);
                cache.put(key, new SoftReference<>(content));
            }
            else {
                content = readFile(key);
                cache.put(key, new SoftReference<>(content));
            }
        }
        return content;
    }

    @Override
    public void put(String key, String value) {
        cache.put(key, new SoftReference<>(value));
    }

    private String readFile(String name) throws IOException {
        Path path = Path.of(dir, name);
        File file = path.toFile();
        if (file.exists()) {
            throw new IllegalArgumentException("Invalide name of file");
        }
        return Files.readAllLines(path).stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
