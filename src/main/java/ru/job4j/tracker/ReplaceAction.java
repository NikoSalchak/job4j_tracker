package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Change the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Change the item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("The item changed successfully.");
        } else {
            System.out.println("Item change error");
        }
        return true;
    }
}
