package linkedlist;

import java.util.*;

public class NewLinkedList<E> implements Iterable<E> {
    private Node head;
    private int size;


    private static class Node<E> {

        private int valueNode;
        private Node next;
        public Node(int valueNode) {
            this.valueNode = valueNode;
        }

        public int getValueNode() {
            return valueNode;
        }

        public void setValueNode(int valueNode) {
            this.valueNode = valueNode;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public void add(int  value) {
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index) {
        //Objects.checkIndex(index, );
        int carentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (carentIndex == index) {
                return temp.getValueNode();
            } else {
                temp = temp.getNext();
                carentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        Node temp = head;
        int[] listElement = new int[size];
        for (int i = 0; i < size; i++) {
            listElement[i] = temp.getValueNode();
            temp = temp.getNext();
        }
        return Arrays.toString(listElement);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int index;
            private final int expectedModCount = size;

            @Override
            public boolean hasNext() {
                if (expectedModCount != size) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) index++;
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
        System.out.println(element);
        System.out.println(element.get(2));
        System.out.println(element.get(8));

    }
}
