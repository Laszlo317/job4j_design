package ru.job4j.collection;

import java.lang.management.OperatingSystemMXBean;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        Node<T> tail = head;
        Iterator<T> it = this.iterator();
        T deletedValue = it.next();
        Node<T> cutOffNode = null;
        if (head.next == null) {
            head = null;
        }
        while (it.hasNext()) {
            if (tail.next != null && tail.next.next == null) {
                cutOffNode = tail;
            }
            tail.value = it.next();
            tail = tail.next;
        }
        if (cutOffNode != null) {
            cutOffNode.next = null;
        }
        return deletedValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
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