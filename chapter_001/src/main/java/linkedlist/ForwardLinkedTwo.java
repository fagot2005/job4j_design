package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedTwo<E> implements Iterable<E> {
    private Node<E> head;
    int size = 0;

    public void add(E value) {
        Node<E> node = new Node<E>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void revert() {
        Node<E> revert = head;
        Node<E> carent = revert.next;

        //int count = 1;
        while (carent != null) {
            Node<E> tmp = carent.next;
            carent.next = revert;
            revert = carent;
            carent = tmp;
            //System.out.println(count + " - tmp " + tmp.value + ", revert " + revert.value + ", carent " + carent.value + ", head " + head.value);
            //count++;
        }
        head = revert;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
