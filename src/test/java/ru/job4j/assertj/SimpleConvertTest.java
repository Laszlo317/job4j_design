package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list)
                .allSatisfy(e -> {
                    assertThat(e.length()).isLessThan(7);
                    assertThat(e).doesNotContain("six");
                })
                .containsAnyOf("three", "second", "four")
                .filteredOn(e -> e.contains("e"))
                .element(1)
                .isEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set)
                .doesNotContain("six")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .filteredOnAssertions(e -> assertThat(e).startsWith("f"))
                .filteredOnAssertions(e -> assertThat(e).endsWith("t"))
                .first()
                .isEqualTo("first");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "2", "3", "4");
        assertThat(map)
                .containsEntry("2", 1)
                .doesNotContainKey("6")
                .hasSize(4)
                .containsValues(2, 3);
    }

}