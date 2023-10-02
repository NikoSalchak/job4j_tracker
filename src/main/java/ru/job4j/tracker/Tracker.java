package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        size = 0;
        Item[] rsl = new Item[items.length];
        for (Item item1 : items) {
            if (item1 != null) {
                rsl[size] = item1;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        int counter = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < size; i++) {
            Item temp = items[i];
            if (temp.getName().equals(key)) {
                rsl[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(rsl, counter);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}