package bot;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsolBot {
    public static void main(String[] args) {
                bot();
    }

    private static void bot() {
        List<String> logPhrase = new ArrayList<>();
        List<String> phrase = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_002/data/questions.txt"))) {
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
                    String question = randomQwestion(logPhrase, phrase);
                    isAdd(logPhrase, question);
                    getPrintln(question);
                }
            }
            write(logPhrase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String randomQwestion(List<String> logPhrase, List<String> phrase) {
        int index = (int) (Math.random() * logPhrase.size());
        return phrase.get(index);
    }

    private static void getPrintln(String str) {
        System.out.println(str);
    }

    private static boolean isAdd(List<String> logPhrase, String answer) {
        return logPhrase.add(answer + System.lineSeparator());
    }

    private static void write(List<String> logPhrase) throws IOException {
        try (PrintWriter log = new PrintWriter(new FileWriter("./chapter_002/data/logBot.txt"))) {
            for (String logPrase : logPhrase
            ) {
                log.println(logPrase);
            }
        }
    }
}
