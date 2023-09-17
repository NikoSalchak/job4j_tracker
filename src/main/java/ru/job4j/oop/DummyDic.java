package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String word = "Неизвестное слово " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic unknownUser = new DummyDic();
        String say = "abrakadabra";
        System.out.println(unknownUser.engToRus(say));
    }
}
