package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus AIRBUS = new Airbus("A320");
        System.out.println(AIRBUS);
        AIRBUS.printModel();
        AIRBUS.printCountEngine();

        Airbus secondAirbus = new Airbus("A380");
        secondAirbus.printModel();
        secondAirbus.printCountEngine();
        System.out.println(secondAirbus);

        AIRBUS.setName("A380");
        System.out.println(AIRBUS);
    }
}
