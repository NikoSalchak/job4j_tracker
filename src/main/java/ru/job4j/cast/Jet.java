package ru.job4j.cast;

public class Jet implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Летит по воздуху.");
    }

    @Override
    public void turns() {
        System.out.println(getClass().getSimpleName() + " может поворачивать в воздухе в любую сторону");
    }
}
