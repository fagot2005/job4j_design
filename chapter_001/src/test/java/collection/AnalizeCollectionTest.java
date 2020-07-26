package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class AnalizeCollectionTest {

    @Test
    public void whenAddTwo() {
        AnalizeCollection.UserColl userColl1 = new AnalizeCollection.UserColl(1, "12");
        //AnalizeCollection.UserColl userColl2 = new AnalizeCollection.UserColl(2, "20");
        AnalizeCollection.UserColl userColl3 = new AnalizeCollection.UserColl(3, "24");
        AnalizeCollection.UserColl userColl4 = new AnalizeCollection.UserColl(4, "8");
        AnalizeCollection.UserColl userColl8 = new AnalizeCollection.UserColl(8, "22");
        AnalizeCollection.UserColl userColl7 = new AnalizeCollection.UserColl(7, "50");
        AnalizeCollection.UserColl userColl6 = new AnalizeCollection.UserColl(6, "6");
        List<AnalizeCollection.UserColl> previous = new ArrayList<>();
        List<AnalizeCollection.UserColl> current = new ArrayList<>();
        previous.add(userColl1);
        current.add(userColl1);
        previous.add(userColl3);
        current.add(userColl3);
        previous.add(userColl6);
        current.add(userColl4);
        previous.add(userColl7);
        AnalizeCollection analizeCollection = new AnalizeCollection();
        AnalizeCollection.Info expectedResult = new AnalizeCollection.Info(1, 0, 2);
        AnalizeCollection.Info add = analizeCollection.diff(previous, current);
        assertThat(add, is(expectedResult));
        //System.out.println(previous);
    }

    @Test
    public void whenChengTwo() {
        AnalizeCollection.UserColl userColl1 = new AnalizeCollection.UserColl(1, "12");
        AnalizeCollection.UserColl userColl2 = new AnalizeCollection.UserColl(2, "20");
        AnalizeCollection.UserColl userColl2rep = new AnalizeCollection.UserColl(2, "40");
        AnalizeCollection.UserColl userColl3 = new AnalizeCollection.UserColl(3, "24");
//        AnalizeCollection.UserColl userColl4 = new AnalizeCollection.UserColl(4, "8");
//        AnalizeCollection.UserColl userColl8 = new AnalizeCollection.UserColl(8, "22");
//        AnalizeCollection.UserColl userColl7 = new AnalizeCollection.UserColl(7, "50");
//        AnalizeCollection.UserColl userColl6 = new AnalizeCollection.UserColl(6, "6");
        List<AnalizeCollection.UserColl> previous = new ArrayList<>();
        List<AnalizeCollection.UserColl> current = new ArrayList<>();
        previous.add(userColl1);
        current.add(userColl1);

        previous.add(userColl2);
        current.add(userColl2);

        previous.add(userColl3);
        current.add(userColl3);

        current.set(userColl2, userColl2rep);
        AnalizeCollection analizeCollection = new AnalizeCollection();
        AnalizeCollection.Info expectedResult = new AnalizeCollection.Info(1, 0, 2);
        AnalizeCollection.Info add = analizeCollection.diff(previous, current);
        assertThat(add, is(expectedResult));
        //System.out.println(previous);
    }
}