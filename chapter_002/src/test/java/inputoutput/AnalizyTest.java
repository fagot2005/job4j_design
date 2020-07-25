package inputoutput;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenPairWithoutComment() {
        String soursePath = "./data/sourseAnalize.txt";
        String targetPath = "./data/targetAnalize.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(soursePath, targetPath);
        try (BufferedReader output = new BufferedReader(new FileReader(targetPath))) {
            assertThat(
                    output.readLine(), is ("10:57:01, 10:59:12"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}