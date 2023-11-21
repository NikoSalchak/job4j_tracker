package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void compareByNameAscension() {
        List<Item> items = Arrays.asList(
                new Item(1, "Test1"),
                new Item(2, "secondTest"),
                new Item(4, "THIRDTest")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "THIRDTest"),
                new Item(1, "Test1"),
                new Item(2, "secondTest")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void compareByNameDesc() {
        List<Item> items = Arrays.asList(
                new Item(10, " "),
                new Item(77, "Name"),
                new Item(6, "AAA")
        );
        items.sort(new ItemDescByName());
        System.out.println(items);
        List<Item> expected = Arrays.asList(
                new Item(77, "Name"),
                new Item(6, "AAA"),
                new Item(10, " ")
        );
        assertThat(items).isEqualTo(expected);
    }
}