package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам.");
    }

    @Override
    public void turns() {
        System.out.println(getClass().getSimpleName() + " поворачивает если есть пути для поворота.");
    }
}
