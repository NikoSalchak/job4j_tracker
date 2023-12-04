package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("/");
        String[] rightString = right.split("/");
        String l = leftString[0];
        String r = rightString[0];
        return l.equals(r) ? left.compareTo(right) : r.compareTo(l);
    }
}
