package it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements SimplArray<T> {
    private Object[] data;
    private int possitions = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    @Override
    public boolean add(T model) {
        try {
            if (possitions == data.length) {
                data = Arrays.copyOf(data, 2 * possitions);
            }
            data[possitions++] = model;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void T set (int index, T model) {
        Objects.checkIndex(index, possitions);
        data[index] = model;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, possitions);
        T value  = (T) data[index];
        System.arraycopy(data, index + 1, data, index, data.length - index - 1);
        data[data.length - 1] = null;
        possitions--;
        return value;
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator<T> implements Iterator<T> {
            private int index = 0;
            private Object[] values;
            public SimpleArrayIterator(Object[] values) {
                this.values = values;
            }
            @Override
            public boolean hasNext() {
                return index < values.length;
            }
            @Override
            public T next() {
                return (T) values[index++];
            }
        }
        return new SimpleArrayIterator<T>(data);
    }

    public static void main(String[] args) {
        SimpleArray<String> strings = new SimpleArray<>(2);
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
