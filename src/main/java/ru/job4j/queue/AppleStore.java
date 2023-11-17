package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    public final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String customer = "";
        for (int index = 0; index < count; index++) {
            customer = queue.poll().name();
        }
        return customer;
    }

    public String getFirstUpsetCustomer() {
        String customer = "";
        for (int index = 0; index < count; index++) {
            queue.poll().name();
        }
        customer = queue.poll().name();
        return customer;
    }
}
