package qache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private String name;
    private String content;
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    public Cache(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Map<String, SoftReference<String>> put(String name, String content) {

    }

    public String get(String name) {

    }
}
