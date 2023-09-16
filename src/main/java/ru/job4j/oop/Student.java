package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("i can sing song: " + lyrics);
    }

    public void sing() {
        System.out.println("i believe i can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "i believe i can fly";
        petya.music(song);
    }
}
