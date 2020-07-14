package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<E> implements Iterable<E> {
    //private Node<E> head;
    private int size;

    private int modCount;

    private Node head;

    public void addFirst(E value) {
        if (head == null) {
            head = new Node(value);
            size++;
            modCount++;
            return;
        }
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
        modCount++;
    }

    public void add(E value) {
        if (head == null) {
            head = new Node(value);
            size++;
            modCount++;
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(value, null);
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        int position = 0;
        Node current = head;
        while (position != index) {
            current = current.next;
            position++;
        }
        return (E) current.value;
    }

    public E deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E value = (E) head.value;
        head = head.next;
        size--;
        modCount++;
        return value;
    }

    public E deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            E value = (E) head.value;
            head = null;
            size--;
            modCount++;
            return value;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        E value = (E) current.value;
        current.next = null;
        size--;
        modCount++;
        return value;
    }

    public int size() {
        return this.size;
    }

    public void revert() {
        if (size < 2) {
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            Node tmpNext = current.next;
            current.next = prev;
            prev = current;
            current = tmpNext;
        }
        head = prev;
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
        Node next;
        Node(T value) {
            this.value = value;
        }
        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
