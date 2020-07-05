package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = point; i < data.length; i++) {
            if (point < data.length && data[i] % 2 == 0) {
                res = true;
                break;
            } else {
                point++;
            }
        }
        return res;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
