package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Delete the item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "The item deleted successfully." : "Item delete error.");
        return true;
    }
}
