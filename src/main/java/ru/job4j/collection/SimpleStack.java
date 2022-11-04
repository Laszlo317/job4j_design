package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.Stack;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}