package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Change the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Change the item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("The item changed successfully.");
        } else {
            out.println("Item change error");
        }
        return true;
    }
}
