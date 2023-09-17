package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        System.out.println("Колобок пытается сбежать от волка");
        wolf.tryEat(ball);
        System.out.println("Колобок пытается сбежать от зайца");
        hare.tryEat(ball);
        System.out.println("Колобок пытается сбежать от лисы");
        fox.tryEat(ball);
    }
}
