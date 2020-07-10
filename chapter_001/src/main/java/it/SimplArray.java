package it;

public interface SimplArray<T> extends Iterable<T> {
    boolean add(T model);
    T set(int index, T model);
    void remove(int index);
    T get(int index);
}
