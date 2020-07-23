package inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        save(log, "404.txt");
        for (String l:log
        ) {
            System.out.println(l);
        }
    }

    private static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String str:log
            ) {
                out.write(str + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File " + file + " not assecc for writing");
        }
    }
}
