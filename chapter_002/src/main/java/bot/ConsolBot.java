package bot;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ConsolBot {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(".\\chapter_002\\data\\questions.txt"));
             PrintWriter log = new PrintWriter(new FileWriter(".\\chapter_002\\data\\logBot.txt"))) {
            String[] inputQuestion = in.readLine().split(",");
            Scanner scanner = new Scanner(System.in);
            String welcom = "Hi, i'm happy Bot, talk with me";
            System.out.println(welcom);
            log.println(welcom + System.lineSeparator());
            for (int i = 0; i < 2;) {
                String answer = scanner.nextLine();
                if (answer.equals("Stop")) {
                    log.println(answer + System.lineSeparator());
                } else if (answer.equals("End")) {
                    log.println(answer + System.lineSeparator());
                    break;
                } else {
                    log.println(answer + System.lineSeparator());
                    String question = inputQuestion[(int) (Math.random() * inputQuestion.length)];
                    log.println(question + System.lineSeparator());
                    System.out.println(question);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
