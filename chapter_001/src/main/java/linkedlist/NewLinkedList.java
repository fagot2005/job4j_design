package linkedlist;

import java.util.*;

public class NewLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;
    private int modCount;

    private static class Node<E> {
        E value;
        Node next;
        Node(E value) {
            this.value = value;
        }
        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node current = head;

            private int index;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = (E) current.value;
                current = current.next;
                index++;
                return value;
            }
        };
    }


    public static void main(String[] args) {
        NewLinkedList element = new NewLinkedList();
        element.add(21);
        element.add(13);
        element.add(14);
        element.add(15);
        element.add(16);
        for (int i = 0; i < element.size; i++) {
            System.out.println(element.get(i));
        }
        System.out.println("");
        System.out.println(element.get(2));
        System.out.println(element.get(8));
    }
}
