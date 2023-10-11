package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Shut down the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("The program shut down");
        return false;
    }
}
