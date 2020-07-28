package inputoutput;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void pars(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String[] str = args[i].split("=");
            values.put(str[0].substring(1), str[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName name = new ArgsName();
        name.pars(args);
        return name;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
