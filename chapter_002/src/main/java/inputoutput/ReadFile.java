package inputoutput;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {

        try {
            FileInputStream in = new FileInputStream("E:\\Java\\Java_Project\\job4j_design\\chapter_002\\src\\main\\resources\\even.txt");
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 != 0) {
                    System.out.println(line + " not even namber");
                } else {
                    System.out.println(line + " even namber");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
