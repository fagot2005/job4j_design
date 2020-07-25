package tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class SimpleTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.foundBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        tree.Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.foundBy(7).isPresent(),
                is(false)
        );
    }
}