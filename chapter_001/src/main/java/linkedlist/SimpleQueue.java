package linkedlist;

public class SimpleQueue<E> {
    private final SimpleStack<E> in = new SimpleStack<>();
    private final SimpleStack<E> out = new SimpleStack<>();

    public E poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(E value) {
        in.push(value);
    }
}
