package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenCubeContainsUb() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).contains("ub");
    }

    @Test
    void whenTetrahedronStartsWithTEignoringCase() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).startsWithIgnoringCase("TE");
    }


    @Test
    void whenNumberOfVerticesEquals4() {
        Box box = new Box(4, 5);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isEqualTo(4);
    }

    @Test
    void whenNumberOfVerticesIsGreaterThan4() {
        Box box = new Box(8, 5);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isGreaterThan(4);
    }

    @Test
    void whenExists() {
        Box box = new Box(8, 5);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDoesntExists() {
        Box box = new Box(3, 5);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    void whenAreaIsEqualTo150() {
        Box box = new Box(8, 5);
        double rsl = box.getArea();
        assertThat(rsl).isCloseTo(150d, withPrecision(0.1d));
    }

    @Test
    void whenAreaIsEqualTo43point3() {
        Box box = new Box(4, 5);
        double rsl = box.getArea();
        assertThat(rsl).isCloseTo(43.3d, withinPercentage(5.0d));
    }

}