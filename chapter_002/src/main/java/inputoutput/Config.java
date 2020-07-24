package inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String patch;
    private final Map<String, String> values = new HashMap<>();

    public Config(String patch) {
        this.patch = patch;
    }

    public static void main(String[] args) {
        Config config = new Config("chapter_002/data/pair_without_comment.properties");
        config.load();
    }

    public void load() {
        try (BufferedReader load = new BufferedReader(new FileReader(patch))) {
            load.lines()
                    .filter(x -> x.contains("="))
                    .forEach(x -> {
                        String[] res = x.split("=");
                        values.put(res[0], res[1]);
                    });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Don't found this file");
        }
    }

    public String value(String key) {
        //throw new UnsupportedOperationException("Don't impl this method yet!");
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.patch))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
