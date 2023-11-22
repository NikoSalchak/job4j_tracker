package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] l = left.split("\\.");
        String[] r = right.split("\\.");
        int x = Integer.parseInt(l[0]);
        int y = Integer.parseInt(r[0]);
        return Integer.compare(x, y);
    }
}
