package collection;

import it.SimplArray;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

    private int countElement;
    private int possitions;
    private T[] array;
    private T[] tempArray;

    public SimpleArray() {
        this.countElement = 10;
        this.array = (T[]) new Object[countElement];
    }

    public T get(int index) {
        return array[index];
    }

    public void add(T model) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                break;
            }
            if (i == array.length - 1) {
                this.tempArray = (T[]) new Object[array.length];
                System.arraycopy(array, 0, tempArray, 0, array.length);
                this.array = (T[]) new Object[array.length + 10];
                System.arraycopy(tempArray, 0, array, 0, tempArray.length);
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return array[possitions++];
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
