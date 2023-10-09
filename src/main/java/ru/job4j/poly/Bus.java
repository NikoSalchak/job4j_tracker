package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        double price = price(100);
        double driverMoney = 3000;
        if (price == driverMoney) {
            System.out.println("Топливо заправлено, можно ехать");
        } else {
            System.out.println("Отсутствует топливо для поездки");
        }
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Количество пассажиров: " + passengers);
    }

    @Override
    public double price(double fuel) {
        double priceOneLitre = 30;
        return fuel * priceOneLitre;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.drive();
        bus.passengers(10);
    }
}
