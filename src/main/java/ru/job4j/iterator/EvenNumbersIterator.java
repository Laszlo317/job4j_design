package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int point = 0;


    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (point < data.length && !(data[point] % 2 == 0)) {
            point++;
        }
        return data.length > point;
    }

    @Override
    public Integer next() {
        int rsl;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        rsl = data[point++];
        return rsl;
    }

}