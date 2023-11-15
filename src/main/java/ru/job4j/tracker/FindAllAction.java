package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show All the items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all the items ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("The storage doesn't have items.");
        }
        return true;
    }
}
