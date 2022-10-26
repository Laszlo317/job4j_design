package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void whenThereIsNoEquationSign() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"Doesn't", "Contain="};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not "
                        + "contain the symbol \"=\"", strings[0]));
    }

    @Test
    void whenThereIsNoKey() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"Doesn'=t", "=Contain"};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a key", strings[1]));
    }

    @Test
    void whenThereIsNoValue() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {"Doesn'=t", "Contain="};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain a value", strings[1]);
    }

    @Test
    void whenParseArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] strings = {};
        assertThatThrownBy(() -> nameLoad.parse(strings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

}