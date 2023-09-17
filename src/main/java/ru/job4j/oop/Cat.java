package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
        System.out.println();
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("ate the kotleta");
        gav.show();
        System.out.println();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("ate the fish");
        black.show();
    }
}
