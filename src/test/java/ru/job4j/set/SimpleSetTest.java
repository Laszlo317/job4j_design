package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenIterate() {
        Set<Integer> set = new SimpleSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            it.next();
        }
        assertThat(it.hasNext()).isFalse();
    }
}