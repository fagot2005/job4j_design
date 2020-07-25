package inputoutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Analizy {
    public void unavailable(String sourse, String target) {
        String stringStream;
        boolean serverWork = true;
        String timeOf = "";
        String timeOn = "";
        try (BufferedReader input = new BufferedReader(new FileReader(sourse));
             BufferedWriter output = new BufferedWriter(new FileWriter(target))) {
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
                            output.write(timeOf + ", " + timeOn + System.lineSeparator());
                            //System.out.println(timeOf + ", " + timeOn + System.lineSeparator());
                            timeOf = "";
                            timeOn = "";
                        }
                    }
                    //System.out.println(stringStream);
                }
            } while (stringStream != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(str);
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("chapter_002/data/sourseAnalize.txt", "chapter_002/data/targetAnalize.txt");
    }
}
