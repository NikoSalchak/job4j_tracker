package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по дороге.");
    }

    @Override
    public void turns() {
        System.out.println(getClass().getSimpleName() + " может повернуть куда угодно");
    }
}
