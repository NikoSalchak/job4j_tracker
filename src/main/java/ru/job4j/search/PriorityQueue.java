package ru.job4j.search;

import java.util.LinkedList;

/**
 * класс описывает работу простейщей очереди по приоритету, которая
 * по принципу FIFO(first in - first out)
 * @author Niko Salchak
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * хранение задания осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Если встречаются 2 задания с динаковым приоритетом, то в очереди
     * они распределеяются по принципу FIFO.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
        System.out.println(tasks);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */
    public Task take() {
        return tasks.poll();
    }
}
