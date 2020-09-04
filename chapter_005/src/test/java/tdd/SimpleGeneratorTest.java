package tdd;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;


public class SimpleGeneratorTest {

    @Test
    @Ignore
    public void whenTemplateComplete() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Ivan",
                "subject", "you"
        );
        String out = generator.produc(template, map);
        Assert.assertThat(
                out,
                Is.is("I am a Ivan, Who are you?")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenNotEnough() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Ivan"
        );
        String out = generator.produc(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenExtraArgs() {
        Generator generator = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map map = Map.of(
                "name", "Ivan",
                "subject", "you",
                "something", "something"
        );
        String out = generator.produc(template, map);
    }
}