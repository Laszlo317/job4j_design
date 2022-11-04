package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.Stack;

public class SimpleStack<T> {

    private int size;

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T rsl;
        rsl = linked.deleteFirst();
        size--;
        return rsl;
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public int size() {
        return size;
    }
}