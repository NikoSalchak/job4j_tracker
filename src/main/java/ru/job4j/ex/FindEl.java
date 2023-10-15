package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index] == key) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("the index wasn't found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
        String[] value = {"first", "second", "third", "fourth"};
        String key = "sixth";
        System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException el) {
            el.printStackTrace();
        }
    }
}
