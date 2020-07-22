package inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> resaltList = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<String>();
            resaltList = new ArrayList<String>();
            in.lines().forEach(lines::add);
            for (String line : lines
            ) {
                String[] resalt = line.split(" ");
                if (resalt[resalt.length - 2].equals("404")) {
                    resaltList.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resaltList;
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
