package linkedlist;

public class SimpleStack<E> {
    private ForwardLinked<E> linked = new ForwardLinked<E>();

    public E pop() {
        return linked.deleteLast();
    }

    public void push(E value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return linked.size() == 0;
    }
}
