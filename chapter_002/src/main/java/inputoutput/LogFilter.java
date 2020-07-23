package inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            lines = new ArrayList<String>();
            in.lines().filter(x -> x.contains("404")).forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String l:log
        ) {
            System.out.println(l);
        }
        //System.out.println(log);
    }
}
