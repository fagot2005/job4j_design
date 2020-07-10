package it;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements SimplArray<T> {
    private Object[] data;
    private int possitions = 0;

    public SimpleArray() {
        this.data = new Object[2];
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
    public T set(int index, T model) {
        data[index] = model;
        return null;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < data.length; i++) {
            if (i + 1 == data.length) {
                data[data.length - 1] = null;
            } else {
                data[i] = data[i + 1];
            }
        }
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<T>(data);
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
