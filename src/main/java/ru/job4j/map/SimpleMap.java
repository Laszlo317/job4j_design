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
        int overloadIndex = (int) Math.floor(table.length * LOAD_FACTOR);
        if (count >= overloadIndex) {
            expand();
        }
        int position = hash(Objects.hashCode(key)) % table.length;
        if (table[position] == null) {
            table[position] = new MapEntry<>(key, value);
            modCount++;
            count++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        int rsl = -1;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && hash(Objects.hashCode(table[i].key)) == hash) {
                rsl = i;
            }
        }
        return rsl;
    }

    private void expand() {
        table = Arrays.copyOf(table, table.length * 2);
    }

    @Override
    public V get(K key) {
        V rsl = null;
        for (MapEntry<K, V> kvMapEntry : table) {
            if (kvMapEntry != null && kvMapEntry.key == key) {
                rsl = kvMapEntry.value;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(Objects.hashCode(key)));
        if (index != -1) {
            table[index] = null;
            rsl = true;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {

            private int index;
            private final int expectedModCount = modCount;

            private int current;
            private int counter;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return counter < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                MapEntry<K, V>[] t = table;
                if (t != null && count > 0) {
                    do {
                        index = current;
                    } while (t[current++] == null);
                }
                MapEntry<K, V> rsl = table[index];
                counter++;
                return rsl.key;
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