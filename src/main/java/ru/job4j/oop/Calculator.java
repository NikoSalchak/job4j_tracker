package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = Calculator.sum(10);
        int rsl = calculator.multiply(5);
        int rslMinus = Calculator.minus(8);
        int rslDivide = calculator.divide(20);
        int sumAll = calculator.sumAllOperation(5);
        System.out.println(result);
        System.out.println(rsl);
        System.out.println(rslMinus);
        System.out.println(rslDivide);
        System.out.println(sumAll);
    }
}
