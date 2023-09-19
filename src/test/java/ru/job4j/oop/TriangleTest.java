package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    @Test
    public void when00And40And04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when55And78And250Then3() {
        Point a = new Point(5, 5);
        Point b = new Point(7, 8);
        Point c = new Point(25, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 35;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when55And78And250Then35() {
        Point a = new Point(5, 5);
        Point b = new Point(5, 5);
        Point c = new Point(5, 5);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}
