package linkedlist;

public class SimpleStack<E> {
    private ForwardLinked<E> linked = new ForwardLinked<E>();
    public E pop() {
        E resalt = linked.get(linked.size() - 1);
        linked.deleteLast();
        return resalt;
    }

    public void push(E value) {
        linked.add(value);
    }
}
