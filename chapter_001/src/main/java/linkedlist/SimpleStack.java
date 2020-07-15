package linkedlist;

public class SimpleStack<E> {
    private ForwardLinked<E> linked = new ForwardLinked<E>();
    public E pop() {
        linked.get(linked.size() - 1);
        return linked.deleteLast();
    }

    public void push(E value) {
        linked.add(value);
    }
}
