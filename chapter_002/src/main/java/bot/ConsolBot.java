package bot;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsolBot {
    public static void main(String[] args) throws IOException {
        bot();
    }

    public static List<String> reader(List<String> phrase) {
        try (BufferedReader in = new BufferedReader(new FileReader("./chapter_002/data/questions.txt"))) {
            phrase = Arrays.asList(in.readLine().split(","));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phrase;
    }

    private static void bot() throws IOException {
        String stop = "Stop";
        String end = "End";
        List<String> phrase = new ArrayList<>();
        List<String> logPhrase = new ArrayList<>();
        phrase = reader(phrase); //Arrays.asList(in.readLine().split(","));
        Scanner scanner = new Scanner(System.in);
        String welcom = "Hi, i'm happy Bot, talk with me";
        getPrintln(welcom);
        isAdd(logPhrase, welcom);
        for (int i = 0; true;) {
            String answer = scanner.nextLine();
            if (answer.equals(stop)) {
                isAdd(logPhrase, answer);
            } else if (answer.equals(end)) {
                isAdd(logPhrase, answer);
                break;
            } else {
                isAdd(logPhrase, answer);
                String question = randomQwestion(phrase);
                isAdd(logPhrase, question);
                getPrintln(question);
            }
        }
        write(logPhrase);
    }

    private static String randomQwestion(List<String> phrase) {
        int index = (int) (Math.random() * phrase.size());
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
