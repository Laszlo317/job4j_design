package ru.job4j.collection;

import java.util.*;
import java.util.LinkedList;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = grow();
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T prevValue = container[index];
        container[index] = newValue;
        return prevValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T prevValue = container[index];
        System.arraycopy(container, index + 1, container, index,
                container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return prevValue;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private final int expectedModCount = SimpleArrayList.this.modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[current++];
            }
        };
    }

    private T[] grow() {
        T[] rsl;
        if (container.length == 0) {
            rsl = (T[]) new Object[10];
        }
        rsl = Arrays.copyOf(container, container.length * 2);
        return rsl;

    }
}