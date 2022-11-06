package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size = 0;

    private Node<E> head;

    private int modCount;

    @Override

    public void add(E value) {
        modCount++;
        Node<E> tail = head;
        Node<E> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size + 1);
        E rsl = null;
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        rsl = node.item;
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> pointer = head;
            private E lastReturned;

            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
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
                return lastReturned;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}