package set;

import collection.SimpleArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    public int size;
    SimpleArray<E> set = new SimpleArray<>();

    public void add(E value) {
        if (equalsElement(value)) {
            set.add(value);
            size++;
        }
    }

    public boolean equalsElement(E element) {
        boolean res = false;
        int equalsElement = 0;
        if (size == 0) {
            res = true;
        } else {
            for (E el : set
            ) {
                if (el.equals(element)) {
                    equalsElement++;
                }
            }
            if (equalsElement == 0) {
                res = true;
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
