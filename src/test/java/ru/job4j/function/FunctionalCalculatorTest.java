package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalCalculatorTest {
    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenSquareFunctionThenSquareResults() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(2, 7, x -> 5 * Math.pow(x, 2) + 4 * x + 3);
        List<Double> expected = Arrays.asList(31D, 60D, 99D, 148D, 207D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunctionThenExponentialResult() {
        FunctionalCalculator function = new FunctionalCalculator();
        List<Double> result = function.diapason(5, 9, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D, 64D);
        assertThat(result).containsAll(expected);
    }

}