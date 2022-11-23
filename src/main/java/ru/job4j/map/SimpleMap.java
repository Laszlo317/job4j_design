package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        double threshold = Math.ceil(table.length * LOAD_FACTOR);
        int position = indexFor(Objects.hashCode(key));
        if (table[position] == null) {
            table[position] = new MapEntry<>(key, value);
            if (++count >= threshold) {
                expand();
            }
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return (table.length - 1) & hash(hash);
    }

    private void expand() {
        int index;
        MapEntry<K, V>[] t = new MapEntry[table.length << 1];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                index = hash(Objects.hashCode(entry.key));
                t[index] = entry;
            }
        }
        table = t;
    }

    @Override
    public V get(K key) {
        V rsl;
        int index = indexFor(Objects.hashCode(key));
        rsl = table[index] != null ? table[index].value : null;
        if ((key == null || Objects.equals(key, 0)) && key != table[index].key) {
            rsl = null;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(Objects.hashCode(key));
        if (index <= count && table[index] != null) {
            table[index] = null;
            rsl = true;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {

            private final int expectedModCount = modCount;

            private int current;
            private int counter;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (current < table.length && table[current] == null) {
                    current++;
                }
                return counter < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                counter++;
                return table[current++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}