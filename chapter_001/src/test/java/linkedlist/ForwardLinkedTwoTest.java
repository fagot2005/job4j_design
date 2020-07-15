package linkedlist;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ForwardLinkedTwoTest {
    @Test
    public void whenAddThenIter() {
        ForwardLinkedTwo<Integer> linked = new ForwardLinkedTwo<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedTwo<Integer> linked = new ForwardLinkedTwo<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.add(6);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }
}