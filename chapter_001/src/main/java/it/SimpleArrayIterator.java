package it;

import java.util.Iterator;

public class SimpleArrayIterator<T> implements Iterator<T> {
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
