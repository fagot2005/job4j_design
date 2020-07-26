package inputoutput;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() throws IOException {
        File targetPath = folder.newFile("targetAnalize.txt");
        String soursePath = "./data/sourseAnalize.txt";
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