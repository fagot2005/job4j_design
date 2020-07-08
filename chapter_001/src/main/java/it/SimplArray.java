package it;

public interface SimplArray<T> extends Iterable<T> {
    public boolean add(T model);
    public T set(int index, T model);
    public void remove(int index);
    public T get(int index);
}
