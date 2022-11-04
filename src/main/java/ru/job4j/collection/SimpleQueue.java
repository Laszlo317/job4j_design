package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T rsl = null;
        if (out.size() == 0) {
            while (in.size() != 0) {
                out.push(in.pop());
            }
        }
        rsl = out.pop();
        return rsl;
    }

    public void push(T value) {
        in.push(value);
    }
}