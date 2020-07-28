package it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] data = new Object[200];
    private int possitions = 0;

    public void add(T model) {
        data[possitions++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, possitions);
        data[index] = model;
    }

    public T remove(int index) {
        Objects.checkIndex(index, possitions);
        T value = (T) data[index];
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        data[data.length - 1] = null;
        possitions--;
        return value;
    }

    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < possitions;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[index++];
            }
        };
    }


    public static void main(String[] args) {
        SimpleArray<String> strings = new SimpleArray<>();
        strings.add("BMW");
        strings.add("AUDY");
        strings.add("MERCEDESS");
        strings.add("FORD");
        strings.add("RENO");
        System.out.println(strings.get(0));
        strings.set(0, "Ferrary");
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));
        strings.remove(1);
        System.out.println(strings.get(1));
    }
}
