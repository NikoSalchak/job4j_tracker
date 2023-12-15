package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityQueueTest {

    @Test
    public void whenHigherPrioritySecond() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc()).isEqualTo("urgent");
    }

    @Test
    public void whenHigherPriorityEquals() {
        var queue = new PriorityQueue();
        queue.put(new Task("Low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("Middle", 5));
        var result = queue.take();
        assertThat(result.getDesc()).isEqualTo("Low");
    }

    @Test
    public void whenHigherPriorityFirst() {
        var queue = new PriorityQueue();
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 6));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc()).isEqualTo("urgent");
    }
}