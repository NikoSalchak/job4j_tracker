package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle jet1 = new Jet();
        Vehicle train1 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle jet2 = new Jet();
        Vehicle[] vehicles = new Vehicle[] {jet1, train1, bus1, bus2, jet2};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.turns();
        }
    }
}
