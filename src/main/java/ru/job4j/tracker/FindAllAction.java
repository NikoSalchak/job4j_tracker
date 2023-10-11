package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Show All the items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Show all the items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The storage doesn't have items.");
        }
        return true;
    }
}
