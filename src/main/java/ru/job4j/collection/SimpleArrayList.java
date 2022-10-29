package ru.job4j.collection;

import java.util.*;

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
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T prevValue;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        prevValue = container[index];
        container[index] = newValue;
        return prevValue;
    }

    @Override
    public T remove(int index) {
        T prevValue;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        prevValue = container[index];
        System.arraycopy(container, index + 1, container, index,
                container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return prevValue;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
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
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[current++];

            }

        };
    }
}