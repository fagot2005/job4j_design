package tdd;

import java.util.Map;

public interface Generator {
    String produc(String template, Map<String, String> args);
}
