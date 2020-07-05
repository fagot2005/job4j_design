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
        return (nextEvenPossition(data, point) >= 0) ?  true : false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[nextEvenPossition(data, point)];
    }

    public int nextEvenPossition (int[] data, int point) {
        int possition = 0;
        if (point == 0) {
            possition = point;
        } else {
            possition = point + 1;
        }
        for (int i = possition; i < data.length; i++) {
            if (possition < data.length && data[i] % 2 == 0) {
                possition = i;
                break;
            } else {
                possition = -1;
            }
        }
        return possition;
    }
}
