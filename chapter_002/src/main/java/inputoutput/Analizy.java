package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String sourse, String target) {
        String stringStream;
        boolean serverWork = true;
        String timeOf = "";
        String timeOn = "";
        List<String> parsingResalt = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(sourse))) {
            do {
                stringStream = input.readLine();
                if (stringStream == null) {
                    break;
                }
                if (!stringStream.equals("")) {
                    String[] str = stringStream.split(" ");
                    if (serverWork == true && (str[0].equals("400") || str[0].equals("500"))) {
                        serverWork = false;
                        timeOf = str[1];
                        timeOn = "";
                    } else if (serverWork == false && (str[0].equals("200"))) {
                        serverWork = true;
                        timeOn = str[1];
                        if (!timeOf.equals("") && !timeOn.equals("")) {
                            parsingResalt.add(timeOf + ", " + timeOn);
                            timeOf = "";
                            timeOn = "";
                        }
                    }
                }
            } while (stringStream != null);
            writer(parsingResalt, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writer(List<String> parsing, String target) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
            for (int i = 0; i < parsing.size(); i++) {
                output.write(parsing.get(i) + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("chapter_002/data/sourseAnalize.txt", "chapter_002/data/targetAnalize.txt");
    }
}
