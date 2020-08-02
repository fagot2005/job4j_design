package bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsolBot {
    public static void main(String[] args) {
        List<String> phrase = new ArrayList<>();
        List<String> logPhrase = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_002/data/questions.txt"));
             PrintWriter log = new PrintWriter(new FileWriter("./chapter_002/data/logBot.txt"))) {
            phrase = Arrays.asList(in.readLine().split(","));
            Scanner scanner = new Scanner(System.in);
            String welcom = "Hi, i'm happy Bot, talk with me";
            getPrintln(welcom);
            isAdd(logPhrase, welcom);
            for (int i = 0; i < 2;) {
                String answer = scanner.nextLine();
                if (answer.equals("Stop")) {
                    isAdd(logPhrase, answer);
                } else if (answer.equals("End")) {
                    isAdd(logPhrase, answer);
                    break;
                } else {
                    isAdd(logPhrase, answer);
                    int index = (int) (Math.random() * logPhrase.size());
                    String question = phrase.get(index);
                    isAdd(logPhrase, question);
                    getPrintln(question);
                }
            }
            for (String logPrase : logPhrase
            ) {
                log.println(logPrase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getPrintln(String str) {
        System.out.println(str);
    }

    private static boolean isAdd(List<String> logPhrase, String answer) {
        return logPhrase.add(answer + System.lineSeparator());
    }
}
