package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size = 0;

    private Node<E> first;
    private Node<E> last;

    private Node<E> pointer;

    private int modCount;

    @Override
    public void add(E value) {
        modCount++;
        Node<E> prev = last;
        Node<E> node = new Node<>(prev, value, null);
        last = node;
        if (prev == null) {
            first = node;
        } else {
            prev.next = node;
        }
        size++;
    }

    @Override
    public E get(int index) {
        E rsl = null;
        Node<E> node = first;
        Objects.checkIndex(index, size);
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                rsl = node.item;
                break;
            }
            node = node.next;
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int counter;
            E lastReturned;

            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (counter == 0) {
                    pointer = first;
                }
                return pointer != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = pointer.item;
                pointer = pointer.next;
                counter++;
                return lastReturned;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}