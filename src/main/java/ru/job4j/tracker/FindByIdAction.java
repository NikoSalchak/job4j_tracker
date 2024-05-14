package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("The item with the entered id: " + id + " wasn't found.");
        }
        return true;
    }
}
