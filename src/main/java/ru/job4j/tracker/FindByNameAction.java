package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("The items with the : " + name + " wasn't found.");
        }
        return true;
    }
}
