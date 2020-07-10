package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int modCaunt;
    private int possitions = 0;
    private Object[] container = new Object[10];

        public T get(int index) {
            Objects.checkIndex(index, possitions);
        return (T) container[index];
    }

    public void add(T model) {
            if (possitions == container.length) {
                container = Arrays.copyOf(container, 2 * possitions);
            }
            container[possitions++] = model;
            modCaunt++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(container);
    }

    public static void main(String[] args) {
        SimpleArray<String> str = new SimpleArray<>();
        str.add("Ivan1");
        str.add("Ivan2");
        str.add("Ivan3");
        str.add("Ivan4");
        str.add("Ivan5");
        str.add("Ivan6");
        str.add("Ivan7");
        str.add("Ivan8");
        str.add("Ivan9");
        str.add("Ivan10");
        str.add("Ivan11");
        str.add("Ivan12");
        str.add("Ivan13");
        str.add("Ivan15");
        str.add("Ivan16");
        System.out.println(str.get(14));
    }
}
