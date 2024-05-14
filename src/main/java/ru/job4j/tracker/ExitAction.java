package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Shut down the program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("The program shut down");
        return false;
    }
}
