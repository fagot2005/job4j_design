package set;

import collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    SimpleArray<E> set = new SimpleArray<>();

    public void add(E value) {
        if (!equalsElement(value)) {
            set.add(value);
        }
    }

    public boolean equalsElement(E element) {
        boolean res = false;
        for (E el : set
        ) {
            if (Objects.equals(el, element)) {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    public static void main(String[] args) {
        SimpleSet<String> str = new SimpleSet<>();
        str.add("Ivan1");
        str.add("Ivan1");
        str.add("Ivan2");
        str.add("Ivan2");
        str.add("Ivan2");
    }
}
