package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeCollectionTest {

    @Test
    public void whenAddOneAndDellOne() {
        AnalizeCollection.UserColl userColl1 = new AnalizeCollection.UserColl(1, "12");
        AnalizeCollection.UserColl userColl2 = new AnalizeCollection.UserColl(2, "20");
        AnalizeCollection.UserColl userColl3 = new AnalizeCollection.UserColl(3, "24");
        AnalizeCollection.UserColl userColl4 = new AnalizeCollection.UserColl(4, "8");
        List<AnalizeCollection.UserColl> previous = new ArrayList<>();
        List<AnalizeCollection.UserColl> current = new ArrayList<>();
        previous.add(userColl1);
        current.add(userColl1);

        previous.add(userColl2);

        previous.add(userColl3);
        current.add(userColl3);

        current.add(userColl4);

        AnalizeCollection analizeCollection = new AnalizeCollection();
        int[] expected = {1, 0, 1};
        int[] resalt = analizeCollection.diff(previous, current);
        assertThat(resalt, is(expected));
    }

    @Test
    public void whenChengTwo() {
        AnalizeCollection.UserColl userColl2 = new AnalizeCollection.UserColl(2, "20");
        AnalizeCollection.UserColl userColl2rep = new AnalizeCollection.UserColl(2, "40");
        List<AnalizeCollection.UserColl> previous = new ArrayList<>();
        List<AnalizeCollection.UserColl> current = new ArrayList<>();
        previous.add(userColl2);
        current.add(userColl2rep);
        AnalizeCollection analizeCollection = new AnalizeCollection();
        int[] expected = {0, 1, 0};
        int[] resalt = analizeCollection.diff(previous, current);
        assertThat(resalt, is(expected));
    }
}