package it;

import java.lang.reflect.Array;
import java.util.Iterator;

public class SimpleArray<T> implements SimplArray<T> {
    private T[] data;
    public String model;

    @Override
    public boolean add(T model) {
        T[] temp = data;
        data = (T[]) new Array[temp.length];
        System.arraycopy(temp, 0, data, 0, temp.length);
        data[data.length - 1] = model;
        return true;
    }

    @Override
    public T set(int index, T model) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(data);
    }

    public static void main(String[] args) {
        SimpleArray<String> strings = new SimpleArray<>();
        strings.add("BMW");
        System.out.println(strings.get(0));
    }
}
