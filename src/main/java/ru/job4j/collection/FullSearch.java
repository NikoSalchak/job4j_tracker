package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        Set<Task> extracted = new HashSet<>(tasks);
        Set<String> resume = new HashSet<>();
        for (Task task : extracted) {
            String number = task.getNumber();
            resume.add(number);
        }
        return resume;
    }
}
