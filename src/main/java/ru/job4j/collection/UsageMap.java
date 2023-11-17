package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String>map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("nikosalchak@gmail.com", "Niko Salchak Mergenovich");
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
