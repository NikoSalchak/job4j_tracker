package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("/");
        String[] rightString = right.split("/");
        return leftString[0].equals(rightString[0]) ? left.compareTo(right) : rightString[0].compareTo(leftString[0]);
    }
}
